package com.patentshow.entity;

import javax.persistence.*;

/**
 * Created by unclexiao on 2018/1/9.
 */
@Entity
@Table(name = "patent")
public class Patent {


    private int id;
    /**
     * 分类号
     */
    private String classifyCode;

    /**
     * 申请人
     */
    private String applyMan;

    /**
     * 发明人
     */
    private String inventeMan;
    /**
     * 公开日期
     */
    private String publicityDate;
    /**
     * 申请日期
     */
    private String applyDate;

    /**
     * 发明类型
     */
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "classifyCode")
    public String getClassifyCode() {
        return classifyCode;
    }

    public void setClassifyCode(String classifyCode) {
        this.classifyCode = classifyCode;
    }

    @Column(name = "applyMan")
    public String getApplyMan() {
        return applyMan;
    }

    public void setApplyMan(String applyMan) {
        this.applyMan = applyMan;
    }

    @Column(name = "inventeMan")
    public String getInventeMan() {
        return inventeMan;
    }

    public void setInventeMan(String inventeMan) {
        this.inventeMan = inventeMan;
    }
    @Column(name = "publicity_date")
    public String getPublicity_date() {
        return publicityDate;
    }

    public void setPublicity_date(String publicity_date) {
        this.publicityDate = publicity_date;
    }
    @Column(name = "applyDate")
    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
