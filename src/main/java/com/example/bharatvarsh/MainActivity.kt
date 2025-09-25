package com.example.bharatvarsh

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create layout programmatically
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        // Navigation buttons
        val homeButton = Button(this).apply {
            text = "Home"
            setOnClickListener {
                webView.loadUrl("https://www.bharatvarshsamachar.org/")
            }
        }
        val videosButton = Button(this).apply {
            text = "Videos"
            setOnClickListener {
                webView.loadUrl("https://www.bharatvarshsamachar.org/videos/")
            }
        }

        // WebView setup
        webView = WebView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("https://www.bharatvarshsamachar.org/")
        }

        // Add views to layout
        layout.addView(homeButton)
        layout.addView(videosButton)
        layout.addView(webView)

        // Set layout as content view
        setContentView(layout)
    }

    // Handle back button for WebView navigation
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
