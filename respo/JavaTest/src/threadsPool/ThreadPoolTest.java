package threadsPool;

import threads.LockRunable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanghui on 2017/5/3.
 *  Java 线程池 测试
 */
public class ThreadPoolTest {


    public static void main(String[] args) {

        LockRunable runable = new LockRunable();
        //
        ExecutorService executorService =  Executors.newCachedThreadPool();
        executorService.execute( runable );

        ExecutorService fixedService =  Executors.newFixedThreadPool( 3 );
        fixedService.execute( runable );

        ExecutorService scheduledService = Executors.newScheduledThreadPool( 5 );
        scheduledService.execute( runable );

    }
}
