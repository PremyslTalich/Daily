package cz.talich.daily.infrastructure

import io.kotest.matchers.longs.shouldBeGreaterThanOrEqual
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.time.Duration.Companion.milliseconds

class DelayServiceTest {

    @Test
    fun `delay should suspend the coroutine for the specified duration`() {
        val duration = 10.milliseconds
        var elapsedTime = 0L

        runBlocking {
            val startTime = System.currentTimeMillis()
            DelayService.delay(duration)
            elapsedTime = System.currentTimeMillis() - startTime
        }

        elapsedTime shouldBeGreaterThanOrEqual duration.inWholeMilliseconds
    }
}