package com.entity.view;

import com.entity.ShouzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 收支
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shouzhi")
public class ShouzhiView extends ShouzhiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 收支的值
		*/
		private String shouzhiYesnoValue;
		/**
		* 收支类型的值
		*/
		private String shouzhiLeixingValue;



		//级联表 yonghu
			/**
			* 姓名
			*/
			private String yonghuName;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public ShouzhiView() {

	}

	public ShouzhiView(ShouzhiEntity shouzhiEntity) {
		try {
			BeanUtils.copyProperties(this, shouzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 收支的值
			*/
			public String getShouzhiYesnoValue() {
				return shouzhiYesnoValue;
			}
			/**
			* 设置： 收支的值
			*/
			public void setShouzhiYesnoValue(String shouzhiYesnoValue) {
				this.shouzhiYesnoValue = shouzhiYesnoValue;
			}
			/**
			* 获取： 收支类型的值
			*/
			public String getShouzhiLeixingValue() {
				return shouzhiLeixingValue;
			}
			/**
			* 设置： 收支类型的值
			*/
			public void setShouzhiLeixingValue(String shouzhiLeixingValue) {
				this.shouzhiLeixingValue = shouzhiLeixingValue;
			}














				//级联表的get和set yonghu
					/**
					* 获取： 姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}


}
