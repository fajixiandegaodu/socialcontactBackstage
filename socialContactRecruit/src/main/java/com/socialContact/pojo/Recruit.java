package com.socialContact.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Recruit
 * @Author: 86151
 * @Date: 2021/4/23 19:27
 * @Description: TODO
 */
@TableName("tb_recruit")
public class Recruit implements Serializable {
    @TableId(type = IdType.INPUT)
    private String id;
    private String jobname;
    private String salary;
    private String education;
    private String type;
    private  String address;
    private String eid;

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @TableId(type = IdType.AUTO)
    private String createtime;
    private String state;
    private String url;
    private String label;
    private String content1;
    private String content2;
    private String condition;

    public String getCreatetime() {
        return createtime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTyep() {
        return type;
    }

    public void setTyep(String tyep) {
        this.type = tyep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }
}

