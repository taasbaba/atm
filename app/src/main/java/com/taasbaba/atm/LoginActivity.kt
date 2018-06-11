package com.taasbaba.atm

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast


class LoginActivity : AppCompatActivity() {
    var edUserId:EditText? = null
    var edPd:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edUserId = findViewById(R.id.AccountEditText)
        edPd = findViewById(R.id.PdEditText)
        var setting = getSharedPreferences("ATM", Context.MODE_PRIVATE)
        edUserId?.setText(setting.getString("PREF_USERID", ""))
    }

    fun login(view:View) {
        var uid:String = edUserId?.text.toString()
        var pd:String = edPd?.text.toString()
        Log.d("Login.userid", uid)
        Log.d("Login.pd", pd)
        if (uid.equals("jack") && pd.equals("1234")) {
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show()
            var setting = getSharedPreferences("ATM", Context.MODE_PRIVATE)
            setting.edit().putString("PREF_USERID", uid).apply()
            finish()
        } else {
            AlertDialog.Builder(this).setTitle("ATM")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK", null)
                    .show()
        }
    }

    fun cancel(view:View) {

    }
}
