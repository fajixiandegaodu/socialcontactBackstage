package com.pjh.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生年月日
     */
    private LocalDateTime birthday;

    /**
     * 头像
     */
    private String avatar;

    /**
     * E-Mail
     */
    private String email;

    /**
     * 注册日期
     */
    private LocalDateTime regdate;

    /**
     * 修改日期
     */
    private LocalDateTime updatedate;

    /**
     * 最后登陆日期
     */
    private LocalDateTime lastdate;

    /**
     * 在线时长（分钟）
     */
    private Long online;

    /**
     * 兴趣
     */
    private String interest;

    /**
     * 个性
     */
    private String personality;

    /**
     * 粉丝数
     */
    private Integer fanscount;

    /**
     * 关注数
     */
    private Integer followcount;


}
