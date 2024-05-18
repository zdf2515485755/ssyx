package com.zdf.ssyxsearch.client;

import com.zdf.internalcommon.entity.SkuInfo;
import com.zdf.internalcommon.result.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *@Description ProductClient
 *@Author mrzhang
 *@Date 2024/5/14 23:04
 */
@FeignClient(value = "ssyx-product")
public interface ProductClient {
    @GetMapping("/product/selectSkuById/{id}")
    ResponseResult<SkuInfo> selectSkuById(@PathVariable("id") Long id);
}
