package suspension.dataframe

import org.apache.spark.sql.SparkSession
import scala.collection.JavaConverters
import util.AIR_RIDES_PATH
import util.COIL_RIDES_PATH
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

        fun getRidesFiles(filepath: String) = File(filepath)
            .walkBottomUp()
            .filter { it.extension == "html" }
            .map { it.readText() }
            .toMutableList()
        val ridesFiles = getRidesFiles(COIL_RIDES_PATH)
        ridesFiles.addAll(getRidesFiles(AIR_RIDES_PATH))


        val ridesDs = spark
            .read()
            .text(
                JavaConverters.asScalaIteratorConverter(
                    ridesFiles.iterator()
                ).asScala().toSeq()
            )

        spark.stop()
    }
}