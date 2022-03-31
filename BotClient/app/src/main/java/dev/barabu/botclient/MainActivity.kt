package dev.barabu.botclient

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dev.barabu.botcommon.IBot
import dev.barabu.botcommon.model.BotRequest

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    private var botProxy: IBot? = null

    private var isBound: Boolean = false

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d(LOG_TAG, "onServiceConnected in thread ${Thread.currentThread().name}")
            botProxy = IBot.Stub.asInterface(service)
            workWithService()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            botProxy = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_info)
        bindService()
    }

    override fun onStop() {
        super.onStop()
        unbindService(serviceConnection)
    }

    private fun bindService() {
        val intent = Intent().apply {
            setClassName(IBot.PACKAGE_NAME, IBot.SERVICE_CLASS_NAME)
        }

        isBound = bindService(intent, serviceConnection, BIND_AUTO_CREATE)
        Log.d(LOG_TAG, "bindService isBound=$isBound")
    }

    /**
     * Два запроса в серсис.
     */
    private fun workWithService() {

        botProxy?.let { bot ->
            val greeting = bot.greeting(BotRequest("Sergey", "Ya")).data
            textView.text = bot.upperCase(BotRequest(greeting, "")).data
        }
    }
}