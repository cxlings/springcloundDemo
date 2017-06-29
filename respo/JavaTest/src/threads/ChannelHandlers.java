package threads;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wanghui on 2017/5/11.
 * wh test xiugai 1
 * wh test checkout cmmintID
 */
public class ChannelHandlers implements Runnable {

  private  Thread thread;
  private  Queue<Integer> queue;


  public ChannelHandlers(String name) {
      thread = new Thread( this, name) ;
      queue  = new LinkedBlockingDeque<>();
      thread.setDaemon( true );
      thread.start();
  }

  public void handler( int workerId ){
     queue.add( new Integer( workerId ) );
  }

  @Override
  public void run() {
    for ( ;; ){
      if( !queue.isEmpty() ){
        Integer work = queue.poll();
        String s = Thread.currentThread() == this.thread ? "是":"否";
        System.out.println("worker =:"+Thread.currentThread().getName()+" is working, job is "+ work.toString()+";是在当前线程?"+ s );
      }
    }
    }

}
