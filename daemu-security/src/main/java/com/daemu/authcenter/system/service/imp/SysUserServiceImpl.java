package com.daemu.authcenter.system.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daemu.authcenter.system.mapper.SysUserMapper;
import com.daemu.authcenter.system.model.bo.SysUser;
import com.daemu.authcenter.system.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Deamu
 * @since 2021-01-19
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysUserMapper userMapper;

    @Override
    public SysUser findUserByUsername(String username) {
        SysUser user = userMapper.selectOne(new QueryWrapper<SysUser>().eq("username", username));
        return user;
    }
}
