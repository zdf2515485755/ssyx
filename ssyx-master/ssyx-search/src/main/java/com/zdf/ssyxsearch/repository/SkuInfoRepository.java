package com.zdf.ssyxsearch.repository;

import com.zdf.internalcommon.entity.SkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 *@Description SkuInfo Repository
 *@Author mrzhang
 *@Date 2024/5/14 23:41
 */
@Repository
public interface SkuInfoRepository extends ElasticsearchRepository<SkuInfo, Long> {
}
