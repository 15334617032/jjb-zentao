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
public class ProjectPO {

    @ApiModelProperty(value="项目名称")
    private String name;

    @ApiModelProperty(value="迭代状态" +
            "enum('wait','doing','done','pause','cancel','closed')")
    private String status;

    @ApiModelProperty(value="截止时间")
    private Date end;

    @ApiModelProperty(value="创建日期")
    private Date begin;




}
