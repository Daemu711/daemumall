package com.daemu.authcenter.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daemu.authcenter.system.model.bo.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Deamu
 * @since 2021-01-19
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     *
     * @param username
     * @return
     */
    @Select("select  * from sys_user where username = #{username}  ")
    SysUser selectSysUser(@Param("username") String username);

}
