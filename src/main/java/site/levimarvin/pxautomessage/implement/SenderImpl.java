package site.levimarvin.pxautomessage.implement;

/**
 * The <code>SenderImpl</code> interface should be implemented by any
 * sender class whose instances are intended to be executed by a thread.
 * The class must define a method of no arguments called <code>run</code>.
 * <p>
 * This interface is designed to provide a common protocol for objects that
 * wish to execute code while they are active. For example,
 * <code>SenderImpl</code> is implemented by class <code>Runnable</code>.
 * Being active simply means that a thread has been started and has not
 * yet been stopped.
 * <p>
 * @author  Levi Marvin
 * @see java.lang.Runnable
 * @since   3.0
 */

public interface SenderImpl extends Runnable {
    String type = "Sender";

    @Override
    void run();

    void stopRunning();

    void outInfo();

    default String getType() {
        return type;
    }
}
