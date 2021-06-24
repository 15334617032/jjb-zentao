package com.jjb.jjbzentao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zxq
 * @date 2021/6/23
 */
@Data
@ApiModel("任务")
public class Team {

    @ApiModelProperty(value="关联id")
    private Integer root;

    @ApiModelProperty(value="名称")
    private String realname;

}
