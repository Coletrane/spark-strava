package jobs

import util.Constants
import org.apache.spark.sql.SparkSession

/**
 * Implemenatation using DataSet
 */
object UsingDataSet {
    @JvmStatic
    fun main(args: Array<String>) {
        val spark = SparkSession.builder()
            .master("local")
            .appName(UsingDataFrame::class.qualifiedName)
            .orCreate

        val stravaDf = spark.read()
            .option("header", "true")
            .option("inferSchema", "true")
            .csv(Constants.stravaCsvPath)
        stravaDf.printSchema()

        spark.stop()
    }
}