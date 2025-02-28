package com.roncoo.education.user.service.admin.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * ADMIN-站内信息表
 * </p>
 *
 * @author wujing
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "AdminMsgPageReq", description = "ADMIN-站内信息表分页")
public class AdminMsgPageReq implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "状态(1有效, 0无效)")
    private Integer statusId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "短信类型(1系统消息,2其他)")
    private Integer msgType;

    @ApiModelProperty(value = "短信标题")
    private String msgTitle;

    @ApiModelProperty(value = "短信内容")
    private String msgText;

    @ApiModelProperty(value = "是否定时发送（1是，0否）")
    private Integer isTimeSend;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发送时间")
    private LocalDateTime sendTime;

    @ApiModelProperty(value = "是否已发送(1是;0否)")
    private Integer isSend;

    @ApiModelProperty(value = "是否置顶(1是;0否)")
    private Integer isTop;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "当前页")
    private int pageCurrent = 1;

    @ApiModelProperty(value = "每页条数")
    private int pageSize = 20;
}
