package com.pjh.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotations.TableName;
/**
 * <p>
 * 活动
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_gathering")
public class TbGathering implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 大会简介
     */
    private String summary;

    /**
     * 详细说明
     */
    private String detail;

    /**
     * 主办方
     */
    private String sponsor;

    /**
     * 活动图片
     */
    private String image;

    /**
     * 开始时间
     */
    private LocalDateTime starttime;

    /**
     * 截止时间
     */
    private LocalDateTime endtime;

    /**
     * 举办地点
     */
    private String address;

    /**
     * 报名截止
     */
    private LocalDateTime enrolltime;

    /**
     * 是否可见
     */
    private String state;

    /**
     * 城市
     */
    private String city;


}
