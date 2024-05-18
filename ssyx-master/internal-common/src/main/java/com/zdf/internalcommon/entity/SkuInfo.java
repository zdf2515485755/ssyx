package com.zdf.internalcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * sku信息
 * @author mrzhang
 * @TableName sku_info
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sku_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "skuinfo")
public class SkuInfo extends BaseEntity implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 平台属性分组id
     */
    private Long attrGroupId;

    /**
     * 商品类型：0->普通商品 1->秒杀商品
     */
    private Integer skuType;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * 展示图片
     */
    private String imgUrl;

    /**
     * 限购个数/每天（0：不限购）
     */
    private Integer perLimit;

    /**
     * 上架状态：0->下架；1->上架
     */
    private Integer publishStatus;

    /**
     * 审核状态：0->未审核；1->审核通过
     */
    private Integer checkStatus;

    /**
     * 是否新人专享：0->否；1->是
     */
    private Integer isNewPerson;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 锁定库存
     */
    private Integer lockStock;

    /**
     * 预警库存
     */
    private Integer lowStock;

    /**
     * 销量
     */
    private Integer sale;

    /**
     * 仓库
     */
    private Long wareId;

    /**
     * 
     */
    private Long version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}