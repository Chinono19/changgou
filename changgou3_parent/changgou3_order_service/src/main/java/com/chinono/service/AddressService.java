package com.chinono.service;

import com.chinono.mapper.AddressMapper;
import com.chinono.po.Address;
import com.chinono.po.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AddressService {

    @Resource
    private AddressMapper addressMapper;

    /**
     * 查找指定用户的所有收货的地址
     * @param userId
     * @return
     */
    public List<Address> findAllByUid(Integer userId){
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        //查询
        return addressMapper.selectByExample(example);
    }


    /**
     * 添加地址
     */
    public void addAddress(User user,Address address){
        //TODO 将之前默认地址 isdefault更新为0
        addressMapper.updateDefault(user.getId(),0);

        //完善数据
        // 1）用户
        address.setUserId(user.getId());
        // 2) 默认值 1
        address.setIsdefault(1);

        //添加
        this.addressMapper.insert(address);
    }
}
