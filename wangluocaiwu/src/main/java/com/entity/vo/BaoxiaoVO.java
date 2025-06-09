package com.entity.vo;

import com.entity.BaoxiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 报销
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("baoxiao")
public class BaoxiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报销名称
     */

    @TableField(value = "baoxiao_name")
    private String baoxiaoName;


    /**
     * 报销类型
     */

    @TableField(value = "baoxiao_types")
    private Integer baoxiaoTypes;


    /**
     * 报销金额
     */

    @TableField(value = "money")
    private Double money;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报销详情
     */

    @TableField(value = "baoxiao_content")
    private String baoxiaoContent;


    /**
     * 是否同意
     */

    @TableField(value = "baoxiao_yesno_types")
    private Integer baoxiaoYesnoTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：报销名称
	 */
    public String getBaoxiaoName() {
        return baoxiaoName;
    }


    /**
	 * 获取：报销名称
	 */

    public void setBaoxiaoName(String baoxiaoName) {
        this.baoxiaoName = baoxiaoName;
    }
    /**
	 * 设置：报销类型
	 */
    public Integer getBaoxiaoTypes() {
        return baoxiaoTypes;
    }


    /**
	 * 获取：报销类型
	 */

    public void setBaoxiaoTypes(Integer baoxiaoTypes) {
        this.baoxiaoTypes = baoxiaoTypes;
    }
    /**
	 * 设置：报销金额
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：报销金额
	 */

    public void setMoney(Double money) {
        this.money = money;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报销详情
	 */
    public String getBaoxiaoContent() {
        return baoxiaoContent;
    }


    /**
	 * 获取：报销详情
	 */

    public void setBaoxiaoContent(String baoxiaoContent) {
        this.baoxiaoContent = baoxiaoContent;
    }
    /**
	 * 设置：是否同意
	 */
    public Integer getBaoxiaoYesnoTypes() {
        return baoxiaoYesnoTypes;
    }


    /**
	 * 获取：是否同意
	 */

    public void setBaoxiaoYesnoTypes(Integer baoxiaoYesnoTypes) {
        this.baoxiaoYesnoTypes = baoxiaoYesnoTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
