package com.zdf.ssyxweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdf.internalcommon.constant.StatusCode;
import com.zdf.internalcommon.entity.Role;
import com.zdf.internalcommon.request.InsertRoleRequestDto;
import com.zdf.internalcommon.request.PageQueryRequestDto;
import com.zdf.internalcommon.request.UpdateRoleRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.ssyxweb.mapper.RoleMapper;
import com.zdf.ssyxweb.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Objects;

/**
* @author mrzhang
* @description 针对表【role(角色)】的数据库操作Service实现
* @createDate 2024-05-11 20:38:31
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public ResponseResult<Page> selectRole(PageQueryRequestDto pageQueryRequestDto) {
        Page<Role> rolePage = new Page<>(pageQueryRequestDto.getCurrentPage(), pageQueryRequestDto.getPageSize());
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        String roleName = pageQueryRequestDto.getRoleName();

        if (!Objects.isNull(pageQueryRequestDto.getRoleName())){
            roleQueryWrapper.like("role_name", roleName);
        }
        Page<Role> selectPage = roleMapper.selectPage(rolePage, roleQueryWrapper);
        return ResponseResult.success(selectPage);
    }

    @Override
    public ResponseResult<Integer> insertRole(InsertRoleRequestDto insertRoleRequestDto) {
        Role role = new Role();
        BeanUtils.copyProperties(insertRoleRequestDto, role);
        int count = roleMapper.insert(role);
        if (count <= 0) {
            return ResponseResult.fail(StatusCode.INSERT_ROLE_ERROR.getCode(), StatusCode.INSERT_ROLE_ERROR.getMessage());
        }
        return ResponseResult.success(count);
    }

    @Override
    public ResponseResult<Integer> updateRole(UpdateRoleRequestDto updateRoleRequestDto) {
        UpdateWrapper<Role> roleUpdateWrapper = new UpdateWrapper<>();
        roleUpdateWrapper.eq("id", updateRoleRequestDto.getId())
                .set(updateRoleRequestDto.getRoleCode() != null && !updateRoleRequestDto.getRoleCode().isEmpty(), "role_code", updateRoleRequestDto.getRoleCode())
                .set(updateRoleRequestDto.getRoleName() != null && !updateRoleRequestDto.getRoleName().isEmpty(), "role_name", updateRoleRequestDto.getRoleName())
                .set(updateRoleRequestDto.getRemark() != null && !updateRoleRequestDto.getRemark().isEmpty(), "remark", updateRoleRequestDto.getRemark());
        int count = roleMapper.update(roleUpdateWrapper);
        if (count <= 0){
            return ResponseResult.fail(StatusCode.UPDATE_ROLE_ERROR.getCode(), StatusCode.UPDATE_ROLE_ERROR.getMessage());
        }
        return ResponseResult.success(count);
    }

    @Override
    public ResponseResult<Integer> deleteRole(Long id) {
        int count = roleMapper.deleteById(id);
        if (count <= 0){
            return ResponseResult.fail(StatusCode.DELETE_ROLE_ERROR.getCode(), StatusCode.DELETE_ROLE_ERROR.getMessage());
        }
        return ResponseResult.success(count);
    }

    @Override
    public ResponseResult<Integer> batchDeleteRole(Long[] ids) {
        if (ids.length == 0){
            return ResponseResult.fail();
        }
        int count = roleMapper.deleteBatchIds(Arrays.asList(ids));
        if (count < ids.length){
            return ResponseResult.fail(StatusCode.DELETE_ROLE_ERROR.getCode(), StatusCode.DELETE_ROLE_ERROR.getMessage());
        }
        return ResponseResult.success(count);
    }
}




