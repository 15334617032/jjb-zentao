package com.jjb.jjbzentao.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zyq
 * @Description 返回结果
 **/
@Data
public class RspMsg implements Serializable {
    /**
     * 返回码
     */
    private String retCode;
    /**
     * 返回信息
     */
    private String retMsg;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 分页信息
     */
    private MyPage page;


    public RspMsg(String retCode, String retMsg, Object data, MyPage page) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.data = data;
        this.page = page;
    }

    public RspMsg(String retCode, String retMsg, Object data) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.data = data;
    }

    public RspMsg(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public RspMsg(String retMsg) {
        this.retCode = "fail";
        this.retMsg = retMsg;
    }

    public RspMsg() {
    }

    public RspMsg setOkMsg(String retMsg) {
        this.retCode = "ok";
        this.retMsg = retMsg;
        return this;
    }

    public RspMsg setFailMsg(String retMsg) {
        this.retCode = "fail";
        this.retMsg = retMsg;
        return this;
    }

    public RspMsg setData(Object data) {
        this.data = data;
        return this;
    }

    public RspMsg setPage(MyPage page) {
        this.page = page;
        return this;
    }
}
