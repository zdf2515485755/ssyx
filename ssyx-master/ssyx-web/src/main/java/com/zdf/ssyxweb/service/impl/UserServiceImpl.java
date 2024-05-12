package com.zdf.ssyxweb.service.impl;

import com.zdf.internalcommon.entity.AdminRole;
import com.zdf.internalcommon.entity.Role;
import com.zdf.internalcommon.request.AssignRoleRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.ssyxweb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *@Description UserServiceImpl
 *@Author mrzhang
 *@Date 2024/5/12 21:13
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private RoleServiceImpl roleService;
    @Resource
    private AdminRoleServiceImpl adminRoleService;

    @Override
    public ResponseResult<List<Role>> selectRoleByUserId(Long userId) {
        return roleService.selectRoleByUserId(userId);
    }

    @Override
    public ResponseResult<String> assignRole(AssignRoleRequestDto assignRoleRequestDto) {
        adminRoleService.deleteAdminRoleByUserId(assignRoleRequestDto.getAdminId());
        List<Long> roleIdList = assignRoleRequestDto.getRoleIdList();
        roleIdList.forEach(roleId->{
            AdminRole adminRole = AdminRole.builder()
                    .adminId(assignRoleRequestDto.getAdminId())
                    .roleId(roleId).build();
            adminRoleService.addAdminRole(adminRole);
        });
        return ResponseResult.success("success");
    }
}
