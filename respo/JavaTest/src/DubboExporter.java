import java.util.List;
import java.util.Map;

/**
 * Created by wanghui on 16/12/20.
 */
public class DubboExporter implements Runnable {
    private  String    key;

    private  Map<String, String > exporterMap;
    private  List collections;
    private  Integer integer;

    public DubboExporter(String key, Map<String, String > exporterMap, List collections , Integer integer ){
        this.key = key;
        this.exporterMap = exporterMap;
        this.collections = collections;
        this.integer = integer;
    }


    public DubboExporter( String key ){
        this.key = key;
    }

    public DubboExporter( DubboExporter exporter ){
        this.key = exporter.key;
        this.exporterMap = exporter.exporterMap;
        this.collections = exporter.collections;
        this.integer = exporter.integer;
    }

    public DubboExporter f(){
        return  DubboExporter.this;
    }


    public void  add( long integer ){
        this.collections.add( integer );
    }


    @Override
    public void run() {
        this.add( Thread.currentThread().getId() );
    }
}
