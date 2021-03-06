package com.iroha168.gamancounter

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.iroha168.gamancounter.view.ToolBarCustomView
import com.iroha168.gamancounter.view.ToolBarCustomViewDelegate
import kotlinx.android.synthetic.main.activity_send_opinion_to_us.*

class SendOpinionToUsActivity : AppCompatActivity(), ToolBarCustomViewDelegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_opinion_to_us)
        layout()
    }

    override fun onClickedLeftButton() {
        finish()
    }

    //layoutの設定
    private fun layout() {
        //ToolBarCustomViewの設定
        val customToolBarView = ToolBarCustomView(this)
        customToolBarView.delegate = this
        customToolBarView.configure("運営にメッセージ", false, true)
        val layout: LinearLayout = findViewById(R.id.container_for_tool_bar)
        customToolBarView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layout.addView(customToolBarView)

        //WebViewの設定
        val url: String = "https://docs.google.com/forms/d/e/1FAIpQLSe3plWZsaf8nc_j1YUqUt9Zx_1znPA7-6XG-FNMR2xyzewLcg/viewform?usp=sf_link"
        web_view.loadUrl(url)
    }
}