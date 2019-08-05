import org.apache.spark.sql.SparkSession

/**
 * Implemenatation using DataFrame instead of RDD
 */
object StravaImplUsingDataFrame {
    @JvmStatic
    fun main(args: Array<String>) {
        val spark = SparkSession.builder()
                .master("local")
                .appName(StravaImplUsingDataFrame::class.qualifiedName)
                .orCreate

        val stravaDf = spark.read()
                .option("header", "true")
                .option("inferSchema", "true")
                .csv(Constants.stravaCsvPath)
        stravaDf.printSchema()

        spark.stop()
    }
}