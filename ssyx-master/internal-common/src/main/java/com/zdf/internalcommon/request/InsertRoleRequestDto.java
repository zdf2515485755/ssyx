package com.zdf.internalcommon.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 *@Description 类功能简要描述
 *@Author mrzhang
 *@Date 2024/5/11 22:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertRoleRequestDto {
    /**
     * 角色名称
     */
    @NotBlank(message = "roleName can not be empty")
    private String roleName;

    /**
     * 角色编码
     */
    @NotBlank(message = "roleCode can not be empty")
    private String roleCode;

    /**
     * 备注
     */
    private String remark;

}
