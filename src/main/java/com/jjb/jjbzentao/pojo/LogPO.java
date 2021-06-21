package com.jjb.jjbzentao.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author zxq
 * @date 2021/6/21
 */
@Data
@ApiModel("迭代信息")
@TableName("zt_action")
public class LogPO {


    @ApiModelProperty(value="截止时间")
    private Date end;

    @ApiModelProperty(value="创建日期")
    private Date begin;
}
