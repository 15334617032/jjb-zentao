package com.jjb.jjbzentao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zxq
 * @date 2021/6/11
 */
@Data
@ApiModel("任务")
public class Task {

    @ApiModelProperty(value="任务id")
    private Integer id;

    @ApiModelProperty(value="项目名称")
    private String name;

    @ApiModelProperty(value="所属迭代")
    private Integer project;

    @ApiModelProperty(value="迭代状态" +
            "enum('wait','doing','done','pause','cancel','closed')")
    private String status;

    @ApiModelProperty(value="总计消耗")
    private float consumed;

    @ApiModelProperty(value="预计消耗")
    private float left;

}
