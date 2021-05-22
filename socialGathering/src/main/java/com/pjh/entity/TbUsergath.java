package com.pjh.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户关注活动
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbUsergath implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 活动ID
     */
    private String gathid;

    /**
     * 点击时间
     */
    private LocalDateTime exetime;


}
