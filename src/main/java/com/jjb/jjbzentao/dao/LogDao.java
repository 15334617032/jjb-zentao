package com.jjb.jjbzentao.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jjb.jjbzentao.pojo.Log;
import com.jjb.jjbzentao.pojo.LogPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zxq
 * @date 2021/6/21
 */
@Repository
public interface LogDao extends BaseMapper<LogPO> {
    /**
     * 查询操作日志
     *
     * @param po
     * @return
     */
    List<Log> list(@Param("p") LogPO po);
}
