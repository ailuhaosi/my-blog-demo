package io.gd.modules.biz.resident.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 住户管理
 * 
 * @author gd
 * @email 771747384@qq.com
 * @date 2021-07-12 19:21:53
 */
@Data
@TableName("tb_resident")
public class ResidentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 住户id
	 */
	@TableId(type= IdType.AUTO)
	private Integer residentId;
	/**
	 * 住户姓名
	 */
	private String residentName;
	/**
	 * 联系电话
	 */
	private String residentMobile;
	/**
	 * 联系电话
	 */
	private Integer residentType;
	/**
	 * 住户类型
	 */
	private String residentRemark;
	/**
	 * 住户所在小区
	 */
	private String belongtoRegion;
	/**
	 * 
	 */
	private Date residentCreatetime;
	/**
	 * 
	 */
	private Date residentUpdatetime;

}
