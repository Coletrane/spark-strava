package com.coleinman.sparkstrava.general

import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.sql.SparkSession
import util.STRAVA_DATA_PATH

/**
 * Implemenatation using RDD
 */
object ApplicationRDDImpl {
    @JvmStatic
    fun main(args: Array<String>) {
        val spark = SparkSession.builder()
            .master("local")
            .appName(ApplicationRDDImpl::class.qualifiedName)
            .orCreate

        val context = JavaSparkContext(spark.sparkContext())

        val csv = context
            .textFile(STRAVA_DATA_PATH)
            .map { line ->
                line.split(",")
                    .map { element ->
                        element.trim()
                    }
            }
        val header = csv.take(1)

        spark.stop()
    }
}