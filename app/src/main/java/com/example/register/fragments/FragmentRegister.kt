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

class FragmentRegister : Fragment() {

    lateinit var emailEditText: EditText
    lateinit var firstName: EditText
    lateinit var lastName: EditText
    lateinit var passwordEditText: EditText
    lateinit var confirmPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val textView = view.findViewById<TextView>(R.id.textView3)
        textView.setOnClickListener{
            openAuto()
        }

        val buttonSignUp = view.findViewById<Button>(R.id.buttonSignUp)
        buttonSignUp.setOnClickListener{
            signUp()
        }

        emailEditText = view.findViewById(R.id.editTextmail)
        firstName = view.findViewById(R.id.editTextName)
        lastName = view.findViewById(R.id.editTextSurname)
        passwordEditText = view.findViewById(R.id.editTextPassword)
        confirmPassword = view.findViewById(R.id.editTextConfirm)

        return view
    }

    fun signUp(){

        var errorString: String = ""

        if (emailEditText.text.isEmpty()){
            errorString += "Укажите Email!\n"
        }
        if (firstName.text.isEmpty()){
            errorString += "Укажите Имя!\n"
        }
        if (lastName.text.isEmpty()){
            errorString += "Укажите Фамилию!\n"
        }
        if (passwordEditText.text.isEmpty()){
            errorString += "Задайте пароль!\n"
        }
        if (confirmPassword.text.isEmpty()){
            errorString += "Подтвердите введённый пароль!\n"
        }
        if (passwordEditText.text.count() < 8){
            errorString += "Пароль должен содержать не менее 8 символов!\n"
        }
        if (passwordEditText.text.toString() != confirmPassword.text.toString()){
            errorString += "Пароли не совпадают!"
        }
        if(errorString.isEmpty()){
            activity?.let {
                (it as MainActivity).createUserAndOpenChat(
                    emailEditText.text.toString(),
                    passwordEditText.text.toString(),
                    firstName.text.toString(),
                    lastName.text.toString()
                )
            }
        }else{
            activity?.let {
                (it as MainActivity).openDialogMessage(errorString)
            }
        }
    }

    fun openAuto(){

        activity?.let {
            (it as MainActivity).openAuto()
        }
    }


}