package com.zdf.internalcommon.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 *@Description Page Query Request Dto
 *@Author mrzhang
 *@Date 2024/5/11 21:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQueryRequestDto {
    @NotNull(message = "currentPage can not be empty")
    private Integer currentPage;
    @NotNull(message = "pageSize can not be empty")
    private Integer pageSize;
    private String roleName;
}
