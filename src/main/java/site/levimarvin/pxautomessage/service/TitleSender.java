package site.levimarvin.pxautomessage.service;

import org.bukkit.entity.Player;
import site.levimarvin.pxautomessage.implement.SenderImpl;
import site.levimarvin.pxautomessage.util.NmsUtil;

import java.lang.reflect.InvocationTargetException;

public class TitleSender implements SenderImpl {
    public static void sendTitle(Player p, String title, String subTitle, int fadeIn, int stay, int fadeOut){
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
}
