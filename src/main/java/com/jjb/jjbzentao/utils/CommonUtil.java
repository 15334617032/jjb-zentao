package com.jjb.jjbzentao.utils;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;



/**
 * 公用 工具类
 *
 * @author jjb
 */
@Slf4j
public final class CommonUtil {

    public static final String delimiter1 = "@";
    public static final String HORIZONTAL_LINE = "-";
    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMDHM = "yyyy-MM-dd HH:mm";
    public static final String YMDHM_CHINESE = "yyyy年MM月dd日HH:mm";
    public static final String YMDHM_CONCAT = "yyyyMMddHHmm";
    public static final String Y_CONCAT = "yyyy";
    public static final String SYMDHM_CONCAT = "yyMMddHHmm";
    public static final String YMD = "yyyy-MM-dd";
    public static final String HM = "HH:mm";
    public static final String HM_CONCAT = "HHmm";
    public static final String COMMA = ",";
    public static final String POINT = ".";
    public static final String WAVE_LINE = "~";
    public static final String BASE64_IMG_PREFIX = "data:image/jpeg;base64,";
    public static final String EMPTY = "";
    public static final String ESCAPE_NEWLINE = "(\r\n|\n)";
    public static final String RIGHT_SLASH = "/";
    public static final String JPEG = ".jpeg";
    public static final String DOCX = ".docx";
    /**
     * 默认时区，东八区
     */
    public static final String DEFAULT_TIMEZONE_GMT="GMT+8";

    /**
     * 默认父ID（请千万不要改为对象类型）
     */
    public static final int DEFAULT_PARENT_ID = -1;
    public static final long DEFAULT_PARENT_ID_L = -1L;

    /**
     * 身份证正则
     */
    public static final String ID_CARD_REGEX_STR = "^[1-9]\\d{5}(18|19|([23]\\d))" +
            "\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$|^[1-9]" +
            "\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$";

    public static final String ID_CARD_ERROR = "身份证格式不正确";
    /**
     * 手机号正则
     */
    public static final String PHONE_REGEX_STR = "^1\\d{10}$";
    public static final String PHONE_ERROR = "手机号格式不正确";

    /**
     * 默认账号密码
     */
    public static final String DEF_USER_PASSWORD = "Admin123456";

    /**
     * 数据比对中无需比对的字段
     */
    private static final String[] FILTER_FIELDS = {"id", "createTime", "updateTime"};


    public static String getUUID() {
        return UUID.randomUUID().toString().replace(HORIZONTAL_LINE, EMPTY);
    }

