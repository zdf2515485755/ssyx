package com.zdf.ssyxweb.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zdf.internalcommon.request.InsertRoleRequestDto;
import com.zdf.internalcommon.request.PageQueryRequestDto;
import com.zdf.internalcommon.request.UpdateRoleRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.ssyxweb.service.impl.RoleServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *@Description API for operating roles
 *@Author mrzhang
 *@Date 2024/5/11 21:33
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleServiceImpl roleService;

    @GetMapping("/selectRole")
    public ResponseResult<Page> selectRole(@Validated @RequestBody PageQueryRequestDto pageQueryRequestDto){
        return roleService.selectRole(pageQueryRequestDto);
    }

    @PostMapping("/insertRole")
    public ResponseResult<Integer> insertRole(@Validated @RequestBody InsertRoleRequestDto insertRoleRequestDto){
        return roleService.insertRole(insertRoleRequestDto);
    }

    @PutMapping("/updateRole")
    public ResponseResult<Integer> updateRole(@Validated @RequestBody UpdateRoleRequestDto updateRoleRequestDto){
        return roleService.updateRole(updateRoleRequestDto);
    }

    @DeleteMapping("/deleteRole/{id}")
    public ResponseResult<Integer> deleteRole(@NotNull @PathVariable("id") Long id){
        return roleService.deleteRole(id);
    }

    @DeleteMapping("/batchDelete")
    public ResponseResult<Integer> batchDeleteRole(@NotEmpty @RequestParam("ids") Long[] ids){
        return roleService.batchDeleteRole(ids);
    }
}
