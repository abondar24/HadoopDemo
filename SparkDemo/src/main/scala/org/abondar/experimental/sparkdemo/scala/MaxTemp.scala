package org.abondar.experimental.sparkdemo.scala

import org.apache.spark.{SparkConf, SparkContext}


object MaxTemp {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Max Temperature")
    val sc = new SparkContext(conf)

    sc.textFile(args(0))
      .map(_.split("\t"))
      .filter(rec => rec(1) != "9999" && rec(2).matches("[01459]"))
      .map(rec => (rec(0).toInt, rec(1).toInt))
      .reduceByKey((a, b) => Math.max(a, b))
      .saveAsTextFile(args(1))
  }
}
