package com.yy.service.impl;

import com.yy.pojo.Consumer;
import com.yy.dao.ConsumerMapper;
import com.yy.service.ConsumerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@Service
public class ConsumerServiceImp extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {
@Autowired
ConsumerMapper consumerMapper;
    @Override
    public boolean insert(Consumer consumer) {
        return consumerMapper.insert(consumer)>0?true:false;
    }

    @Override
    public boolean updateUserMsg(Consumer consumer) {
        return consumerMapper.updateUserMsg(consumer)>0?true:false;
    }

    @Override
    public boolean updateUserAvator(Consumer consumer) {
        return consumerMapper.updateUserAvator(consumer)>0?true:false;
    }

    @Override
    public boolean existUser(String username) {
        return consumerMapper.existUsername(username)>0?true:false;
    }

    @Override
    public boolean veritypasswd(String username, String password) {
        return consumerMapper.verifyPassword(username,password)>0?true:false;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return consumerMapper.deleteUser(id)>0?true:false;
    }

    @Override
    public List<Consumer> allUser() {
        return consumerMapper.allUser();
    }

    @Override
    public List<Consumer> userOfId(Integer id) {
        return consumerMapper.userOfId(id);
    }

    @Override
    public List<Consumer> loginStatus(String username) {
        return consumerMapper.loginStatus(username);
    }
}
