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
 * @date 2021-07-11 21:41:19
 */
public interface RegionService extends IService<RegionEntity> {

    PageUtils queryPage(Map<String, Object> params,Map<String, Object> pageObj);
}

