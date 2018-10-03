package tk.carabineer.toukenlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val text = intent.getStringExtra("name")
        val text2 = intent.getStringExtra("nameyomi")
        val text3 = intent.getStringExtra("bikou")

        val messageView: TextView = findViewById(R.id.message_view)
        val messageView2: TextView = findViewById(R.id.message_view2)
        val messageView3: TextView = findViewById(R.id.message_view3)

        messageView.text = text
        messageView2.text = text2
        messageView3.text = text3

    }
}
