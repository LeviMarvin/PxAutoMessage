package site.levimarvin.pxautomessage.util;

/**
 * @author Levi Marvin
 */
public class StringUtil {
    public static boolean isJson(String text) {
        boolean r = false;
        if (!"".equals(text)) {
            text = text.trim();
            if (text.startsWith("{") && text.endsWith("}")) {
                r = true;
            } else if (text.startsWith("[") && text.endsWith("]")) {
                r = true;
            }
        }
        return r;
    }
}
