package site.levimarvin.pxautomessage.mc.command;

public enum ErrorInfo {
    CNF("§cCommand not found! Please check it and try again!"),
    HNP("§cYou have not permission to do this! Please check your permission and try again!"),
    CE("§cCommand error! Please check it and try again!");

    String text;
    ErrorInfo(String text) {
        this.text = text;
    }
}
