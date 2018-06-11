package com.taasbaba.atm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    var login: Boolean = false
    val func = arrayOf("餘額查詢", "交易明細", "最新消息", "投資理財", "離開" )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var LvList : ListView? = findViewById(R.id.list)
        val LVAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, func)
        LvList?.adapter = LVAdapter

        var spinner : Spinner? = findViewById(R.id.spinner)
        val SPAdapter = ArrayAdapter.createFromResource(this, R.array.notify_array, android.R.layout.simple_spinner_item)
        SPAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter = SPAdapter

        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, SPAdapter.getItem(position), Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}

        }
        if (!login) {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate( R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_setting) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
