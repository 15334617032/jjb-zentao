package com.jjb.jjbzentao.service;

import com.jjb.jjbzentao.pojo.Log;
import com.jjb.jjbzentao.pojo.LogPO;

import java.util.List;

public interface LogServer {
    /**
     * 查询操作日志
     * @param po
     * @return
     */
    List<Log> list(LogPO po);
}
