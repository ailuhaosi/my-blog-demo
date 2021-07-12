package io.gd.modules.biz.region.dao;

import io.gd.modules.biz.region.entity.RegionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 区域管理
 * 
 * @author gd
 * @email 771747384@qq.com
 * @date 2021-07-11 21:41:19
 */
@Mapper
public interface RegionDao extends BaseMapper<RegionEntity> {
	
}
