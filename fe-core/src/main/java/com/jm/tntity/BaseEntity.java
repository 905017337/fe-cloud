package com.jm.tntity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 18:10
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @Excel(name = "创建时间", databaseFormat = "yyyy-MM-dd HH:mm:ss", format = "yyyy-MM-dd", width = 20)
    private Date createTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    @Excel(name = "更新时间", databaseFormat = "yyyy-MM-dd HH:mm:ss", format = "yyyy-MM-dd", width = 20)
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private Long updateUser;

}
