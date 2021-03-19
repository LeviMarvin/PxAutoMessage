package site.levimarvin.pxautomessage.implement;

public interface SenderImpl extends Runnable {
    @Override
    void run();

    void outInfo();
}
