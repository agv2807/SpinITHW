package com.example.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ChatScreen : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_chat)

        val chatRv = findViewById<RecyclerView>(R.id.chatRv)
        val editText = findViewById<EditText>(R.id.messageEd)
        val sendMes = findViewById<ImageButton>(R.id.sendMesImB)
        val messages = arrayListOf<Message>()
        val adapter = RvAdapter()

        chatRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        sendMes.setOnClickListener {
            if (editText.text.isEmpty()) {
                Toast.makeText(this, "Введите сообщение", Toast.LENGTH_SHORT).show()
            } else {
                chatRv.adapter = adapter
                messages.add(Message(editText.text.toString(), true))
                adapter.setData(messages)
                editText.setText("")
                Handler().postDelayed(
                    {
                        chatRv.adapter = adapter
                        messages.add(Message("Если ты меня не любишь, то я тоже нет", false))
                        adapter.setData(messages)
                    }, 3000)

                Handler().postDelayed(
                    {
                        chatRv.adapter = adapter
                        messages.add(Message("Если ты меня забудешь, то и я в ответ", false))
                        adapter.setData(messages)
                    }, 6000)
            }
        }
    }

}