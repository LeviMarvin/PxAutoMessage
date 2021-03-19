package site.levimarvin.pxautomessage.util;

public class StringUtil {
    public static boolean isJson(String text) {
        boolean r = false;
        if (!text.equals("")) {
            text = text.trim();
            if (text.startsWith("{") && text.endsWith("}")) {
                r = true;
            } else if (text.startsWith("[") && text.endsWith("]")) {
                r = true;
            }
        }
        return r;
    }

    public static String toJson(String key, String text) {
        return "{" + "\"" + key + "\":" + text + "}";
    }
}
