package net.rmplugins.rmautomessage.mc.obc;

import net.rmplugins.rmautomessage.util.ReflectUtil;

/**
 * @author Levi Marvin
 */
public class ObcClass {
    private static ObcClass OBC;
    public static ObcClass getObc() {
        if (OBC == null) OBC = new ObcClass();
        return OBC;
    }

    public Class<?> craftPlayer;

    public void init() {
        try {
            craftPlayer = ReflectUtil.getObcClass("CraftPlayer");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
