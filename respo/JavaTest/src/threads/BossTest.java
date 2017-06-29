package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wanghui on 2017/5/11.
 */
public class BossTest {

  /**
   * 模拟
   * boss 收到 Channel 的信息
   * 通知 handler
   * handler 是 worker 线程组
   */

  public static void main(String[] args){
    RunInstance instance = new RunInstance( );
    for (int i=0;i <= 2; i++ ){
       Thread thread = new Thread( instance,  "test"+ i  );
       thread.start();
    }
  }

  public static class RunInstance implements Runnable{
    ReentrantLock lock = new ReentrantLock( );
    Condition condition = lock.newCondition();
    @Override
    public void run() {
      // 阻塞

      lock.lock();
      try {
        while ( true ){
          System.out.println( "run["+ Thread.currentThread().getName() +"]come");
          condition.await();
        }
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }

}
