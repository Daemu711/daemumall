package com.daemu.authcenter.system.service.imp;


import com.daemu.authcenter.system.model.SysUserDetails;
import com.daemu.authcenter.system.model.bo.SysUser;
import com.daemu.authcenter.system.service.SysUserService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: wj
 * @date: 2020/4/23 14:31
 * @Description:
 */
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SysUserService sysUserService;
//    private final SysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.findUserByUsername(s);
        if (sysUser == null) {
            throw new UsernameNotFoundException(s);
        }
        SysUserDetails sysUserDetails = new SysUserDetails(sysUser);
        // 获取权限
//        List<SysPermission> permissionList = sysPermissionService.findByUserId(sysUser.getId());
//        List<SimpleGrantedAuthority> authorityList = Lists.newArrayList();
//        if(permissionList != null) {
//            permissionList.forEach(sysPermission -> {
//                if(sysPermission.getType() > 0) {
//                    authorityList.add(new SimpleGrantedAuthority(sysPermission.getValue()));
//                }
//            });
//        }

        return sysUserDetails;
    }
}
