package com.zdf.internalcommon.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 *@Description Listing Sku Request Dto
 *@Author mrzhang
 *@Date 2024/5/14 00:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingSkuRequestDto {
    @NotNull(message = "id can not be empty")
    private Long id;
    @NotNull(message = "status can not be empty")
    private Integer status;
}
