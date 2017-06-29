package threads;

/**
 * Created by wanghui on 2017/5/11.
 */
public class BossThread implements Runnable {


  Channel channel;

  public BossThread( Channel channel){
     this.channel = channel;
  }

  /**
   *
   */
  @Override
  public void run() {
     int i = 0 ;
     for ( ; ; ){
       int workerId = channel.workId();
       System.out.println("boss listen Channel "+ workerId );
       channel.handlers().handler( workerId );
       if( ++i > 50 ){
          break;
       }
     }
  }

}
