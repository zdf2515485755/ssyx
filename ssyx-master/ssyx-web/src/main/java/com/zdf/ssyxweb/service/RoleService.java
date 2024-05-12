package com.zdf.ssyxweb.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zdf.internalcommon.entity.Role;
import com.zdf.internalcommon.request.InsertRoleRequestDto;
import com.zdf.internalcommon.request.PageQueryRequestDto;
import com.zdf.internalcommon.request.UpdateRoleRequestDto;
import com.zdf.internalcommon.result.ResponseResult;

/**
* @author mrzhang
* @description 针对表【role(角色)】的数据库操作Service
* @createDate 2024-05-11 20:38:31
*/
public interface RoleService extends IService<Role> {
    ResponseResult<Page> selectRole(PageQueryRequestDto pageQueryRequestDto);
    ResponseResult<Integer> insertRole(InsertRoleRequestDto insertRoleRequestDto);
    ResponseResult<Integer> updateRole(UpdateRoleRequestDto updateRoleRequestDto);
    ResponseResult<Integer> deleteRole(Long id);
    ResponseResult<Integer> batchDeleteRole(Long[] ids);
}
