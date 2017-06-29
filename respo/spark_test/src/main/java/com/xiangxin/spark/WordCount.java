/**
 * Created by wanghui on 17/2/21.
 */

package com.xiangxin.spark;

import org.apache.commons.collections.iterators.ArrayIterator;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Iterator;

public class WordCount {

    private  static String filePath =  "/Users/wanghui/java/spark_test/src/main/resources/test.json";
    private  static String outputPath = "/Users/wanghui/java/spark_test/src/main/resources/test_out_put";

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("word count");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);
        JavaRDD<String> input = sparkContext.textFile(filePath);
        JavaRDD<String> words = input.flatMap( new FlatMapFunction<String, String >( ) {
            @Override
            public Iterator<String> call(String s) throws Exception {
                String[ ] list = s.split(" ");
                return  new ArrayIterator( list );
            }
        });


        JavaPairRDD< String,Integer > counts = words.mapToPair(new PairFunction<String, String , Integer >() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                 return  new Tuple2<String, Integer>( s, 1 );
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return  integer + integer2;
            }
        });
        counts.saveAsTextFile( outputPath );
    }
}
