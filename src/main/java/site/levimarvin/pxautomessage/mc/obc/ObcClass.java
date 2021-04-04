package site.levimarvin.pxautomessage.mc.obc;

import static site.levimarvin.pxautomessage.util.ReflectUtil.getObcClass;

public class ObcClass {
    private static ObcClass OBC;
    public static ObcClass getObc() {
        if (OBC == null) OBC = new ObcClass();
        return OBC;
    }

    public Class<?> craftPlayer;

    public void init() {
        try {
            craftPlayer = getObcClass("CraftPlayer");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
