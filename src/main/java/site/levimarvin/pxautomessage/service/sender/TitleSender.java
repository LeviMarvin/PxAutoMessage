package site.levimarvin.pxautomessage.service.sender;

import org.bukkit.entity.Player;
import site.levimarvin.pxautomessage.PxAutoMessage;
import site.levimarvin.pxautomessage.implement.SenderImpl;
import site.levimarvin.pxautomessage.minecraft.nms.NmsClass;
import site.levimarvin.pxautomessage.minecraft.obc.ObcClass;

public class TitleSender implements SenderImpl {
    @Override
    public void run() {
        for (Player p : PxAutoMessage.playerList) {
            sendTitle(p, "Title", "SubTitle",1,1,1);
        }
    }

    public void stopRunning() {

    }

    public void outInfo() {

    }

    public static void sendTitle(Player p, String titleText, String subTitleText, int in, int stay, int out) {
        try {
            //Create main title object.
            Object mainTitle = NmsClass.getNms().chatComponentText
                    .getConstructor(String.class).newInstance(titleText);
            Object enumTITLE = NmsClass.getNms().enumTitleAction
                    .getDeclaredMethod("a", String.class)
                    .invoke(NmsClass.getNms().enumTitleAction.getConstructor().newInstance(),"TITLE");
            Object packetPlayOutMainTitle = NmsClass.getNms().packetPlayOutTitle.getConstructor(
                    NmsClass.getNms().enumTitleAction,
                    NmsClass.getNms().iChatBaseComponent,
                    int.class, int.class, int.class
            ).newInstance(enumTITLE, mainTitle, in, stay, out);
            //Create sub title object.
            Object subTitle = NmsClass.getNms().chatComponentText
                    .getConstructor(String.class).newInstance(subTitleText);
            Object enumSUBTITLE = NmsClass.getNms().enumTitleAction
                    .getDeclaredMethod("a", String.class)
                    .invoke(NmsClass.getNms().enumTitleAction.getConstructor().newInstance(),"SUBTITLE");
            Object packetPlayOutSubTitle = NmsClass.getNms().packetPlayOutTitle.getConstructor(
                    NmsClass.getNms().enumTitleAction,
                    NmsClass.getNms().iChatBaseComponent,
                    int.class, int.class, int.class
            ).newInstance(enumSUBTITLE, subTitle, in, stay, out);
            //Get CraftPlayer object belong to Player(p).
            Object craftPlayer = ObcClass.getObc().craftPlayer.cast(p);
            //Get EntityPlayer object belong to CraftPlayer(craftPlayer).
            Object entityPlayer = ObcClass.getObc().craftPlayer.getMethod("getHandle").invoke(craftPlayer);
            //Get PlayerConnection.
            Object playerConnection = entityPlayer.getClass().getField("playerConnection").get(entityPlayer);
            //Send titles.
            playerConnection.getClass().getMethod("sendPacket",NmsClass.getNms().packet)
                    .invoke(playerConnection, packetPlayOutMainTitle);
            playerConnection.getClass().getMethod("sendPacket",NmsClass.getNms().packet)
                    .invoke(playerConnection, packetPlayOutSubTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
