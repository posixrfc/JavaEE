package cn.itcast.purchasing.util;

import javax.servlet.http.HttpSession;
import cn.itcast.purchasing.vo.ActiveUser;

public class UserUtil {

    public static final String USER = "activeUser";

    public static void saveUserToSession(HttpSession session, ActiveUser activeUser) {
        session.setAttribute(USER, activeUser);
    }

    public static ActiveUser getUserFromSession(HttpSession session) {
        Object attribute = session.getAttribute(USER);
        return attribute == null ? null : (ActiveUser) attribute;
    }
}