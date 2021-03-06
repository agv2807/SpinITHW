package com.example.bloknot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bloknot.db.MyDbManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        myDbManager.openDb()

    }

    fun onClickNew(view: View){

        val intent = Intent(this, EditActivity::class.java)

        startActivity(intent)

    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}
