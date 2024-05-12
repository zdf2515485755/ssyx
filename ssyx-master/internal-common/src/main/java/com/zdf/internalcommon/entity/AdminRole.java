package com.zdf.internalcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * 用户角色
 * @author mrzhang
 * @TableName admin_role
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="admin_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminRole extends BaseEntity implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 用户id
     */
    private Long adminId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}