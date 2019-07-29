import java.time.LocalDateTime

data class StravaActivity(
        val id: Int,
        val date: LocalDateTime,
        val name: String,
        val distanceMiles: Double,
        val movingTimeSecs: Int,
        val type: String,
        val averageHeartRate: Double?,
        val maxHeartRage: Double?,
        val averageSpeed: Double,
        val maxSpeedMph: Double,
        val totalElevationGain: Double, // TODO: this is not feet or meters, what the hell is it?
        val startLatLng: List<Double>,
        val endLatLng: List<Double>,
        val weatherIcon: Int,
        val weatherSummary: Int,
        val weatherTemperature: Int
)