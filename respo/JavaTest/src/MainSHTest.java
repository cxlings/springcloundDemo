/**
 * sss
 *
 */
public class MainSHTest{
  public static int run = 0 ;
	public static void main(String[] args) {

    Thread thread = new Thread( new Runnable() {
      @Override
      public void run() {
         System.out.println("running:"+run++ );
      }
    });

    thread.setDaemon( true );
    thread.setName("test");
    thread.start();


	System.out.println("test java sh ");
    if( null != args && args.length > 0 ){
      for ( int i=0; i++ < args.length ; ){
        System.out.println("args= "+ args[ i ] ) ;
      }
    }
  }
}