package site.levimarvin.pxautomessage.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.pxautomessage.PxAutoMessage;

public class ServerUtil {
    public static final JavaPlugin plugin = PxAutoMessage.getPlugin();

    public static String getServerVersion() {
        String[] versions = Bukkit.getVersion().split("\\.");
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

    public static String getNmsPath() {
        return "net.minecraft.server." + getServerVersion();
    }
}
