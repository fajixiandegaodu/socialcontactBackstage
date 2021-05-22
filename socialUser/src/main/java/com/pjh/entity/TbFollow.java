package com.pjh.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbFollow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 被关注用户ID
     */
    private String targetuser;


}
