package threads;

/**
 * Created by wanghui on 2017/4/24.
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    static class NumberWrapper {
        public int value = 1;
    }

    public static void main(String[] args) {
        //初始化可重入锁
        final Lock lock = new ReentrantLock();

        //第一个条件当屏幕上输出到3
        final Condition reachThreeCondition = lock.newCondition();
        //第二个条件当屏幕上输出到6
        final Condition reachSixCondition = lock.newCondition();

        //NumberWrapper只是为了封装一个数字，一边可以将数字对象共享，并可以设置为final
        //注意这里不要用Integer, Integer 是不可变对象
        final NumberWrapper num = new NumberWrapper();
        //初始化A线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //需要先获得锁
                lock.lock();
                try {
                    System.out.println("threadA start write == "+ num.value );
                    //A线程先输出前3个数
                    while (num.value <= 3) {
                        System.out.println(Thread.currentThread().getName()+"----"+ num.value);
                        num.value++;
                    }
                    //输出到3时要signal，告诉B线程可以开始了
                    reachThreeCondition.signal();
                    System.out.println("threadA notify b " );
                } finally {
                    lock.unlock();
                }

                System.out.println("threadA try get Lock:"+System.currentTimeMillis() );
                lock.lock();
                try {
                    System.out.print("A get lock before wait :"+ System.currentTimeMillis());
                    //等待输出6的条件
                    reachSixCondition.await();
                    System.out.println("threadA start :"+System.currentTimeMillis() );
                    //输出剩余数字
                    while (num.value <= 9) {
                        System.out.println(Thread.currentThread().getName()+"----"+num.value);
                        num.value++;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });


        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();

                    while (num.value <= 3) {
                        //等待3输出完毕的信号
                        System.out.print("b wait == "+num.value );
                        reachThreeCondition.await();
                        System.out.print("b wait over == "+num.value );
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                try {
                    System.out.println("B try get Lock:"+System.currentTimeMillis() );
                    lock.lock();
                    System.out.println("B get Lock:"+System.currentTimeMillis() );
                    //已经收到信号，开始输出4，5，6
                    System.out.println("threadB start write");
                    while (num.value <= 6) {
                        System.out.println(Thread.currentThread().getName()+"----"+num.value);
                        num.value++;
                    }
                    //4，5，6输出完毕，告诉A线程6输出完了
                    Thread.currentThread().sleep( 5000 );
                    reachSixCondition.signal();
                    System.out.println("B notify  A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });


        //启动两个线程
        threadB.start();

        threadA.start();
        // a 先获得 lock
        /**
         *  1\ number ++ 3
         *  2\   reachThreeCondition.signal(); 通知其他 线程
         *  3\   条件when等待通知
         */

    }
}

