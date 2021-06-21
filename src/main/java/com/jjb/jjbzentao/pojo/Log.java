package com.jjb.jjbzentao.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jjb.jjbzentao.utils.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zxq
 * @date 2021/6/21
 */
@Data
@ApiModel("迭代信息")
@TableName("zt_action")
public class Log {

    @ApiModelProperty(value="操作者")
    private String realname;
    @ApiModelProperty(value="时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CommonUtil.YMD, timezone = CommonUtil.DEFAULT_TIMEZONE_GMT)
    private String date;
    @ApiModelProperty(value="备注")
    private String comment;
    @ApiModelProperty(value="对象类型")
    private String objectType;
    @ApiModelProperty(value="动作")
    private String action;
    @ApiModelProperty(value="目的")
    private String objective;
}
