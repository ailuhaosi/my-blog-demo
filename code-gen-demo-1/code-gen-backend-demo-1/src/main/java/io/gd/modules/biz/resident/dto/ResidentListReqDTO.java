package io.gd.modules.biz.resident.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 对应表格上方的表单组件的字段信息
 */

@Data
@ApiModel(value = "biz_resident-list-req")
public class ResidentListReqDTO {

    
                                    @ApiModelProperty(value = "住户id")
                private Integer residentId;
                            @ApiModelProperty(value = "住户姓名")
                private String residentName;
                            @ApiModelProperty(value = "联系电话")
                private String residentMobile;
                        
            
            
}
