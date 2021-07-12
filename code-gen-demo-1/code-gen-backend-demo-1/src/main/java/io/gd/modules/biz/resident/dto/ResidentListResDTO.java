package io.gd.modules.biz.resident.dto;

import io.gd.common.utils.PageUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 对应表格列的每个组件
 * */

@ApiModel(value = "biz_resident-list-res")
public class ResidentListResDTO extends PageUtils<ResidentListResDTO.ResidentListItemDTO> {

    @Data
    @ApiModel(value = "biz_resident-list-res-item")
    public static class ResidentListItemDTO {
        
                    
                                                @ApiModelProperty(value = "住户id")
                    private Integer residentId;
                                    @ApiModelProperty(value = "住户姓名")
                    private String residentName;
                                    @ApiModelProperty(value = "联系电话")
                    private String residentMobile;
                                    @ApiModelProperty(value = "联系电话")
                    private Integer residentType;
                                    @ApiModelProperty(value = "住户类型")
                    private String residentRemark;
                                    @ApiModelProperty(value = "住户所在小区")
                    private String belongtoRegion;
                                    
                        }
}
