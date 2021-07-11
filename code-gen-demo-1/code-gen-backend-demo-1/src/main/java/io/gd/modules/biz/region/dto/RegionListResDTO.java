package io.gd.modules.biz.region.dto;

import io.gd.common.utils.PageUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 对应表格列的每个组件
 * */

@ApiModel(value = "biz_region-list-res")
public class RegionListResDTO extends PageUtils<RegionListResDTO.RegionListItemDTO> {

    @Data
    @ApiModel(value = "biz_region-list-res-item")
    public static class RegionListItemDTO {
        
                    
                                                @ApiModelProperty(value = "")
                    private Integer regionId;
                                    @ApiModelProperty(value = "区域名称")
                    private String regionTitle;
                                    @ApiModelProperty(value = "联系人")
                    private String regionContact;
                                    @ApiModelProperty(value = "联系电话")
                    private String regionMobile;
                                    @ApiModelProperty(value = "区域图标")
                    private String regionLogo;
                                    @ApiModelProperty(value = "备注")
                    private String regionRemark;
                                    
                        }
}
