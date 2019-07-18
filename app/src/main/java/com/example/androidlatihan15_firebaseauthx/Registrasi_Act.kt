package com.example.androidlatihan15_firebaseauthx

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_act.*
import kotlinx.android.synthetic.main.login_act.btn_regis
import kotlinx.android.synthetic.main.login_act.et_email
import kotlinx.android.synthetic.main.login_act.et_password
import kotlinx.android.synthetic.main.register_act.*

class Registrasi_Act : AppCompatActivity() {

    lateinit var fAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_act)
        fAuth = FirebaseAuth.getInstance()

        btn_regis.setOnClickListener {
            val email = et_email.text.toString()
            val password = et_password.text.toString()
            if (email.isEmpty() || password.isNotEmpty() ||
                !email.equals("") || !password.equals("")){
                fAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this, "REGISTRASI Berhasil",
                                Toast.LENGTH_SHORT).show()
                            onBackPressed()
                        }else{
                            Toast.makeText(this, "REGISTRASI GAGAL",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this, "email atau password tak boleh kosong",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }
}