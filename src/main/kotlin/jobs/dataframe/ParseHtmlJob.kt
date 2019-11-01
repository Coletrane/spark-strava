package jobs.dataframe

import org.apache.spark.sql.SparkSession
import scala.collection.JavaConverters
import scala.collection.immutable.Seq
import util.RIDES_PATH
import java.io.File

object ParseHtmlJob {

    // number of rides on coil shock vs air shock
    // used for determining when the switch happens in the rides files
    const val numberOfRidesOnEachSuspension = 15

    @JvmStatic
    fun main(args: Array<String>) {
        val spark = SparkSession.builder()
            .master("local")
            .appName(ParseHtmlJob::class.qualifiedName)
            .orCreate

        val ridesFiles =
            File(RIDES_PATH)
                .walkBottomUp()
                .filter { it.extension == "html" }
                .toList()

        val ridesDf = spark
            .read()
            .text(
                JavaConverters.asScalaIteratorConverter(
                    ridesFiles.iterator()
                ).asScala().toSeq()
            )

        spark.stop()
    }
}