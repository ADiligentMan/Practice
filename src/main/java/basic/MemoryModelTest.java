package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpeng
 * @since 2020-12-24
 */
public class MemoryModelTest {
    public volatile int var = 0;
    private static Object lock = new Object();

    public void start() {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    var++;
                }
            }));
        }

        try {
            for (Thread t : list) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("var : " + var);
    }

    public static void main(String[] args) {
        new MemoryModelTest().start();
    }
}

