package site.levimarvin.pxautomessage.service;

import site.levimarvin.pxautomessage.service.sender.TitleSender;

public class SenderManagerSrv implements Runnable {
    public ThreadGroup senderGroup;
    public Thread titleSender;

    @Override
    public void run() {
        senderGroup = new ThreadGroup("Sender Threads Group");
        titleSender = new Thread(senderGroup, new TitleSender());
        titleSender.start();
    }

    public void stop() {
        if (!titleSender.isInterrupted()) {
            titleSender.interrupt();
        }
    }
}
