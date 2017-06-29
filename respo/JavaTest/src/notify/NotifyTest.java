package notify;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wanghui on 2017/5/15.
 */
public class NotifyTest {

  /**
   *
   */
  public static class NotifyThread extends Thread{
    public NotifyThread( String name , Runnable runnable ){
       super( runnable, name );
    }

  }

  public static class NotifyAllThread extends Thread{
    public NotifyAllThread( String name , Runnable runnable ){
      super( runnable,name);
    }
  }

  public static class WaitThread extends Thread{
    public WaitThread( String name , Runnable runnable ){
      super( runnable,name);
    }
  }


  public static class RunableSyncTest implements Runnable{

    AtomicInteger integer = new AtomicInteger(0);

    @Override
    public void run() {
      synchronized ( this ){
        try {
          System.out.println("before :["+ Thread.currentThread().getName()+"]  count:"+ integer.addAndGet( 1 ) );
          if( integer.get() % 2 > 0 ){
             try {
               super.wait();
             }finally {
               System.out.println("finally ["+ Thread.currentThread().getName()+"]" );
             }
             Thread.currentThread().sleep( 400 );
             System.out.println("waiting ["+ Thread.currentThread().getName()+"]" );
          }else{
             System.out.println("go to notify ["+ Thread.currentThread().getName()+"]" );
          }
          super.notifyAll();
          System.out.println("after:  [ "+Thread.currentThread().getName()+"]" );
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    Runnable runnable = new RunableSyncTest();
    NotifyAllThread allThread = new NotifyAllThread("all", runnable);
    NotifyThread notifyThread = new NotifyThread("notify", runnable);
    WaitThread waitThread = new WaitThread("wait", runnable);
    allThread.start();
    notifyThread.start();
    waitThread.start();
  }


}
