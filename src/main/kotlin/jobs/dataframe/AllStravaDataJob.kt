package jobs.dataframe

import org.apache.spark.sql.SparkSession

object AllStravaDataJob {
    @JvmStatic
    fun main(args: Array<String>) {
        val spark = SparkSession.builder()
            .master("local")
            .appName(AllStravaDataJob::class.qualifiedName)
            .orCreate

//        val stravaDf = spark.read()
//                .option("header", "true")
//                .option("inferSchema", "true")
//                .csv(Constants.stravaCsvPath)
//        stravaDf.printSchema()

        spark.stop()
    }
}