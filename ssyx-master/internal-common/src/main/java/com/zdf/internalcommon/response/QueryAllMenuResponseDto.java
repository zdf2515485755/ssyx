package com.zdf.internalcommon.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *@Description QueryAllMenuResponseDto
 *@Author mrzhang
 *@Date 2024/5/12 23:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryAllMenuResponseDto {
    private Long id;
    private String name;
    private List<QueryAllMenuResponseDto> menuList;
}
