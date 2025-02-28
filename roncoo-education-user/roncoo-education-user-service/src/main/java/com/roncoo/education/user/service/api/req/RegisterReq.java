/**
 * Copyright 2015-现在 广州市领课网络科技有限公司
 */
package com.roncoo.education.user.service.api.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户基本信息
 * </p>
 *
 * @author wujing123
 */
@Data
@Accessors(chain = true)
public class RegisterReq implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机", required = true)
    private String mobile;
    /**
     * 登录密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String mobilePwd;
    /**
     * 重复密码
     */
    @ApiModelProperty(value = "重复密码", required = true)
    private String repassword;
    /**
     * 手机验证码
     */
    @ApiModelProperty(value = "手机验证码", required = true)
    private String code;

    @ApiModelProperty(value = "ip地址")
    private String ip;
}
