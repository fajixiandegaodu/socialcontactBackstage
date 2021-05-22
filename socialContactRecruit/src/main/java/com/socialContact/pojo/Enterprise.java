package com.socialContact.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @ClassName: Enterprise
 * @Author: 86151
 * @Date: 2021/4/22 19:51
 * @Description: TODO
 */
/*表名称*/
@TableName("tb_enterprise")
public class Enterprise  implements Serializable {
    @TableId(type = IdType.INPUT)
    private String id;
    private String name;
    private String summary;
    private String address;
    private String labels;
    private String coordinate;
    private String ishot;
    private String logo;
    private String jobcount;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getIshot() {
        return ishot;
    }

    public void setIshot(String ishot) {
        this.ishot = ishot;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getJobcount() {
        return jobcount;
    }

    public void setJobcount(String jobcount) {
        this.jobcount = jobcount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
