package threads;

/**
 * Created by wanghui on 2017/4/24.
 */
public class SyncTest {

    public SyncTest syncVar;
    public  Object syncStaticVar = new Object();
    private  int count = 0;



    public static synchronized void testStatic() {
        System.out.println("test static start" + Thread.currentThread().getName() );
        try {
            Thread. sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test static end" + Thread.currentThread().getName() );
    }

    public synchronized void testNonStaticSync() {

    }

    public void testSyncThis() {
        synchronized ( this ) {
            try {
                System. out.println("test sync this start" + Thread.currentThread().getName() );
                Thread. sleep(5000);

                System. out.println("test sync this end" +  Thread.currentThread().getName() );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testSyncVar() {
        synchronized ( syncStaticVar ) {
            try {
                System. out.println("test sync var start" + Thread.currentThread().getName() );
                syncStaticVar = new Object();
                Thread. sleep(3000);
                System. out.println("test sync var end" + Thread.currentThread().getName() );
            } catch (InterruptedException e) {

            }
        }
    }

    public void testVar() {
        synchronized ( syncStaticVar ) {
            try {
                System.out.println(count + ": =>start" + Thread.currentThread().getName());
                count++;
                Thread. sleep(3000);
//                System. out.println("test sync var end" + Thread.currentThread().getName() );
            } catch (Exception e) {

            }
        }

    }

    public void testStaticSyncVar() {
        synchronized (syncStaticVar ) {

        }
    }

    public static void main(String[] args) {
         SyncTest testSync = new SyncTest();
//        testSync. syncVar = new SyncTest();
//        testSync. syncVar = testSync;

        final SyncTest finalTestSync = testSync;
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {

//                finalTestSync.testVar();
//                finalTestSync.testSyncVar();
//                finalTestSync.testVar();
            }
        });


        final SyncTest test2 = new SyncTest();
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                finalTestSync.testVar();
//                test2.testSyncVar();
//                finalTestSync.testVar();
            }
        });



        threadOne.start();
//        try {
//            Thread.sleep( 1 );
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        threadTwo.start();
    }
}
