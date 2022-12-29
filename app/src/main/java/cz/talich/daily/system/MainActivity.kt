package cz.talich.daily.system

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import cz.talich.daily.feature.main.system.MainScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MainScreen(
                closeApp = ::closeApp
            )
        }
    }

    private fun closeApp() {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val appTasks = activityManager.appTasks

        for (appTask in appTasks) {
            if (appTask.taskInfo.baseIntent.component!!.packageName == packageName) {
                appTask.finishAndRemoveTask()
                break
            }
        }
    }
}
