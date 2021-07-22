package basic;

/**
 * @author wangpeng
 * @since 2020-12-24
 */
public class InterruptTest {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        if (Thread.interrupted()) {
            System.out.println(thread.getName() + " is interrupted");
        } else {
            System.out.println(thread.getName() + " is not interrupted");
        }

        thread.interrupt();
        synchronized (thread){
            try {
                thread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (Thread.interrupted()) {
            System.out.println(thread.getName() + " is interrupted");
        } else {
            System.out.println(thread.getName() + " is not interrupted");
        }

    }
}
