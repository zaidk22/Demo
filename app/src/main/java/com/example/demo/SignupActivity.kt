package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.demo.model.UserPost
import kotlinx.android.synthetic.main.activity_signup.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        button_register.setOnClickListener {
            validation()
            signUp()
        }

    }
    private fun signUp(){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val registerInfo = UserPost(" ","","","","")

        retIn.registerUser(registerInfo).enqueue(object :
            Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    this@SignupActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 201) {
                    Toast.makeText(this@SignupActivity, "Registration success!", Toast.LENGTH_SHORT)
                        .show()

                }
                else{
                    Toast.makeText(this@SignupActivity, "Registration failed!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    private fun validation(){

        val email = et_email.text.toString().trim()
        val password = et_password.text.toString().trim()
        val firstName = et_fname.text.toString().trim()
        val lastName = et_lname.text.toString().trim()
        val userName = et_uname.text.toString().trim()


        if (email.isEmpty()) {
            et_email.error = "Email required"
            et_email.requestFocus()

        }


        if (password.isEmpty()) {
            et_password.error = "Password required"
            et_password.requestFocus()

        }

        if (firstName.isEmpty()) {
            et_fname.error = "Name required"
            et_fname.requestFocus()

        }
        if (lastName.isEmpty()) {
            et_lname.error = "Name required"
            et_lname.requestFocus()

        }

        if (userName.isEmpty()) {
            et_uname.error = "User name required"
            et_uname.requestFocus()

        }
    }
    }

