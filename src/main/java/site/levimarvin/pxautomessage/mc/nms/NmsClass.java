package site.levimarvin.pxautomessage.mc.nms;

import static site.levimarvin.pxautomessage.util.ReflectUtil.getNmsClass;

public class NmsClass {
    private static NmsClass NMS;
    public static NmsClass getNms() {
        if (NMS == null) NMS = new NmsClass();
        return NMS;
    }
    //Common components.
    public Class<?> iChatBaseComponent;
    public Class<?> packet;
    //Title components.
    public Class<?> packetPlayOutTitle;
    public Class<?> enumTitleAction;
    //Chat components.
    public Class<?> packetPlayOutChat;
    public Class<?> chatMessageType;

    public void init() {
        try {
            iChatBaseComponent = getNmsClass("IChatBaseComponent");
            packet = getNmsClass("Packet");
            packetPlayOutTitle = getNmsClass("PacketPlayOutTitle");
            enumTitleAction = getNmsClass("PacketPlayOutTitle$EnumTitleAction");
            packetPlayOutChat = getNmsClass("PacketPlayOutChat");
            chatMessageType = getNmsClass("ChatMessageType");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
