package com.example.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.register.fragments.FragmentSignIn
import com.example.register.fragments.DialogMessage
import com.example.register.fragments.FragmentRegister

class MainActivity : AppCompatActivity() {

    val autoFragment = FragmentSignIn()
    val regFragment = FragmentRegister()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, autoFragment)
            commit()
        }

    }

    fun openAuto(){

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, autoFragment)
            commit()
        }
    }

    fun openReg(){

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, regFragment)
            commit()
        }
    }

    fun openMenuActivity(email: String, password: String, information: String){
        val intent = Intent(this, ChatScreen::class.java)
        val user = User(email, password)
        intent.putExtra("user", user)
        intent.putExtra("information", information)
        startActivity(intent)
    }

    fun openDialogMessage(errorString: String){

        val dialogMessage = DialogMessage(errorString)
        val manager = supportFragmentManager
        dialogMessage.show(manager, "error")
    }
}
