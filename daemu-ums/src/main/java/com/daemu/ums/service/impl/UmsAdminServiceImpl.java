package com.daemu.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daemu.ums.mapper.UmsAdminMapper;
import com.daemu.ums.model.UmsAdmin;
import com.daemu.ums.model.dto.UmsAdminParam;
import com.daemu.ums.service.UmsAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author Deamu
 * @since 2021-02-07
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        return null;
    }
}
