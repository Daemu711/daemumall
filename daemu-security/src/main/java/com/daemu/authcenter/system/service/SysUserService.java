package com.daemu.authcenter.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.daemu.authcenter.system.model.bo.SysUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Deamu
 * @since 2021-01-19
 */
public interface SysUserService {
    SysUser findUserByUsername(String username);
}
