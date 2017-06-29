package threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wanghui on 2017/4/24.
 */
public class LockRunable implements Runnable {

    Integer count = 0;
    private   final  ReentrantLock lock = new ReentrantLock( );
//    private static  final  Condition condThree  = lock.newCondition();
//    private static  final  Condition condSix = lock.newCondition();

    private final Object lockObj = new Object();

    public  ReentrantLock getLock() {
        return lock;
    }

    @Override
    public  void  run() {
        synchronized ( lockObj ){

//        lock.lock();

          print();


//
       }


    }


    private  void print(){

//        lock.lock();

        try {

//            lock.lock();
            System. out.println(count + " :---start name{}" + Thread.currentThread().getName() );
            System.out.println( "lockObj hash code " + lockObj.hashCode() );
            Thread.currentThread().sleep( 400 ); // 模拟执行一个耗时的任务
//            while ( count <=3 ){
            count ++;
//            }
            System.out.println(  );
//            try {
//                condSix.signalAll();
//            } catch (IllegalMonitorStateException e) {
//                e.printStackTrace();
//            }
            System. out.println(count + " : --- end name{} " + Thread.currentThread().getName() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }
    }
}
