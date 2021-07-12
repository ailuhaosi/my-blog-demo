package io.gd.modules.biz.region.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 区域管理
 * 
 * @author gd
 * @email 771747384@qq.com
 * @date 2021-07-12 18:24:12
 */
@Data
@TableName("tb_region")
public class RegionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type= IdType.AUTO)
	private Integer regionId;
	/**
	 * 区域名称
	 */
	private String regionTitle;
	/**
	 * 联系人
	 */
	private String regionContact;
	/**
	 * 联系电话
	 */
	private String regionMobile;
	/**
	 * 区域图标
	 */
	private String regionLogo;
	/**
	 * 备注
	 */
	private String regionRemark;
	/**
	 * 
	 */
	private String regionProvince;
	/**
	 * 
	 */
	private String regionCity;
	/**
	 * 
	 */
	private String regionDistict;
	/**
	 * 
	 */
	private String regionAddress;
	/**
	 * 
	 */
	private Integer regionLongitude;
	/**
	 * 
	 */
	private Integer regionLatitude;
	/**
	 * 
	 */
	private String regionCreator;
	/**
	 * 
	 */
	private Date regionCreatetime;
	/**
	 * 
	 */
	private Date regionUpdatetime;
	/**
	 * 
	 */
	private Integer regionStatus;
	/**
	 * 
	 */
	private String regionMiniprogram;
	/**
	 * 
	 */
	private String creatorName;

}
