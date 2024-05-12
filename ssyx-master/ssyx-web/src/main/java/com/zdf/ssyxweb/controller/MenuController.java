package com.zdf.ssyxweb.controller;

import com.zdf.internalcommon.response.QueryAllMenuResponseDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.ssyxweb.service.impl.PermissionServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *@Description API for operating menu
 *@Author mrzhang
 *@Date 2024/5/12 23:06
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private PermissionServiceImpl permissionService;

    @GetMapping("/queryAllMenu")
    public ResponseResult<List<QueryAllMenuResponseDto>>queryAllMenu(){
        return permissionService.queryAllMenu();
    }
}
