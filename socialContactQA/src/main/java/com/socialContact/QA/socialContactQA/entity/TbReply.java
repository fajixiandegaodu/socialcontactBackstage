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
 * 回答
 * </p>
 *
 * @author jobob
 * @since 2021-04-25
 */
@Data
@Accessors(chain = true)
@TableName("tb_reply")
public class TbReply extends Model<TbReply> {

    private static final long serialVersionUID = 1L;

    private  String id;

    /**
     * 问题ID
     */
    private String problemid;

    /**
     * 回答内容
     */
    private String content;

    /**
     * 创建日期
     */
    private Date createtime;

    /**
     * 更新日期
     */
    private Date updatetime;

    /**
     * 回答人ID
     */
    private String userid;

    /**
     * 回答人昵称
     */
    private String nickname;




    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
