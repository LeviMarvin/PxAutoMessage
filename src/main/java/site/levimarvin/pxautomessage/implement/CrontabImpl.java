package site.levimarvin.pxautomessage.implement;
/*
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import site.levimarvin.pxautomessage.PxAutoMessage;
*/
public interface CrontabImpl {
    /*public static final JavaPlugin plugin = PxAutoMessage.getPlugin();
    public static final BukkitScheduler schedule = PxAutoMessage.getPlugin().getServer().getScheduler();
    public void task();*/
    /**
     * @implSpec
     * This implementation is to print this Crontab's information.
     * Like id, interval, function, etc.
     */
    public void taskInfo();

    public void start();
    public void stop();
}
