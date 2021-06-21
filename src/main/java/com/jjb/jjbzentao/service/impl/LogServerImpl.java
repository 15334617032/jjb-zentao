package com.jjb.jjbzentao.service.impl;

import com.jjb.jjbzentao.dao.LogDao;
import com.jjb.jjbzentao.dao.ProjectDao;
import com.jjb.jjbzentao.enums.ActionEnum;
import com.jjb.jjbzentao.pojo.Log;
import com.jjb.jjbzentao.pojo.LogPO;
import com.jjb.jjbzentao.service.LogServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zxq
 * @date 2021/6/21
 */
@Slf4j
@Service
@Transactional
public class LogServerImpl implements LogServer {


    @Autowired
    private LogDao logDao;

    @Override
    public List<Log> list(LogPO po) {
        List<Log> result=logDao.list(po);
        result.forEach(e->{
            if (e.getAction().equals(ActionEnum.LOGIN.getCode()) || e.getAction().equals(ActionEnum.LOGOUT.getCode())){
                e.setObjective("系统");
            }
            if (ActionEnum.map.containsKey(e.getAction())){
                e.setAction(ActionEnum.map.get(e.getAction()));
            }else {
                e.setAction(ActionEnum.map.get("unknown"));
            }
        });
        return result;
    }
}
