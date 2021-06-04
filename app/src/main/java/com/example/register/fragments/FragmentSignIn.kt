package com.example.register.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.register.MainActivity
import com.example.register.R


class FragmentSignIn : Fragment() {

    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        val textView = view.findViewById<TextView>(R.id.textToReg)
        textView.setOnClickListener{
            openReg()
        }
        val buttonSignIn = view.findViewById<Button>(R.id.buttonSign)
        buttonSignIn.setOnClickListener{
            signIn()
        }
        emailEditText = view.findViewById(R.id.editTextEmailAuto)
        passwordEditText = view.findViewById(R.id.editTextPasswordAuto)
        return view
    }

    fun signIn(){

        var errorString: String = ""

        if (emailEditText.text.isEmpty()){
            errorString += "Введите Email\n"
        }
        if(passwordEditText.text.isEmpty()){
            errorString += "Введите пароль!"
        }
        if(errorString.isEmpty()){
            activity?.let {
                (it as MainActivity).createUserAndOpenChat(emailEditText.text.toString(),
                    passwordEditText.text.toString()
                , "lala", "lala")
            }
        }else{
            activity?.let {
                (it as MainActivity).openDialogMessage(errorString)
            }
        }
    }

    fun openReg(){

        activity?.let {
            (it as MainActivity).openReg()
        }
    }
}

