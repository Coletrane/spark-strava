import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.sql.SparkSession

/**
 * Implemenatation using RDD instead of DataFrame
 */
object StravaImplUsingRDD {
    @JvmStatic
    fun main(args: Array<String>) {
        val spark = SparkSession.builder()
            .master("local")
            .appName(StravaImplUsingRDD::class.qualifiedName)
            .orCreate

        val context = JavaSparkContext(spark.sparkContext())

        val csv = context
            .textFile(Constants.stravaCsvPath)
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