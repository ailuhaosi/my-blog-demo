package io.gd.modules.biz.resident.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.gd.common.utils.Constant;
import io.gd.common.validator.group.UpdateGroup;
import io.gd.modules.biz.resident.dto.ResidentListReqDTO;
import io.gd.modules.biz.resident.entity.ResidentEntity;
import io.gd.modules.biz.resident.dto.ResidentListResDTO;
import io.gd.modules.biz.resident.dto.ResidentSaveReqDTO;
import io.gd.modules.biz.resident.dto.converter.ResidentSaveReqConverter;
//

import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.gd.modules.biz.resident.service.ResidentService;
import io.gd.common.utils.PageUtils;
import io.gd.common.utils.R;
//////////



/**
 * 住户管理
 *
 * @author gd
 * @email 771747384@qq.com
 * @date 2021-07-12 19:21:53
 */
@RestController
@RequestMapping("biz/resident")
@Api(tags = {"biz_resident"})
public class ResidentController {
    @Autowired
    private ResidentService residentService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("biz:resident:list")
    @ApiOperation("list")
    @ApiResponses({
            @ApiResponse(code = 0, message = "ok", response = ResidentListResDTO.class)
    })
    public R list(ResidentListReqDTO params,String page,String limit){

        ObjectMapper oMapper = new ObjectMapper();
        oMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        oMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Map<String, Object> listReqParams = oMapper.convertValue(params, Map.class);
        //page、limit
        Map<String, Object> pageObj = new HashMap<>(2);
        pageObj.put(Constant.PAGE,page);
        pageObj.put(Constant.LIMIT,limit);
        PageUtils<ResidentListResDTO.ResidentListItemDTO> pageResult = residentService.queryPage(listReqParams,pageObj);

        return R.ok().put("data", pageResult);
    }


    /**
     * 信息
     */
    @GetMapping("/info")
    //@RequiresPermissions("biz:resident:info")
    @ApiOperation("info")
    @ApiResponses({
            @ApiResponse(code = 0, message = "ok", response = ResidentSaveReqDTO.class)
    })
    public R info(Integer residentId){

         ResidentEntity resident = residentService.getById(residentId);

         ResidentSaveReqDTO residentSaveReqDTO = ResidentSaveReqConverter.INSTANCE.getDto(resident);

        return R.ok().put("data", residentSaveReqDTO);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("biz:resident:save")
    @ApiOperation("save")
    public R save(@Validated @RequestBody ResidentSaveReqDTO resident){
        ResidentEntity residentEntity = ResidentSaveReqConverter.INSTANCE.getEntity(resident);

        residentService.save(residentEntity);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("biz:resident:update")
    @ApiOperation("update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody ResidentSaveReqDTO resident){
        ResidentEntity residentEntity = ResidentSaveReqConverter.INSTANCE.getEntity(resident);

        residentService.updateById(residentEntity);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("biz:resident:delete")
    @ApiOperation("delete")
    public R delete(@RequestBody Integer[] resident_ids){
       residentService.removeByIds(Arrays.asList(resident_ids));

        return R.ok();
    }

}
