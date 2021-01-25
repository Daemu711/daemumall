package com.daemu.authcenter.system.controller;


import com.daemu.authcenter.system.mapper.SysUserMapper;
import com.daemu.authcenter.system.model.bo.SysUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Deamu
 * @since 2021-01-19
 */
@RestController
@RequestMapping("/sys-user")
@RequiredArgsConstructor
public class SysUserController {
    private  final SysUserMapper sysUserMapper;

    @GetMapping(value = "getByUsername")
    public SysUser getUserByUsername(String name){
        return   sysUserMapper.selectById(1);
    }
}

