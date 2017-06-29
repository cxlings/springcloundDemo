package com.xiangxin.spark;

import com.alibaba.fastjson.JSONPObject;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wanghui on 17/2/21.
 */
public class JsonTest {

    private static  final  String JSON_FILE_PATH = "/Users/wanghui/java/spark_test/src/main/resources/assign.json";

      public class  Assign{
          private   int id;
          private   int order_freight_boxid;
          private   int order_freight_id;
          private   int com_address_id;
          private   Date  product_time;
          private   String product_address;
          private   int    driver_id;


          public int getId() {
              return id;
          }

          public void setId(int id) {
              this.id = id;
          }

          public int getOrder_freight_boxid() {
              return order_freight_boxid;
          }

          public void setOrder_freight_boxid(int order_freight_boxid) {
              this.order_freight_boxid = order_freight_boxid;
          }

          public int getOrder_freight_id() {
              return order_freight_id;
          }

          public void setOrder_freight_id(int order_freight_id) {
              this.order_freight_id = order_freight_id;
          }

          public int getCom_address_id() {
              return com_address_id;
          }

          public void setCom_address_id(int com_address_id) {
              this.com_address_id = com_address_id;
          }

          public Date getProduct_time() {
              return product_time;
          }

          public void setProduct_time(Date product_time) {
              this.product_time = product_time;
          }

          public String getProduct_address() {
              return product_address;
          }

          public void setProduct_address(String product_address) {
              this.product_address = product_address;
          }

          public int getDriver_id() {
              return driver_id;
          }

          public void setDriver_id(int driver_id) {
              this.driver_id = driver_id;
          }
      }


      public static  void  main(String[ ] args ){
          SparkConf conf = new SparkConf().setAppName("read json");
          JavaSparkContext sparkContext = new JavaSparkContext(conf);
          SQLContext sqlContext = new SQLContext( sparkContext );
          Dataset<Row>  data  = sqlContext.read().schema( new StructType( ) ).json( JSON_FILE_PATH );
          data.registerTempTable("assign");
          Dataset<Row> rowData = data.sqlContext().sql(" select driver_id, count(*) as counts  from assign group by driver_id ");
          List<Row> rowList  = rowData.collectAsList();

          List<JSONPObject> obiList = new ArrayList<>( rowList.size());
          for ( Row row : rowList ) {
              JSONPObject obj = new JSONPObject();
              obj.addParameter( row.getInt( 0 ) );
              obj.addParameter( row.getInt( 1 ) );
              obiList.add( obj );
          }




      }
}
