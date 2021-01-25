package com.daemu.authcenter.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daemu.authcenter.system.model.bo.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectOneByUsername(@Param("param") String username);

}
