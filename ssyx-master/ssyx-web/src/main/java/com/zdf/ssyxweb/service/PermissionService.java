package com.zdf.ssyxweb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zdf.internalcommon.entity.Permission;
import com.zdf.internalcommon.response.QueryAllMenuResponseDto;
import com.zdf.internalcommon.result.ResponseResult;

import java.util.List;

/**
* @author mrzhang
* @description 针对表【permission(权限)】的数据库操作Service
* @createDate 2024-05-12 22:48:03
*/
public interface PermissionService extends IService<Permission> {
    ResponseResult<List<QueryAllMenuResponseDto>> queryAllMenu();
}
