package com.example.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        if(intent.extras != null){
            var user = intent.getSerializableExtra("user") as User
            var email = user.email
            var password = user.password
            userTextView.text = "$email\n $password"
            messageTextView.text = intent.getStringExtra("information")
        }
    }
}