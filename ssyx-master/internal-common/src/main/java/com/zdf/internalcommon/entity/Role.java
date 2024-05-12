package com.zdf.internalcommon.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色
 * @author mrzhang
 * @TableName role
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity implements Serializable {
    /**
     * 角色id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 备注
     */
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}