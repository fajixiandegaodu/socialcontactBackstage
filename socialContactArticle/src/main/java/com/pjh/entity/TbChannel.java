package com.pjh.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotations.TableName;
/**
 * <p>
 * 频道
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_channel")
public class TbChannel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

    /**
     * 频道名称
     */
    private String name;

    /**
     * 状态
     */
    private String state;


}
