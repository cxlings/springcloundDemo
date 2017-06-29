/**
 * Created by wanghui on 16/10/10.
 */
public class Test {


    /**
     * 缓存商品
     */



    public static void main(String[] args) {

         String key = new String("test");
         key.toLowerCase();
         key = "rt";
         key = new String("yhd");
         System.out.print( key );
//         Map<String,String > map = new HashMap<>();
//         List<Integer> integerList = new ArrayList<>( );
//         integerList.add( 4 );
//        Integer test = 9;
//         final  DubboExporter exporter  =   new DubboExporter( key, map  , integerList ,  test );
//         exporter.add( 5 ) ;
//         DubboExporter exporter4 =   exporter.f();
//
//         DubboExporter  t1 = exporter;
//
//
//        DubboExporter tn = new ChildExporter( "child" );
      ChildThree three = new ChildThree();
      three.test();







    }


  public static class Parent{

    public void test(){
      System.out.print("parent");
    }
  }

  public static class ChildOne extends Parent{
    @Override
    public void test(){
      System.out.print("child one ");
    }
  }

  public static class ChildTwo extends ChildOne{
    @Override
    public void test(){
      System.out.print("child two ");
    }
  }

  public static class ChildThree extends ChildTwo{

  }

}

