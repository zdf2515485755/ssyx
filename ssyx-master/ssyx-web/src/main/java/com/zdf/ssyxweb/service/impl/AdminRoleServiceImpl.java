package com.zdf.ssyxweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdf.internalcommon.constant.BaseConstant;
import com.zdf.internalcommon.entity.AdminRole;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.ssyxweb.mapper.AdminRoleMapper;
import com.zdf.ssyxweb.service.AdminRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author mrzhang
* @description 针对表【admin_role(用户角色)】的数据库操作Service实现
* @createDate 2024-05-12 20:32:53
*/
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole>
    implements AdminRoleService {

    @Resource
    private AdminRoleMapper adminRoleMapper;

    public List<AdminRole> selectRoleIdByUserId(Long userId){
        QueryWrapper<AdminRole> adminRoleQueryWrapper = new QueryWrapper<>();
        adminRoleQueryWrapper.eq("admin_id", userId)
                .eq("is_deleted", BaseConstant.NOTDELETE);
        return adminRoleMapper.selectList(adminRoleQueryWrapper);
    }

    public ResponseResult<Integer> deleteAdminRoleByUserId(Long userId){
        List<AdminRole> adminRoles = selectRoleIdByUserId(userId);
        List<Long> idList = adminRoles.stream().map(AdminRole::getId).collect(Collectors.toList());
        int count = adminRoleMapper.deleteBatchIds(idList);
        return ResponseResult.success(count);
    }

    public ResponseResult<Integer> addAdminRole(AdminRole adminRole){
        int count = adminRoleMapper.insert(adminRole);
        return ResponseResult.success(count);
    }
}




