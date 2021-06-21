package com.jjb.jjbzentao.controller;

import com.jjb.jjbzentao.pojo.Log;
import com.jjb.jjbzentao.pojo.LogPO;
import com.jjb.jjbzentao.pojo.Project;
import com.jjb.jjbzentao.pojo.ProjectPO;
import com.jjb.jjbzentao.service.LogServer;
import com.jjb.jjbzentao.service.ProjectService;
import com.jjb.jjbzentao.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zxq
 * @date 2021/6/18
 */
@Slf4j
@RestController
@Api(tags = "禅道查询迭代")
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogServer logServer;

    @ApiOperation(value = "查询操作日志")
    @GetMapping("/list")
    public Result<List<Log>> list(LogPO po) {
        try {
            List<Log> list= logServer.list(po);
            return Result.succeed(list);
        } catch (Exception e) {
            log.error("查询失败",e);
            return Result.failed("查询失败");
        }
    }
}
