package io.gd.modules.biz.region.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 对应表格上方的表单组件的字段信息
 */

@Data
@ApiModel(value = "biz_region-list-req")
public class RegionListReqDTO {

    
                                    @ApiModelProperty(value = "")
                private Integer regionId;
                            @ApiModelProperty(value = "区域名称")
                private String regionTitle;
                            @ApiModelProperty(value = "联系人")
                private String regionContact;
                            @ApiModelProperty(value = "联系电话")
                private String regionMobile;
                        
            
            
}
