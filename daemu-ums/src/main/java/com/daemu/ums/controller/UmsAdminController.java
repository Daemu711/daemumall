package com.daemu.ums.controller;


import com.daemu.commons.api.CommonResult;
import com.daemu.ums.model.UmsAdmin;
import com.daemu.ums.model.dto.UmsAdminParam;
import com.daemu.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author Deamu
 * @since 2021-02-07
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "后台用户管理",value = "UmsAdminController")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    @ResponseBody
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdminParam umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

}

