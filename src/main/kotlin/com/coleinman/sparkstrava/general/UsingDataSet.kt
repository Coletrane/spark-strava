package suspension

import suspension.dataframe.ParseHtmlJob
import org.apache.spark.sql.SparkSession
import util.STRAVA_DATA_PATH

/**
 * Implemenatation using DataSet
 */
object UsingDataSet {
    @JvmStatic
    fun main(args: Array<String>) {
        val spark = SparkSession.builder()
            .master("local")
            .appName(ParseHtmlJob::class.qualifiedName)
            .orCreate

        val stravaDf = spark.read()
            .option("header", "true")
            .option("inferSchema", "true")
            .csv(STRAVA_DATA_PATH)
        stravaDf.printSchema()

        spark.stop()
    }
}