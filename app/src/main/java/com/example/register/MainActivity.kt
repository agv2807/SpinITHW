package com.example.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.register.fragments.FragmentSignIn
import com.example.register.fragments.DialogMessage
import com.example.register.fragments.FragmentRegister
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    val autoFragment = FragmentSignIn()
    val regFragment = FragmentRegister()

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, autoFragment)
            commit()
        }

    }

    fun createUserAndOpenChat(email: String, password: String, firstName: String, lastName: String){

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){task ->

                if (task.isSuccessful){

                    val intent = Intent(this, ChatScreen::class.java)
                    intent.putExtra("firstName", firstName)
                    intent.putExtra("lastName", lastName)
                    startActivity(intent)

                }else{

                }
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


    fun openDialogMessage(errorString: String){

        val dialogMessage = DialogMessage(errorString)
        val manager = supportFragmentManager
        dialogMessage.show(manager, "error")
    }
}
