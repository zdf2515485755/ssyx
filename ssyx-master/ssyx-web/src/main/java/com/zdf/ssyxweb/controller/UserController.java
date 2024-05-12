package com.zdf.ssyxweb.controller;

import com.zdf.internalcommon.entity.Role;
import com.zdf.internalcommon.request.AssignRoleRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.ssyxweb.service.impl.UserServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *@Description API for operating user
 *@Author mrzhang
 *@Date 2024/5/12 20:37
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @GetMapping("/selectRoleByUserId/{id}")
    public ResponseResult<List<Role>> selectRoleByUserId(@NotNull @PathVariable("id") Long userId) {
        return userService.selectRoleByUserId(userId);
    }

    @PostMapping("/assignRole")
    public ResponseResult<String> assignRole(@Validated @RequestBody AssignRoleRequestDto assignRoleRequestDto){
        return userService.assignRole(assignRoleRequestDto);
    }
}
