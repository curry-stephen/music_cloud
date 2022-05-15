package com.yy.service.impl;

import com.yy.pojo.Admin;
import com.yy.dao.AdminMapper;
import com.yy.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@Service
public class AdminServiceImp extends ServiceImpl<AdminMapper, Admin> implements AdminService {
@Autowired
private AdminMapper  adminMapper;
    @Override
    public boolean veritypasswd(String name, String password) {
        return adminMapper.verifyPassword(name,password)>0?true:false;
    }
}
