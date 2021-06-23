package com.jjb.jjbzentao.controller;

import com.alibaba.fastjson.JSONObject;
import com.jjb.jjbzentao.pojo.Project;
import com.jjb.jjbzentao.pojo.ProjectPO;
import com.jjb.jjbzentao.pojo.RspMsg;
import com.jjb.jjbzentao.service.ProjectService;
import com.jjb.jjbzentao.utils.HttpClient;
import com.jjb.jjbzentao.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    @Autowired
    private HttpClient httpClient;

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
    @ApiOperation(value = "查询天气")
    @GetMapping("/weather")
    public Result<?> list() {
        String url="https://restapi.amap.com/v3/weather/weatherInfo?key=bec510e085f0e2278beb34356c7b031e&city=500000&output=json";
        HttpMethod method=HttpMethod.GET;
        MultiValueMap<String ,String> map=new LinkedMultiValueMap<>();
        return Result.succeed(JSONObject.parse(httpClient.client(url,method,map)));
    }
}
