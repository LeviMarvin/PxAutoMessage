package site.levimarvin.pxautomessage.service.sender;

import org.bukkit.entity.Player;
import site.levimarvin.pxautomessage.PxAutoMessage;
import site.levimarvin.pxautomessage.implement.SenderImpl;
import site.levimarvin.pxautomessage.minecraft.nms.NmsClass;
import site.levimarvin.pxautomessage.util.NmsUtil;

import java.lang.reflect.InvocationTargetException;

public class TitleSender implements SenderImpl {

    @Override
    public void run() {
        for (Player p : PxAutoMessage.playerList) {
            sendTitle(p, "Title", "SubTitle",1,1,1);
        }
    }

    @Override
    public void outInfo() {

    }

    public static void sendTitle(Player p, String title, String subTitle, int fadeIn, int stay, int fadeOut){
        try {
            Object mainTitleText = NmsClass.getNms().chatComponentText.getConstructor(String.class).newInstance(title);
            Object subTitleText = NmsClass.getNms().chatComponentText.getConstructor(String.class).newInstance(subTitle);
            Object enumTITLE = null;
            for (Enum<?> currentEnum : (Enum<?>[]) NmsClass.getNms().enumTitleAction.getEnumConstants()) {
                String name = currentEnum.name();
                if (name.equals("TITLE")) {
                    enumTITLE = currentEnum;
                }
            }
            Object enumSUBTITLE = null;
            for (Enum<?> currentEnum : (Enum<?>[]) NmsClass.getNms().enumTitleAction.getEnumConstants()) {
                String name = currentEnum.name();
                if (name.equals("SUBTITLE")) {
                    enumSUBTITLE = currentEnum;
                }
            }
            Object mainTitlePacket = NmsClass.getNms().packetPlayOutTitle
                    .getConstructor(NmsClass.getNms().enumTitleAction, NmsClass.getNms().iChatBaseComponent, int.class, int.class, int.class)
                    .newInstance(enumTITLE, mainTitleText, fadeIn, stay, fadeOut);
            Object subTitlePacket = NmsClass.getNms().packetPlayOutTitle
                    .getConstructor(NmsClass.getNms().enumTitleAction, NmsClass.getNms().iChatBaseComponent, int.class, int.class, int.class)
                    .newInstance(enumSUBTITLE, subTitleText, fadeIn, stay, fadeOut);
            Object craftPlayer = NmsUtil.getObcClass("CraftPlayer").cast(p);
            Object entityPlayer = craftPlayer.getClass().getMethod("getHandle").invoke(craftPlayer);
            Object playerConnection = entityPlayer.getClass().getField("playerConnection").get(entityPlayer);
            playerConnection.getClass().getMethod("sendPacket", NmsClass.getNms().packet)
                    .invoke(playerConnection, mainTitlePacket);
            playerConnection.getClass().getMethod("sendPacket", NmsClass.getNms().packet)
                    .invoke(playerConnection, subTitlePacket);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    //public void sendTitle(Player player, String title, int fadeIn, int stay, int fadeOut) throws ClassNotFoundException {
        /*PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
        PacketPlayOutTitle packetPlayOutTimes =
            new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn, stay, fadeOut);
        connection.sendPacket(packetPlayOutTimes);
        IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": "" + title + ""}");
        PacketPlayOutTitle packetPlayOutTitle =
            new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
        connection.sendPacket(packetPlayOutTitle);*/
        /*try {
            Constructor<?> constructor = NmsUtil.getNmsClass("PacketPlayOutChat").getConstructor(NmsUtil.getNmsClass("IChatBaseComponent"), NmsUtil.getNmsClass("ChatMessageType"));
            Object icbc = NmsUtil.getNmsClass("IChatBaseComponent").getMethod("a", String.class).invoke(null, "{\"text\":\"" + title + "\"}");
            Object packet = constructor.newInstance(icbc, NmsUtil.getNmsClass("ChatMessageType").getEnumConstants()[2]);
            Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
            Object playerConnection = entityPlayer.getClass().getField("playerConnection").get(entityPlayer);
            playerConnection.getClass().getMethod("sendPacket", NmsUtil.getNmsClass("Packet")).invoke(playerConnection, packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
