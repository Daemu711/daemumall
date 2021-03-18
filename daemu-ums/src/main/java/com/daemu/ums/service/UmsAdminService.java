package com.daemu.ums.service;

import com.daemu.ums.model.bo.UmsAdmin;
import com.daemu.ums.model.dto.UmsAdminParamDto;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author Deamu
 * @since 2021-02-07
 */
public interface UmsAdminService extends IService<UmsAdmin> {
    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParamDto umsAdminParamDto);

    /**
     *  登录返回Token
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);
}
