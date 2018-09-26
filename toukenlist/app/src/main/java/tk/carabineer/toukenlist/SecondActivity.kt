package tk.carabineer.toukenlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val text = intent.getStringExtra("TEXT_KEY")

        val messageView: TextView = findViewById(R.id.message_view)
        messageView.text = text

    }
}
