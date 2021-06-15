package com.jjb.jjbzentao.controller;

import com.jjb.jjbzentao.pojo.Project;
import com.jjb.jjbzentao.pojo.ProjectPO;
import com.jjb.jjbzentao.pojo.RspMsg;
import com.jjb.jjbzentao.service.ProjectService;
import com.jjb.jjbzentao.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author zxq
 * @date 2021/6/11
 */
@Slf4j
@RestController
@Api(tags = "禅道查询迭代")
@RequestMapping("/project")
public class ProjectCtl {

    @Autowired
    private ProjectService projectService;

    @ApiOperation(value = "查询迭代信息")
    @GetMapping("/list")
    public Result<List<Project>> list(ProjectPO po) {
        try {
            List<Project> list= projectService.list(po);
            return Result.succeed(list);
        } catch (Exception e) {
            log.error("查询失败",e);
          return Result.failed("查询失败");
        }
    }
}
