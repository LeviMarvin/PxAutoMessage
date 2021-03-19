package site.levimarvin.pxautomessage.implement;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.pxautomessage.PxAutoMessage;
import site.levimarvin.pxautomessage.minecraft.nms.NmsClass;
import site.levimarvin.pxautomessage.util.NmsUtil;

import java.lang.reflect.InvocationTargetException;

public interface SenderImpl {
    JavaPlugin plugin = PxAutoMessage.getPlugin();
    NmsClass nmsClass = NmsClass.getNms();

    static void sendTitle(Player p, String title, String subTitle, int fadeIn, int stay, int fadeOut){
        try {
            Object mainTitleText = nmsClass.chatComponentText.getConstructor(String.class).newInstance(title);
            Object subTitleText = nmsClass.chatComponentText.getConstructor(String.class).newInstance(subTitle);
            Object enumTITLE = nmsClass.enumTitleAction
                    .getMethod("a", String.class)
                    .invoke(nmsClass.enumTitleAction.getConstructor().newInstance(), "TITLE");
            Object enumSUBTITLE = nmsClass.enumTitleAction
                    .getMethod("a", String.class)
                    .invoke(nmsClass.enumTitleAction.getConstructor().newInstance(), "SUBTITLE");
            Object mainTitlePacket = nmsClass.packetPlayOutTitle
                    .getConstructor(nmsClass.enumTitleAction, nmsClass.iChatBaseComponent, int.class, int.class, int.class)
                    .newInstance(enumTITLE, mainTitleText, fadeIn, stay, fadeOut);
            Object subTitlePacket = nmsClass.packetPlayOutTitle
                    .getConstructor(nmsClass.enumTitleAction, nmsClass.iChatBaseComponent, int.class, int.class, int.class)
                    .newInstance(enumSUBTITLE, subTitleText, fadeIn, stay, fadeOut);
            Object craftPlayer = NmsUtil.getObcClass("CraftPlayer").cast(p);
            Object entityPlayer = craftPlayer.getClass().getMethod("getHandle").invoke(craftPlayer);
            Object playerConnection = entityPlayer.getClass().getField("playerConnection").get(entityPlayer);
            playerConnection.getClass().getMethod("sendPacket",nmsClass.packet)
                    .invoke(playerConnection, mainTitlePacket);
            playerConnection.getClass().getMethod("sendPacket",nmsClass.packet)
                    .invoke(playerConnection, subTitlePacket);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /*public static void sendPlayerTitle(Player player, int fadeIn, int stay, int fadeOut, String title) {
        PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
        PacketPlayOutTitle packetPlayOutTimes =
            new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn, stay, fadeOut);
        connection.sendPacket(packetPlayOutTimes);
        IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{"text": "" + title + ""}");
        PacketPlayOutTitle packetPlayOutTitle =
            new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
        connection.sendPacket(packetPlayOutTitle);
    }*/
}
