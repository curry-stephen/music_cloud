package com.yy.service;

import com.yy.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
public interface AdminService extends IService<Admin> {
    boolean veritypasswd(String name, String password);
}
