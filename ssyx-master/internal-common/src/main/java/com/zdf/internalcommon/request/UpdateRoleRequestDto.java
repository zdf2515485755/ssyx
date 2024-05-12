package com.zdf.internalcommon.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 *@Description 类功能简要描述
 *@Author mrzhang
 *@Date 2024/5/11 23:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleRequestDto {
    @NotBlank(message = "id can not be empty")
    private Long id;
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 备注
     */
    private String remark;
}
