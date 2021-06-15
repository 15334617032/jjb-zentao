package com.jjb.jjbzentao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jjb.jjbzentao.utils.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author zxq
 * @date 2021/6/11
 */
@Data
@ApiModel("迭代信息")
public class Project {

    @ApiModelProperty(value="迭代id")
    private Integer id;

    @ApiModelProperty(value="项目名称")
    private String name;

    @ApiModelProperty(value="迭代状态" +
            "enum('wait','doing','done','pause','cancel','closed')")
    private String status;

    @ApiModelProperty(value="迭代代号")
    private String code;

    @ApiModelProperty(value="截止时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CommonUtil.YMD, timezone = CommonUtil.DEFAULT_TIMEZONE_GMT)
    private Date end;

    @ApiModelProperty(value="创建日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CommonUtil.YMD, timezone = CommonUtil.DEFAULT_TIMEZONE_GMT)
    private Date begin;

    @ApiModelProperty(value="产品负责人")
    private String po;
    @ApiModelProperty(value="团队成员")
    private String team;

    @ApiModelProperty(value = "进度")
    private float schedule;

}
