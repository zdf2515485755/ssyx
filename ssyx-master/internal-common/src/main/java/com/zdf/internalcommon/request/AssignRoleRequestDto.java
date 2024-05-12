package com.zdf.internalcommon.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *@Description Assign Role Request Dto
 *@Author mrzhang
 *@Date 2024/5/12 20:48
 */
@Data
public class AssignRoleRequestDto {
    @NotNull(message = "adminId can not be empty")
    private Long adminId;
    @NotEmpty(message = "roleIdList can not be empty")
    private List<Long> roleIdList;
}
