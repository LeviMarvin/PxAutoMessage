package site.levimarvin.pxautomessage.util;

import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.pxautomessage.PxAutoMessage;

/**
 * @author Levi Marvin
 */
public class ServerUtil {
    private static final JavaPlugin PLUGIN = PxAutoMessage.getPlugin();

    public static String getServerVersion() {
        String[] versions = PLUGIN.getServer().getBukkitVersion().split("\\.");
        String major = versions[0];
        String minor = versions[1];
        String revision = "-1";
        String NMSBaseHead = "net.minecraft.server.v" + major + "_" + minor + "_R";
        for (int i = 1; i <= 9; i++) {
            String versionTest = NMSBaseHead + i;
            try {
                Class.forName(versionTest + ".ItemStack");
                revision = i + "";
                break;
            } catch (ClassNotFoundException ignored) {}
        }
        return "v" + major + "_" + minor + "_R"+ revision;
    }
}
