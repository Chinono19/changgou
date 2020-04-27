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

@Service
@Transactional
public class CartService {
    @Resource
    private SkuFeign skuFeign;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


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
        cartItem.setMidlogo( oneSkuResult.getSpecInfo().get("biglogo") );
        cartItem.setSpecInfo( JSON.toJSONString(oneSkuResult.getSpecInfo()) );
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
}