    /**
     * 验证是否身份证号
     *
     * @param idCard 身份证号
     * @return 是否
     */
    public static boolean isIdCard(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return false;
        }
        return Pattern.matches(ID_CARD_REGEX_STR, idCard);
    }

    /**
     * 验证是否手机号
     *
     * @param phone 手机号
     * @return 是否
     */
    public static boolean isPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return false;
        }
        return Pattern.matches(PHONE_REGEX_STR, phone);
    }

    // =============================================================

    /**
     * 拼接字符串
     *
     * @param params 数据
     * @return 结果
     */
    public static String joinKey(Object... params) {
        String key = Stream.of(params).map(e -> e.toString()).collect(Collectors.joining(delimiter1));
        return key;
//        return Md5Crypt.apr1Crypt(key);
    }

    /**
     * 拼接字符串
     *
     * @param params 数据
     * @return 结果
     */
    public static String joinCode(Object... params) {
        String key = Stream.of(params).map(e -> e.toString()).collect(Collectors.joining("-"));
        return key;
    }


    // =============================================================

    /**
     * 当对象属性为null时设置默认值
     *
     * @param obj
     * @throws Exception
     */
    public static void setFeidValueNotNull(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(obj) == null) {
                if (field.getGenericType().toString().equals("class java.lang.String")) {
                    field.set(obj, "");
                } else if (field.getGenericType().toString().equals("class java.lang.Integer")) {
                    field.set(obj, 0);
                } else if (field.getGenericType().toString().equals("class java.lang.Double")) {
                    field.set(obj, 0.0);
                } else if (field.getGenericType().toString().equals("class java.lang.Long")) {
                    field.set(obj, 0L);
                } else if (field.getGenericType().toString().equals("class java.lang.Boolean")) {
                    field.set(obj, false);
                }
            }
        }
    }


    // =============================================================


    public static String byte2HexStr(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte byt : bytes) {
            sb.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    // =============================================================

    private static final String randNumString = "0123456789";
    public static Random numRandom = new Random();
    public static final int length = 4;

    public static String getRandomNumString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            result.append(randNumString.charAt(numRandom.nextInt(randNumString.length())));
        }
        return result.toString();
    }

    // =============================================================


    // =============================================================

    /**
     * 比较两个对象的值是否发送变动
     *
     * @param src    原对象
     * @param target 目标对象
     * @return true 相同，false 不相同
     * @throws Exception
     */
    public static boolean compareObjectByValue(Object src, Object target) throws Exception {
        Class<?> srcClass = src.getClass();
        Class<?> targetClass = target.getClass();
        Field[] e1Field = srcClass.getDeclaredFields();
        Field[] e2Field = targetClass.getDeclaredFields();
        srcFor:
        for (int i = 0; i < e1Field.length; i++) {
            Field e1F = e1Field[i];
            if (ArrayUtils.contains(FILTER_FIELDS, e1F.getName())) {
                continue;
            }
            Object o1 = srcClass.getMethod(getMethodName(e1F.getName())).invoke(src);
            targetFor:
            for (int j = 0; j < e2Field.length; j++) {
                Field e2F = e2Field[j];
                if (e1F.getName().equals(e2F.getName())) {
                    Class<?> type1 = e1F.getType();
                    Class<?> type2 = e2F.getType();
                    if (!type1.equals(type2)) {
//                        throw new RuntimeException("两个类型不一致");
                        return false;
                    }
                    Object o2 = targetClass.getMethod(getMethodName(e2F.getName())).invoke(target);
                    if (o1 == null && o2 == null) {
                        break targetFor;
                    } else if (o1 != null && o2 != null && o1.equals(o2)) {
                        break targetFor;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 拼装get方法
     *
     * @param fieldName 参数名称
     * @return
     */
    private static String getMethodName(String fieldName) {
        return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
    }

    /**
     * 拼装set方法
     *
     * @param fieldName 参数名称
     * @return
     */
    private static String setMethodName(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
    }



    // =====================================================================


    public static void removeUnlockShutDownHook(Thread hook) {
        if (hook == null) return;
        Runtime.getRuntime().removeShutdownHook(hook);
    }

    // ===============================


    // ===============================

    public static final int MAX_TRY_TIMES = 4 * 300;



    // ===============================

    @SneakyThrows
    public static String getUtf8String(byte[] bytes) {
        String json = new String(bytes, CharEncoding.UTF_8);
        return json;
    }

    // ===============================



    public static <T> T getParamValue(Object[] methodArgs, String paramName) throws IllegalAccessException {
        if (methodArgs == null) return null;
        for (Object arg : methodArgs) {
            List<Field> allFields = getAllFields(arg);
            for (Field field : allFields) {
                if (paramName.equals(field.getName())) {
                    field.setAccessible(true);
                    return (T) field.get(arg);
                }
            }
        }
        return null;
    }

    public static List<Field> getAllFields(Object target) {
        Class<?> superclass = target.getClass().getSuperclass();
        List<Field> superFields = superclass == null ? Collections.EMPTY_LIST : Arrays.asList(superclass.getDeclaredFields());
        List<Field> fields = Stream.of(target.getClass().getDeclaredFields()).collect(Collectors.toList());
        fields.addAll(superFields);
        return fields;
    }

    // =======

    public static BigDecimal getReliableScore(BigDecimal score) {
        if (score == null) return BigDecimal.ZERO;
        return score.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : score;
    }

    public static String makeRulePwKey(Long disciplineId, Long paperRuleId) {
        return joinKey(disciplineId, paperRuleId);
    }


    // ==========================
}
