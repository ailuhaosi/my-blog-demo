package io.gd.modules.biz.region.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.gd.common.utils.PageUtils;
import io.gd.common.utils.Query;

import io.gd.modules.biz.region.dao.RegionDao;
import io.gd.modules.biz.region.entity.RegionEntity;
import io.gd.modules.biz.region.service.RegionService;


@Service("regionService")
public class RegionServiceImpl extends ServiceImpl<RegionDao, RegionEntity> implements RegionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params,Map<String, Object>pageObj) {
        IPage<RegionEntity> page = this.page(
                new Query<RegionEntity>().getPage(pageObj),
                new QueryWrapper<RegionEntity>().allEq(params,false)
        );

        return new PageUtils(page);
    }

}