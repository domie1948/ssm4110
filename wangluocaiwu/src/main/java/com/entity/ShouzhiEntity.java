package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 收支
 *
 * @author 
 * @email
 */
@TableName("shouzhi")
public class ShouzhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShouzhiEntity() {

	}

	public ShouzhiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 收支名称
     */
    @TableField(value = "shouzhi_name")

    private String shouzhiName;


    /**
     * 收支
     */
    @TableField(value = "shouzhi_yesno_types")

    private Integer shouzhiYesnoTypes;


    /**
     * 收支类型
     */
    @TableField(value = "shouzhi_leixing_types")

    private Integer shouzhiLeixingTypes;


    /**
     * 金额
     */
    @TableField(value = "shouzhi_new_money")

    private Double shouzhiNewMoney;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 收支详情
     */
    @TableField(value = "shouzhi_content")

    private String shouzhiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：用户
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
	 * 设置：收支名称
	 */
    public String getShouzhiName() {
        return shouzhiName;
    }


    /**
	 * 获取：收支名称
	 */

    public void setShouzhiName(String shouzhiName) {
        this.shouzhiName = shouzhiName;
    }
    /**
	 * 设置：收支
	 */
    public Integer getShouzhiYesnoTypes() {
        return shouzhiYesnoTypes;
    }


    /**
	 * 获取：收支
	 */

    public void setShouzhiYesnoTypes(Integer shouzhiYesnoTypes) {
        this.shouzhiYesnoTypes = shouzhiYesnoTypes;
    }
    /**
	 * 设置：收支类型
	 */
    public Integer getShouzhiLeixingTypes() {
        return shouzhiLeixingTypes;
    }


    /**
	 * 获取：收支类型
	 */

    public void setShouzhiLeixingTypes(Integer shouzhiLeixingTypes) {
        this.shouzhiLeixingTypes = shouzhiLeixingTypes;
    }
    /**
	 * 设置：金额
	 */
    public Double getShouzhiNewMoney() {
        return shouzhiNewMoney;
    }


    /**
	 * 获取：金额
	 */

    public void setShouzhiNewMoney(Double shouzhiNewMoney) {
        this.shouzhiNewMoney = shouzhiNewMoney;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：收支详情
	 */
    public String getShouzhiContent() {
        return shouzhiContent;
    }


    /**
	 * 获取：收支详情
	 */

    public void setShouzhiContent(String shouzhiContent) {
        this.shouzhiContent = shouzhiContent;
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

    @Override
    public String toString() {
        return "Shouzhi{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", shouzhiName=" + shouzhiName +
            ", shouzhiYesnoTypes=" + shouzhiYesnoTypes +
            ", shouzhiLeixingTypes=" + shouzhiLeixingTypes +
            ", shouzhiNewMoney=" + shouzhiNewMoney +
            ", insertTime=" + insertTime +
            ", shouzhiContent=" + shouzhiContent +
            ", createTime=" + createTime +
        "}";
    }
}
