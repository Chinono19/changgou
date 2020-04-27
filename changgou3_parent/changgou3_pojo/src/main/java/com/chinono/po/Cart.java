package com.chinono.po;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/** 购物车：一个购物车存放多个购物项
 * Created by liangtong.
 */
@Data
public class Cart {
    //存放多个购物项，需要使用集合，可以选择的集合：List、Set、Map 等
    //选择集合目的：符合我们实际需求，购物车存在大量的快速查询的情况，Map集合适合快速查询。
    private Map<Integer , CartItem>  data = new HashMap<>();

    //推荐字段你，用于存放总价
    private Double total;

    //覆盖total使用@Data默认getter方法
    public Double getTotal() {
        //总价：所有小计的和
        //小计：单价 * 数量
        double sum = 0;
        for (CartItem cartItem : data.values()) {
            sum += (cartItem.getPrice() * cartItem.getCount());
        }
        this.total = sum;
        return total;
    }


    public void addToCart(CartItem cartItem){
        //将购物项添加到购物车中
        // 如果购物车中没有当前购物项直接添加
        // 如果购物车中有当前购物项，将更新购物车的数量（进行累加操作）

        //1 从data中获得购物车
        CartItem temp = data.get(cartItem.getSkuid());

        //2 不存在直接添加
        if(temp == null) {
            data.put(cartItem.getSkuid() , cartItem);
        } else {
            //3 存在，累加操作
           temp.setCount( temp.getCount() + cartItem.getCount() );
        }

    }

    /**
     * 从购物车中移除
     * @param skuid
     */
    public void deleteCart(Integer skuid){
        data.remove(skuid);
    }

    /**
     * 更新数据
     * @param skuid
     * @param count
     * @param checked
     */
    public void updateCart(Integer skuid, Integer count , boolean checked){
        //如果skuid存在，将更新数据
        CartItem temp = data.get(skuid);
        if(temp != null) {
            temp.setCount(count);
            temp.setChecked(checked);
        }

    }



}
