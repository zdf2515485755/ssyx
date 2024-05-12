package com.zdf.internalcommon.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@Description 类功能简要描述
 *@Author mrzhang
 *@Date 2024/5/11 21:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQueryRequestDto {
    private Integer currentPage;
    private Integer pageSize;
    private String roleName;
}
