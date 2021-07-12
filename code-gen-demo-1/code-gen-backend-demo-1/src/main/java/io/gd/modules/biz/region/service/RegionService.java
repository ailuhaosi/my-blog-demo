package io.gd.modules.biz.region.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gd.common.utils.PageUtils;
import io.gd.modules.biz.region.entity.RegionEntity;

import java.util.Map;

/**
 * 区域管理
 *
 * @author gd
 * @email 771747384@qq.com
 * @date 2021-07-12 18:24:12
 */
public interface RegionService extends IService<RegionEntity> {

    PageUtils queryPage(Map<String, Object> params,Map<String, Object> pageObj);
}

