package io.gd.modules.biz.resident.dto;

import io.gd.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 保存和更新 提交表单
 * 对应新增按钮弹窗的表单组件
 * */

@Data
@ApiModel(value = "biz_resident-save-req")
public class ResidentSaveReqDTO {

    
            
            
                                        @NotNull(message = "住户id 不能为空",groups = UpdateGroup.class)
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
