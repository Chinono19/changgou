package com.chinono.service;

import com.alibaba.fastjson.JSON;
import com.chinono.feign.SkuFeign;
import com.chinono.po.Cart;
import com.chinono.po.CartItem;
import com.chinono.po.OneSkuResult;
import com.chinono.po.User;
import com.chinono.utils.BaseResult;
import com.chinono.vo.CartVo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CartService {
    @Resource
    private SkuFeign skuFeign;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 添加到购物车
     * @param loginUser
     * @param cartVo
     */
    public void addCart(User loginUser, CartVo cartVo){
        BaseResult<OneSkuResult> baseResult = skuFeign.findById(cartVo.getSkuid());
        OneSkuResult oneSkuResult = baseResult.getData();

        //封装cartiem
        //2 封装CartItem
        CartItem cartItem = new CartItem();
        cartItem.setSkuid( oneSkuResult.getSkuid() );
        cartItem.setSpuid( oneSkuResult.getSpuid() );
        cartItem.setGoodsName( oneSkuResult.getGoodsName() );
        cartItem.setPrice( oneSkuResult.getPrice() );
        cartItem.setCount( cartVo.getCount() );
        cartItem.setChecked( cartVo.getChecked() );
        cartItem.setMidlogo( oneSkuResult.getLogo().get("biglogo") );
        cartItem.setSpecInfoIdTxt( JSON.parseObject(oneSkuResult.getSpecInfo().get("id_txt"), Map.class));
        //从redis中获取购物车 如果没有创建一个新的购物车
        String carJson = stringRedisTemplate.opsForValue().get("cart" + loginUser.getId());
        Cart cart = null;
        if (carJson != null){
            cart = JSON.parseObject(carJson,Cart.class);
        }else{
            cart = new Cart();
        }
        //把数据添加到购物车中
        cart.addToCart(cartItem);
        //把购物车保存到redis中
        carJson = JSON.toJSONString(cart);
        stringRedisTemplate.opsForValue().set("cart"+loginUser.getId(),carJson);

    }

    /**
     * 查询当前用户的购物车
     * @param user
     * @return
     */
    public Cart queryCartList(User user){
        String jsonStr = stringRedisTemplate.opsForValue().get("cart" + user.getId());

        //返回
        Cart cart = JSON.parseObject(jsonStr, Cart.class);
        return cart;
    }

    /**
     * 跟新购物车中的数据
     * @param user
     * @param cartVoList
     */
    public void updateCart(User user, List<CartVo> cartVoList){
        //从redis中获取到购物车
        String cartStr = stringRedisTemplate.opsForValue().get("cart" + user.getId());
        if (cartStr == null){
            throw  new RuntimeException("购物车不存在");
        }
        Cart cart = JSON.parseObject(cartStr,Cart.class);
        //处理请求数据
        HashMap<Integer, CartVo> map = new HashMap<>();
        for (CartVo cartVo : cartVoList) {
            map.put(cartVo.getSkuid(),cartVo);
        }

        //请求数据和redis中存放进行对比
        for (CartItem cartItem : cart.getData().values()) {
            //如果是一样的 购物项
            CartVo cartVo = map.get(cartItem.getSkuid());
            if (cartVo!=null){
                cart.updateCart(cartVo.getSkuid(), cartVo.getCount(),cartVo.getChecked());

            }else{
                //删除
                cart.deleteCart(cartItem.getSkuid());
            }
        }
        //跟新购物车
        stringRedisTemplate.opsForValue().set("cart"+user.getId(),
                JSON.toJSONString(cart));
    }
}
