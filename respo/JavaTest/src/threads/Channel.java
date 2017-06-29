package threads;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by wanghui on 2017/5/11.
 */
public class Channel {

  ArrayList<ChannelHandlers> handlers;


  public Channel( ArrayList<ChannelHandlers> handlerses){
     handlers = handlerses;
  }

  public int workId(){
    Random random  = new Random( System.currentTimeMillis() );
    return  random.nextInt( 3 );
  }


  public ChannelHandlers handlers(){
    Random random  = new Random( System.currentTimeMillis() );
      return  handlers.get( random.nextInt( handlers.size() ) );
  }
}
