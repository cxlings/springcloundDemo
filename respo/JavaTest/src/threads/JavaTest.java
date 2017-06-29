package threads;

import java.util.ArrayList;

/**
 * Created by wanghui on 2017/5/11.
 */
public class JavaTest {

  /**
   * 在 主线程里 boss
   * @param args
   */
  public static void main(String[] args) {
     System.out.println("java test");



     // boss 线程 注册 Channel
     // Channel 的 pipeline ( ChannelHandlerContext ) => ChannelHandlers 数组
     //
    ChannelHandlers handlers1 = new ChannelHandlers("worker1");
    ChannelHandlers handlers2 = new ChannelHandlers("worker2");
    ChannelHandlers handlers3 = new ChannelHandlers("worker2");

    ArrayList<ChannelHandlers> handlerses = new ArrayList<>(  );
    handlerses.add( handlers1 );
    handlerses.add( handlers2 );
    handlerses.add( handlers3 );

     Channel  channel = new Channel( handlerses );
     Runnable bossRun = new BossThread( channel );

     Thread bossThread = new Thread( bossRun );
     bossThread.start();

    System.out.println("test java sh ");
    if( null != args && args.length > 0 ){
      System.out.println("args"+ args[ 0 ] ) ;
    }

  }
}
