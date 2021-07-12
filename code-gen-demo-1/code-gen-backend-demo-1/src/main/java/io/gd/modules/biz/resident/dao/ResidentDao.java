package io.gd.modules.biz.resident.dao;

import io.gd.modules.biz.resident.entity.ResidentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 住户管理
 * 
 * @author gd
 * @email 771747384@qq.com
 * @date 2021-07-12 19:21:53
 */
@Mapper
public interface ResidentDao extends BaseMapper<ResidentEntity> {
	
}
