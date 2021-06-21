package com.jjb.jjbzentao.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import com.jjb.jjbzentao.utils.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = CommonUtil.YMD)
    private Date end;

    @ApiModelProperty(value="创建日期")
    @DateTimeFormat(pattern = CommonUtil.YMD)
    private Date begin;
}
