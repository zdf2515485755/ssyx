package com.zdf.ssyxproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdf.internalcommon.constant.BaseConstant;
import com.zdf.internalcommon.constant.StatusCode;
import com.zdf.internalcommon.entity.SkuInfo;
import com.zdf.internalcommon.request.ListingSkuRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.ssyxproduct.mapper.SkuInfoMapper;
import com.zdf.ssyxproduct.service.SkuInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author mrzhang
* @description 针对表【sku_info(sku信息)】的数据库操作Service实现
* @createDate 2024-05-14 00:34:33
*/
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo>
    implements SkuInfoService {

    @Resource
    private SkuInfoMapper skuInfoMapper;

    @Override
    public ResponseResult<SkuInfo> selectSkuById(Long id) {
        QueryWrapper<SkuInfo> skuInfoQueryWrapper = new QueryWrapper<>();
        skuInfoQueryWrapper.eq("id", id)
                .eq("is_deleted", BaseConstant.NOTDELETE);
        SkuInfo skuInfo = skuInfoMapper.selectOne(skuInfoQueryWrapper);
        return ResponseResult.success(skuInfo);
    }

    @Override
    public ResponseResult<Integer> listingSku(ListingSkuRequestDto listingSkuRequestDto) {
        UpdateWrapper<SkuInfo> skuInfoUpdateWrapper = new UpdateWrapper<>();
        skuInfoUpdateWrapper.eq("id", listingSkuRequestDto.getId())
                .set("publish_status", listingSkuRequestDto.getStatus())
                .eq("is_deleted", BaseConstant.NOTDELETE);
        int count = skuInfoMapper.update(skuInfoUpdateWrapper);
        if (count <= 0){
            return ResponseResult.fail(StatusCode.UPDATE_SKU_ERROR.getCode(), StatusCode.UPDATE_SKU_ERROR.getMessage());
        }
        return ResponseResult.success(count);
    }
}




