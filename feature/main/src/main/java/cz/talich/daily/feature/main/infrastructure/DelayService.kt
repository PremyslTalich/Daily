package cz.talich.daily.feature.main.infrastructure

import kotlin.time.Duration

object DelayService {
    suspend fun delay(duration: Duration) {
        kotlinx.coroutines.delay(duration)
    }
}
