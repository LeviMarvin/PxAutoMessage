package site.levimarvin.pxautomessage.util;

public class StringUtil {
    public static String[] v2Json(String text) {
        return null;
    }

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

    public static String getJson(String key, String value) {
        return "{\"" + key + "\":\"" + value + "\"}";
    }

    public static String getJson(String key1, String key2, String value1, String value2) {
        return "{\"" + key1 + "\":\"" + value1 + "\",\"" + key2 + "\":\"" + value2 + "\"}";
    }
}
