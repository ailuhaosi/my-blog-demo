package io.gd.modules.biz.resident.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.gd.common.utils.PageUtils;
import io.gd.common.utils.Query;

import io.gd.modules.biz.resident.dao.ResidentDao;
import io.gd.modules.biz.resident.entity.ResidentEntity;
import io.gd.modules.biz.resident.service.ResidentService;


@Service("residentService")
public class ResidentServiceImpl extends ServiceImpl<ResidentDao, ResidentEntity> implements ResidentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params,Map<String, Object>pageObj) {
        IPage<ResidentEntity> page = this.page(
                new Query<ResidentEntity>().getPage(pageObj),
                new QueryWrapper<ResidentEntity>().allEq(params,false)
        );

        return new PageUtils(page);
    }

}