package com.zdf.internalcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 权限
 * @author mrzhang
 * @TableName permission
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends BaseEntity implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 所属上级
     */
    private Long pid;

    /**
     * 名称
     */
    private String name;

    /**
     * 名称code
     */
    private String code;

    /**
     * 跳转页面code
     */
    private String toCode;

    /**
     * 类型(1:菜单,2:按钮)
     */
    private Integer type;

    /**
     * 状态(0:禁止,1:正常)
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}