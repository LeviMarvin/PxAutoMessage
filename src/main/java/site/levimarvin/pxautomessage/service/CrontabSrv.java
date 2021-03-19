package site.levimarvin.pxautomessage.service;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import site.levimarvin.pxautomessage.PxAutoMessage;
import site.levimarvin.pxautomessage.implement.CrontabImpl;

public class CrontabSrv implements CrontabImpl {
    public static final JavaPlugin plugin = PxAutoMessage.getPlugin();
    public static final BukkitScheduler schedule = PxAutoMessage.getPlugin().getServer().getScheduler();
    public static int taskId;
    @Override
    public void task() {}

    @Override
    public void taskInfo() {}

    @Override
    public void start() {
        taskId = schedule.runTask(plugin, this::task).getTaskId();
    }

    @Override
    public void stop() {
        schedule.cancelTask(taskId);
    }
}
