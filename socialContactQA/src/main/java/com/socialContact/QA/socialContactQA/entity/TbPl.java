package com.socialContact.QA.socialContactQA.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-04-25
 */
@Data
@Accessors(chain = true)
@TableName("tb_pl")
public class TbPl extends Model<TbPl> {

    private static final long serialVersionUID = 1L;

    /**
     * 问题ID
     */
    private String problemid;

    /**
     * 标签ID
     */
    private String labelid;


    @Override
    protected Serializable pkVal() {
        return this.problemid;
    }

}
