package com.example.demo.entity;

import com.example.demo.service.ValidateLoginModel;
import com.example.demo.service.ValidateSaveModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ValidateLogin {

    @ApiModelProperty(value = "用户名称")
    @NotEmpty(message = "用户名不能为空！", groups = ValidateLoginModel.class)
    @NotEmpty(message = "添加时用户名不能为空！", groups = ValidateSaveModel.class)
    private String userName;

    @ApiModelProperty(value = "密码")
    @Size(min = 2,message = "密码最少为2位",groups = ValidateLoginModel.class)
    @Size(min = 6,message = "密码最少为6位",groups = ValidateSaveModel.class)
    private String password;
}
