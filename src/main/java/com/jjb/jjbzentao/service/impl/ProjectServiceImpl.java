package com.jjb.jjbzentao.service.impl;

import com.jjb.jjbzentao.dao.ProjectDao;
import com.jjb.jjbzentao.pojo.Project;
import com.jjb.jjbzentao.pojo.ProjectPO;
import com.jjb.jjbzentao.pojo.RspMsg;
import com.jjb.jjbzentao.pojo.Task;
import com.jjb.jjbzentao.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zxq
 * @date 2021/6/11
 */
@Slf4j
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> list(ProjectPO po) {
        List<Project> result=projectDao.list(po);
        List<Integer> idList = result.stream().map(Project::getId).collect(Collectors.toList());
        //根据迭代id查询迭代子任务
        List<Task> tasks=projectDao.qryTasks(idList);
        Map<Integer, List<Task>> collect = tasks.stream().collect(Collectors.groupingBy(e -> e.getProject()));
        DecimalFormat df=new DecimalFormat("0.00");
        result.forEach(e->{
            if (collect.containsKey(e.getId())){
                float consumed = 0;
                float left=0;
                List<Task> tasksList = collect.get(e.getId());
                for (Task task:tasksList){
                    consumed +=task.getConsumed();
                    left+=task.getLeft();
                }
                e.setSchedule(consumed/(consumed+left));
            }
        });
        return result;
    }
}
