package com.zdf.ssyxproduct.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zdf.internalcommon.entity.SkuInfo;
import com.zdf.internalcommon.request.ListingSkuRequestDto;
import com.zdf.internalcommon.result.ResponseResult;

/**
* @author mrzhang
* @description 针对表【sku_info(sku信息)】的数据库操作Service
* @createDate 2024-05-14 00:34:33
*/
public interface SkuInfoService extends IService<SkuInfo> {

    ResponseResult<SkuInfo> selectSkuById(Long id);
    ResponseResult<Integer> listingSku(ListingSkuRequestDto listingSkuRequestDto);
}
