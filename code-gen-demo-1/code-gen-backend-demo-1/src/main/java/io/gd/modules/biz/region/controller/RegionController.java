package io.gd.modules.biz.region.controller;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.gd.common.utils.Constant;
import io.gd.common.validator.group.UpdateGroup;
import io.gd.modules.biz.region.dto.RegionListReqDTO;
import io.gd.modules.biz.region.entity.RegionEntity;
import io.gd.modules.biz.region.dto.RegionListResDTO;
import io.gd.modules.biz.region.dto.RegionSaveReqDTO;
import io.gd.modules.biz.region.dto.converter.RegionSaveReqConverter;
//

import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.gd.modules.biz.region.service.RegionService;
import io.gd.common.utils.PageUtils;
import io.gd.common.utils.R;
//////////



/**
 * 区域管理
 *
 * @author gd
 * @email 771747384@qq.com
 * @date 2021-07-11 21:41:19
 */
@RestController
@RequestMapping("biz/region")
@Api(tags = {"biz_region"})
public class RegionController {
    @Autowired
    private RegionService regionService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("biz:region:list")
    @ApiOperation("list")
    @ApiResponses({
            @ApiResponse(code = 0, message = "ok", response = RegionListResDTO.class)
    })
    public R list(RegionListReqDTO params,String page,String limit){

        ObjectMapper oMapper = new ObjectMapper();
        oMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        oMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Map<String, Object> listReqParams = oMapper.convertValue(params, Map.class);
        //page、limit
        Map<String, Object> pageObj = new HashMap<>(2);
        pageObj.put(Constant.PAGE,page);
        pageObj.put(Constant.LIMIT,limit);
        PageUtils<RegionListResDTO.RegionListItemDTO> pageResult = regionService.queryPage(listReqParams,pageObj);

        return R.ok().put("data", pageResult);
    }


    /**
     * 信息
     */
    @GetMapping("/info")
    //@RequiresPermissions("biz:region:info")
    @ApiOperation("info")
    @ApiResponses({
            @ApiResponse(code = 0, message = "ok", response = RegionSaveReqDTO.class)
    })
    public R info(Integer regionId){

         RegionEntity region = regionService.getById(regionId);

         RegionSaveReqDTO regionSaveReqDTO = RegionSaveReqConverter.INSTANCE.getDto(region);

        return R.ok().put("data", regionSaveReqDTO);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("biz:region:save")
    @ApiOperation("save")
    public R save(@Validated @RequestBody RegionSaveReqDTO region){
        RegionEntity regionEntity = RegionSaveReqConverter.INSTANCE.getEntity(region);

        regionService.save(regionEntity);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("biz:region:update")
    @ApiOperation("update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody RegionSaveReqDTO region){
        RegionEntity regionEntity = RegionSaveReqConverter.INSTANCE.getEntity(region);

        regionService.updateById(regionEntity);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("biz:region:delete")
    @ApiOperation("delete")
    public R delete(@RequestBody Integer[] region_ids){
       regionService.removeByIds(Arrays.asList(region_ids));

        return R.ok();
    }

}
