package com.jjb.jjbzentao.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jjb.jjbzentao.pojo.Project;
import com.jjb.jjbzentao.pojo.ProjectPO;
import com.jjb.jjbzentao.pojo.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDao extends BaseMapper<Project> {
    /**
     * 查询迭代项目信息
     * @param po
     * @return
     */
    List<Project> list(@Param("p") ProjectPO po);

    /**
     * 根据迭代id查询迭代子任务
     * @param idList
     * @return
     */
    List<Task> qryTasks(@Param("list")List<Integer> idList);
}
