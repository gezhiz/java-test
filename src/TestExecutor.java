import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gezz on 2018/6/22.
 */
public class TestExecutor {
    @Test
    public void testExecutor() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 2");
            }
        });
        Thread.sleep(1000000);
    }
}
