package com.pjh.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

    /**
     * 登陆名称
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private String state;


}
