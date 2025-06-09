package com.entity.model;

import com.entity.ShouzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 收支
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShouzhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 收支名称
     */
    private String shouzhiName;


    /**
     * 收支
     */
    private Integer shouzhiYesnoTypes;


    /**
     * 收支类型
     */
    private Integer shouzhiLeixingTypes;


    /**
     * 金额
     */
    private Double shouzhiNewMoney;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 收支详情
     */
    private String shouzhiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：收支名称
	 */
    public String getShouzhiName() {
        return shouzhiName;
    }


    /**
	 * 设置：收支名称
	 */
    public void setShouzhiName(String shouzhiName) {
        this.shouzhiName = shouzhiName;
    }
    /**
	 * 获取：收支
	 */
    public Integer getShouzhiYesnoTypes() {
        return shouzhiYesnoTypes;
    }


    /**
	 * 设置：收支
	 */
    public void setShouzhiYesnoTypes(Integer shouzhiYesnoTypes) {
        this.shouzhiYesnoTypes = shouzhiYesnoTypes;
    }
    /**
	 * 获取：收支类型
	 */
    public Integer getShouzhiLeixingTypes() {
        return shouzhiLeixingTypes;
    }


    /**
	 * 设置：收支类型
	 */
    public void setShouzhiLeixingTypes(Integer shouzhiLeixingTypes) {
        this.shouzhiLeixingTypes = shouzhiLeixingTypes;
    }
    /**
	 * 获取：金额
	 */
    public Double getShouzhiNewMoney() {
        return shouzhiNewMoney;
    }


    /**
	 * 设置：金额
	 */
    public void setShouzhiNewMoney(Double shouzhiNewMoney) {
        this.shouzhiNewMoney = shouzhiNewMoney;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：收支详情
	 */
    public String getShouzhiContent() {
        return shouzhiContent;
    }


    /**
	 * 设置：收支详情
	 */
    public void setShouzhiContent(String shouzhiContent) {
        this.shouzhiContent = shouzhiContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
