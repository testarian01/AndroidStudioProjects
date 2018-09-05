package tk.httpscarabineer.weathercat

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
//import android.util.Log
import android.widget.TextView
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyAsyncTask().execute()
    }

    inner class MyAsyncTask: AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg p0: Void?): String? {
            return getHtml()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val tview = findViewById<TextView>(R.id.mytext)
            tview.setText(result)

        }
    }
}

//外部からデータを取得するメソッド
fun getHtml(): String {
    val client = OkHttpClient()
    val req = Request.Builder().url("http://google.com").get().build()
    val resp = client.newCall(req).execute()
    return resp.body()!!.string()
}
