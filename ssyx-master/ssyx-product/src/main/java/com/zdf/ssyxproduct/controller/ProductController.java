package com.zdf.ssyxproduct.controller;

import com.zdf.internalcommon.entity.SkuInfo;
import com.zdf.internalcommon.request.ListingSkuRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.ssyxproduct.service.impl.SkuInfoServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 *@Description API for operating product
 *@Author mrzhang
 *@Date 2024/5/14 00:44
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private SkuInfoServiceImpl skuInfoService;

    @GetMapping("/selectSkuById/{id}")
    public ResponseResult<SkuInfo> selectSkuById(@NotNull @PathVariable("id") Long id){
        return skuInfoService.selectSkuById(id);
    }

    @PutMapping("/listingSku")
    public ResponseResult<Integer> listingSku(@RequestBody ListingSkuRequestDto listingSkuRequestDto){
        return skuInfoService.listingSku(listingSkuRequestDto);
    }
}
