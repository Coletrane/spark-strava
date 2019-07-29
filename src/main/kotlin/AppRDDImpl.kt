import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext

/**
 * Implemenatation using RDD instead of DataFrame
 */
object AppRDDImpl {
    @JvmStatic fun main(args: Array<String>) {
        val config = SparkConf()
                .setAppName("com.coleinman.spark-strava.AppRDDImpl")
                .setMaster("local")
        val context = JavaSparkContext(config)

        val stravaCsv = context.textFile("resources/private/cole_inman_strava_data.csv")
    }
}