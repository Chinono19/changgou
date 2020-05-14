package com.chinono.service;

import com.alibaba.fastjson.JSON;
import com.chinono.feign.SkuFeign;
import com.chinono.mapper.AddressMapper;
import com.chinono.mapper.OrderGoodsMapper;
import com.chinono.mapper.OrderMapper;
import com.chinono.po.*;
import com.chinono.utils.IdWorker;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;

@Service
public class OrderService {

    @Resource
    private OrderGoodsMapper orderGoodsMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private IdWorker idWorker;

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private SkuFeign skuFeign;

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    /**
     * TODO 下订单
     * @param user
     * @param orderVo
     * @return
     */
    public Long addOrder(User user, OrderVo orderVo){
        //1 创建订单对象
        Order order = new Order();
        //1.1 序列号（采用雪花算法）
        long sn = idWorker.nextId();
        order.setSn(sn);
        //1.2 封装收获人信息（冗余字段，方便查询）
        Address address = addressMapper.selectByPrimaryKey(orderVo.getAddressId());
        order.setShrName( address.getShrName() );
        order.setShrMobile( address.getShrMobile() );
        order.setShrProvince( address.getShrProvince());
        order.setShrCity( address.getShrCity());
        order.setShrArea( address.getShrArea() );
        order.setShrAddress( address.getShrAddress() );
        //1.3 系统自动生成数据
        order.setCreatedAt(new Date());
        order.setUpdatedAt(order.getCreatedAt());
        order.setStatus(0);
        //1.4 用户信息
        order.setUserId(Long.parseLong(user.getId()+""));
        //2 获得购物车
        String cartStr = stringRedisTemplate.opsForValue().get("cart" + user.getId());
        Cart cart = JSON.parseObject(cartStr, Cart.class);
        double total = 0;
        //2.1  处理选中购物项(购买具体商品)，需要转换成 OrderGoods
        // 2.1.1 构建OrderGoods对象
        Iterator<CartItem> it = cart.getData().values().iterator();
        while (it.hasNext()){
            CartItem cartItem = it.next();
            if (cartItem.getChecked()){
                OrderGoods orderGoods = new OrderGoods();
                // 2.1.2  填充数据：订单的序列号、商品信息
                orderGoods.setSn( sn );
                orderGoods.setSkuId( cartItem.getSkuid() );
                orderGoods.setSpuId( cartItem.getSpuid() );
                orderGoods.setNumber( cartItem.getCount() );
                orderGoods.setSpecList( JSON.toJSONString( cartItem.getSpecInfoIdTxt() ));
                orderGoods.setSkuName( cartItem.getGoodsName() );
                orderGoods.setLogo( cartItem.getMidlogo());
                orderGoods.setPrice( cartItem.getPrice() );
                // 2.1.3 保存
                orderGoodsMapper.insert(orderGoods);
                // 2.1.4 修改库存
                skuFeign.updateSkuNum(cartItem.getSkuid(),cartItem.getCount());
                // 2.1.6 计算勾选的总价
                it.remove();
                total += ( cartItem.getCount() * cartItem.getPrice() );
            }
        }

        //2.2 订单总价（从购物车总价）-- 所有勾选综合
        order.setTotalPrice(total);
        //3 保存订单
        orderMapper.insert(order);
        //4 将购物车对象写入redis
        stringRedisTemplate.opsForValue().set("cart"+user.getId(),JSON.toJSONString(cart));
        //5 将订单的序列号返回
        return sn;
    }


    /**
     * 修改指定订单号的状态
     * @param sn
     * @param status
     */
    public void updateOrderStatus(String sn, String status) {
        orderMapper.updateOrderStatus( sn , status );
    }
}
