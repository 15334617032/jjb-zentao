package com.jjb.jjbzentao.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: jjb
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private T datas;
    private Integer resp_code;
    private String resp_msg;
    public static <T> Result<T> succeed() {
        return of(null, CodeEnum.Code.SUCCESS.getCode(), null);
    }
    public static <T> Result<T> succeed(String msg) {
        return of(null, CodeEnum.Code.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> succeed(T model,String msg) {
        return of(model, CodeEnum.Code.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> succeed(T model) {
        return of(model, CodeEnum.Code.SUCCESS.getCode(), "");
    }

    public static <T> Result<T> of(T datas, Integer code, String msg) {
        return new Result<>(datas, code, msg);
    }
    public static <T> Result<T> failed() {
        return of(null, CodeEnum.Code.FAIL.getCode(), null);
    }

    public static <T> Result<T> failed(Integer code) {
        return of(null, code, null);
    }
    public static <T> Result<T> failed(String msg) {
        return of(null, CodeEnum.Code.FAIL.getCode(), msg);
    }
    public static <T> Result<T> failed(Integer code,String msg) {
        return failedWith(null, code, msg);
    }
    public static <T> Result<T> failed(T model, String msg) {
        return failedWith(model, CodeEnum.Code.FAIL.getCode(), msg);
    }
    public static <T> Result<T> failedWith(T datas, Integer code, String msg) {
        return new Result<>(datas, code, msg);
    }

}
