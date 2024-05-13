package com.zdf.ssyxweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdf.internalcommon.constant.BaseConstant;
import com.zdf.internalcommon.entity.Permission;
import com.zdf.internalcommon.response.QueryAllMenuResponseDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.ssyxweb.mapper.PermissionMapper;
import com.zdf.ssyxweb.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author mrzhang
* @description 针对表【permission(权限)】的数据库操作Service实现
* @createDate 2024-05-12 22:48:03
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public ResponseResult<List<QueryAllMenuResponseDto>> queryAllMenu() {
        QueryWrapper<Permission> permissionQueryWrapper = new QueryWrapper<>();
        permissionQueryWrapper.eq("is_deleted", BaseConstant.NOTDELETE);
        List<Permission> permissionList = permissionMapper.selectList(permissionQueryWrapper);
        List<QueryAllMenuResponseDto> menuList = permissionList.stream().filter(permission -> Objects.equals(permission.getPid(), BaseConstant.ROOT))
                .map(permission -> {
                    QueryAllMenuResponseDto queryAllMenuResponseDto = new QueryAllMenuResponseDto();
                    queryAllMenuResponseDto.setId(permission.getId());
                    queryAllMenuResponseDto.setName(permission.getName());
                    queryAllMenuResponseDto.setMenuList(getChildMenu(permission.getId(), permissionList));
                    return queryAllMenuResponseDto;
                }).collect(Collectors.toList());
        return ResponseResult.success(menuList);
    }

    private List<QueryAllMenuResponseDto> getChildMenu(Long id, List<Permission> permissionList) {
        List<Permission> childMenus = permissionList.stream().filter(permission -> Objects.equals(permission.getPid(), id))
                .collect(Collectors.toList());
        if (childMenus.isEmpty()){
            return Collections.emptyList();
        }
        return childMenus.stream().map(childMenu -> {
            QueryAllMenuResponseDto queryAllMenuResponseDto = new QueryAllMenuResponseDto();
            queryAllMenuResponseDto.setId(childMenu.getId());
            queryAllMenuResponseDto.setName(childMenu.getName());
            queryAllMenuResponseDto.setMenuList(getChildMenu(childMenu.getId(), permissionList));
            return queryAllMenuResponseDto;
        }).collect(Collectors.toList());
    }
}




