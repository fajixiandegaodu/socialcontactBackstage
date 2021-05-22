package com.socialContact.QA.socialContactQA.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 问题
 * </p>
 *
 * @author jobob
 * @since 2021-04-25
 */
@Data
@Accessors(chain = true)
@TableName("tb_problem")
public class TbProblem extends Model<TbProblem> {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建日期
     */
    private Date createtime;

    /**
     * 修改日期
     */
    private Date updatetime;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 浏览量
     */
    private Long visits;

    /**
     * 点赞数
     */
    private Long thumbup;

    /**
     * 回复数
     */
    private Long reply;

    /**
     * 是否解决
     */
    private String solve;

    /**
     * 回复人昵称
     */
    private String replyname;

    /**
     * 回复日期
     */
    private Date replytime;

   /*
   * id
   * */

    private Integer id;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
