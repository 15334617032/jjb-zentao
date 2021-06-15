package com.jjb.jjbzentao.utils;

/**
 * @Author: jjb
 */
public interface CodeEnum {
    /**
     * @param @return 参数
     * @return String    返回类型
     * @throws
     * @Title: getMsg
     * @Description:
     * @author lijie
     */
    String getMsg();

    /**
     * @param @return 参数
     * @return String    返回类型
     * @throws
     * @Title: getCode
     * @Description:
     * @author lijie
     */
    Integer getCode();

    enum Code implements CodeEnum {
        /**
         * 系统错误提示枚举值
         */
        SUCCESS(200, "操作成功"),
        FAIL(300, "操作失败"),
        ILLEGALARGUMENT(400, "请求参数非法"),
        UNAUTHORIZED(401, "拒绝访问"),
        INTERNAL_SERVER_ERROR(405, "网络繁忙，请稍后再试！"),
        PERMISSION_DENIED(403, "没有权限访问！"),
        REQUEST_DATA_ERROR(10100, "请求参数异常"),
        REPETITION(10102, "操作过于频繁，请稍后再试！"),
        ILLEGAL_OPTION(10103, "请勿非法操作")
        ;
        private Integer code;
        private String msg;

        Code(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public String getMsg() {
            return msg;
        }

        @Override
        public Integer getCode() {
            return code;
        }
    }
    enum DemoCode implements CodeEnum {
        TEST_TYPE_NULL(10001, "TEST类型不能为空!"),
        TEST_CODE_NULL(10002, "TEST编号不能为空！"),
        ;
        private Integer code;
        private String msg;

        DemoCode(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public String getMsg() {
            return msg;
        }

        @Override
        public Integer getCode() {
            return code;
        }
    }
}
