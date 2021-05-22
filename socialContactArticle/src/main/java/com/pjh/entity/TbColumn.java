package com.pjh.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotations.TableName;
/**
 * <p>
 * 专栏
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_column")
public class TbColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

    /**
     * 专栏名称
     */
    private String name;

    /**
     * 专栏简介
     */
    private String summary;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 申请日期
     */
    private LocalDateTime createtime;

    /**
     * 审核日期
     */
    private LocalDateTime checktime;

    /**
     * 状态
     */
    private String state;


}
