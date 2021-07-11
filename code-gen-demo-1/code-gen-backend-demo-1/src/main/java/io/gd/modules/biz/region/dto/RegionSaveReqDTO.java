package io.gd.modules.biz.region.dto;

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
@ApiModel(value = "biz_region-save-req")
public class RegionSaveReqDTO {

    
            
            
                                        @NotNull(message = " 不能为空",groups = UpdateGroup.class)
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
                        }
