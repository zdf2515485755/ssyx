package com.zdf.ssyxweb.service;

import com.zdf.internalcommon.entity.Role;
import com.zdf.internalcommon.request.AssignRoleRequestDto;
import com.zdf.internalcommon.result.ResponseResult;

import java.util.List;

/**
 * @Description UserService
 * @Author mrzhang
 * @Date 2024/5/12 21:12
 */
public interface UserService {
    ResponseResult<List<Role>> selectRoleByUserId(Long userId);
    ResponseResult<String> assignRole(AssignRoleRequestDto assignRoleRequestDto);
}
