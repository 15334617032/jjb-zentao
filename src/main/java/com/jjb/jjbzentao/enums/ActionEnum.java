package com.jjb.jjbzentao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author zxq
 */

@Getter
@AllArgsConstructor
public enum ActionEnum {

    /**
     * 操作枚举
     */
    LOGIN("login","登录"),
    CREATED("created","创建"),
    LOGOUT("logout","退出"),
    OPENED("opened","创建"),
    EDITED("edited","编辑了"),
    COMMENTED("commented","评论了"),
    ACTIVATED("activated","激活了"),
    BUGCONFIRMED("bugconfirmed","错误确认"),
    CANCELED("canceled","取消"),
    CHANGED("changed","变更了"),
    EDITESTIMATE("editestimate","编辑估计"),
    EDITFILE("editfile","编辑文件"),
    CLOSED("closed","关闭"),
    FINISHED("finished","完成"),
    LINKCHILDSTORY("linkchildstory","链接子节点"),
    LINKED2BUILD("linked2build","链接 2 构建"),
    LINKED2PLAN("linked2plan","联动2计划"),
    LINKED2PROJECT("linked2project","链接 2 项目"),
    LINKED2RELEASE("linked2release","链接 2 发布"),
    LINKPARENTSTORY("linkparentstory","链接父节点"),
    RECORDESTIMATE("recordestimate","记录估计"),
    RESOLVED("resolved","解决了"),
    RESTARTED("restarted","重新启动"),
    REVIEWED("reviewed","审查"),
    STARTED("started","开始了"),
    SUSPENDED("suspended","暂停"),
    UNLINKEDFROMPLAN("unlinkedfromplan","从计划中取消链接"),
    UNLINKEDFROMPROJECT("unlinkedfromproject","与项目取消链接"),
    UNLINKEDFROMRELEASE("unlinkedfromrelease","从发布取消链接"),
    ASSIGNED("assigned","指派了"),
    UNKNOWN("unknown","未知");

    private final String code;
    private final String value;

    public static Map<String, String> map = null;

    static {
        map = new ConcurrentHashMap<>(ActionEnum.values().length);
        for (ActionEnum actionEnum : ActionEnum.values()) {
            map.put(actionEnum.getCode(),actionEnum.getValue());
        }
    }

    public static String getAction(String code) {
        if (StringUtils.isNotBlank(code)) {
            for (ActionEnum actionEnum : ActionEnum.values()) {
                if (actionEnum.getCode().equals(code.trim())) {
                    return actionEnum.getValue();
                }
            }
            return code;
        }
        return ActionEnum.UNKNOWN.getValue();
    }
}
