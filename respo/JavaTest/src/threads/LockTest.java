package threads;

/**
 * Created by wanghui on 2017/4/24.
 */
public class LockTest {


    static class  NumberWrraper{
        private  int value = 0;
    }

    static  Object object = new Object();


    public static void main(String[] args) {
//
//        object = new Object();
//        String s = new String("my");
//        String s1 =  s.intern();
//        System.out.println( s == s1 );
        Runnable runnable1 = new LockRunable();
        Runnable runnable =  new LockRunable();
////        NumberWrraper wrraper = new NumberWrraper();
//        // 接受同一个 回调函数
        Thread threadOne = new Thread(  runnable );
        Thread threadTwo = new Thread(  runnable1 );
        threadOne.start();
        threadTwo.start();
//        AtomicInteger integer = new AtomicInteger( 1 );
//
//
//        // t1
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    do {
//                        integer.addAndGet( 1 );
//                    }while ( integer.get()>=3 );
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System. out.println( integer.get()  + " :---start name{}" + Thread.currentThread().getName() );
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                integer.addAndGet( 1 );
//                System. out.println(  integer.get() + " :---start name{}" + Thread.currentThread().getName() );
//            }
//        });
//
//        t1.start();
//        t2.start();
    }
}
