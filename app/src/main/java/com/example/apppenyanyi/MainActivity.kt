package com.example.apppenyanyi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity  : AppCompatActivity(),View.OnClickListener {
    private lateinit var rvSingers: RecyclerView
    private val list = ArrayList<Singer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvSingers = findViewById(R.id.rv_singers)
        rvSingers.setHasFixedSize(true)

        list.addAll(getListSingers())
        showRecyclerList()


        val btnMoveAbout: Button = findViewById(R.id.btn_about)
        btnMoveAbout.setOnClickListener(this)
    }
    private fun getListSingers(): ArrayList<Singer> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSinger = ArrayList<Singer>()
        for (i in dataName.indices) {
            val singer = Singer(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listSinger.add(singer)
        }
        return listSinger
    }


    private fun showRecyclerList() {
        rvSingers.layoutManager = LinearLayoutManager(this)
        val listSingerAdapter = ListSingerAdapter(list)
        rvSingers.adapter = listSingerAdapter
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_about -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
    }
}