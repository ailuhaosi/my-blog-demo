package io.gd.modules.biz.resident.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gd.common.utils.PageUtils;
import io.gd.modules.biz.resident.entity.ResidentEntity;

import java.util.Map;

/**
 * 住户管理
 *
 * @author gd
 * @email 771747384@qq.com
 * @date 2021-07-12 19:21:53
 */
public interface ResidentService extends IService<ResidentEntity> {

    PageUtils queryPage(Map<String, Object> params,Map<String, Object> pageObj);
}

