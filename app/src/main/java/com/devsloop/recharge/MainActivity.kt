package com.devsloop.recharge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private var progressBar: ProgressBar? = null
    private var i = 0
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        webViewProcess()
//        i = progressBar!!.progress
//        Thread(Runnable {
//
//            while (i < 100){
//                i += 5
//                handler.post(Runnable {
//                    progressBar!!.progress = i
////                    webViewProcess()
//                })
//                try {
//                    Thread.sleep(100)
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//            }
//        }).start()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.new_game -> {
                webViewProcess()
                showMessage("Home page Loading...")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun webViewProcess(){
        webView = findViewById(R.id.webView)
        val settings = webView.settings
        settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl("https://gp.portwallet.com/")
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
