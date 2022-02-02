package com.example.demo.model

data class UserPost(

        val firstName:String,
        val lastName: String,
        val email:String,
        val profilepic: String,
        val password:String
        )
data class SignInBody(val email: String, val password: String)