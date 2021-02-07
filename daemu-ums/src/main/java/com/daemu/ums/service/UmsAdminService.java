package com.daemu.ums.service;

import com.daemu.ums.model.UmsAdmin;
import com.daemu.ums.model.dto.UmsAdminParam;
import com.baomidou.mybatisplus.extension.service.IService;

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
    UmsAdmin register(UmsAdminParam umsAdminParam);
}
