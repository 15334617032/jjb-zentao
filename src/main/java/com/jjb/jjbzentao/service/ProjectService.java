package com.jjb.jjbzentao.service;

import com.jjb.jjbzentao.pojo.Project;
import com.jjb.jjbzentao.pojo.ProjectPO;
import com.jjb.jjbzentao.pojo.RspMsg;

import java.util.List;

public interface ProjectService {
    /**
     * 查询迭代项目信息
     * @param po
     * @return
     */
    List<Project> list(ProjectPO po);
}
