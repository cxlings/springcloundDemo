/**
 * Created by wanghui on 2017/4/23.
 *
 * w
 */
public class ChildExporter extends DubboExporter {

    public ChildExporter(String key) {
        super( key );
        System.out.print("1");
    }
}
