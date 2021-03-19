package site.levimarvin.pxautomessage.minecraft.nms;

import static site.levimarvin.pxautomessage.util.NmsUtil.getNmsClass;

public class NmsClass {
    private static NmsClass NMS;
    public static NmsClass getNms() {
        if (NMS == null) NMS = new NmsClass();
        return NMS;
    }
    public Class<?> iChatBaseComponent;
    public Class<?> chatComponentText;
    public Class<?> packet;
    public Class<?> packetPlayOutTitle;
    public Class<?> enumTitleAction;

    public void getAllClass(){
        try {
            iChatBaseComponent = getNmsClass("IChatBaseComponent");
            chatComponentText = getNmsClass("ChatComponentText");
            packet = getNmsClass("Packet");
            packetPlayOutTitle = getNmsClass("PacketPlayOutTitle");
            enumTitleAction = getNmsClass("PacketPlayOutTitle$EnumTitleAction");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
