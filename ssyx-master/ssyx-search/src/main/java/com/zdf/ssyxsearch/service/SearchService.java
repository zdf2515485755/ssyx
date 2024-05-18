package com.zdf.ssyxsearch.service;

import com.zdf.internalcommon.entity.SkuInfo;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.ssyxsearch.repository.SkuInfoRepository;
import com.zdf.ssyxsearch.client.ProductClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *@Description SearchService
 *@Author mrzhang
 *@Date 2024/5/14 23:08
 */
@Service
public class SearchService {

    @Resource
    private ProductClient productClient;
    @Resource
    private SkuInfoRepository skuInfoRepository;

    public void listProduct(Long id){
        ResponseResult<SkuInfo> skuInfoResponseResult = productClient.selectSkuById(id);
        SkuInfo skuInfo = skuInfoResponseResult.getData();
        skuInfoRepository.save(skuInfo);
    }

    public void removalProduct(Long id){
        skuInfoRepository.deleteById(id);
    }
}
