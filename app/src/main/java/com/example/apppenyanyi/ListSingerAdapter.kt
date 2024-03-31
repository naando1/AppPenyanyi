package com.example.apppenyanyi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListSingerAdapter(private val listSinger: ArrayList<Singer>) : RecyclerView.Adapter<ListSingerAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_singer, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listSinger.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listSinger[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.btnGoToDetailActivity.setOnClickListener {
            val context = holder.itemView.context
            val intent = when (position) {
                0 -> Intent(context, Afgan::class.java)
                1 -> Intent(context, Ardhito::class.java)
                2 -> Intent(context, Fiersa::class.java)
                3 -> Intent(context, Hindia::class.java)
                4 -> Intent(context, Isyana::class.java)
                5 -> Intent(context, Kunto::class.java)
                6 -> Intent(context, Nadin::class.java)
                7 -> Intent(context, Paul::class.java)
                8 -> Intent(context, RizkyFebian::class.java)
                9 -> Intent(context, DetailActivity::class.java)
                // Add more cases for other positions
                else -> Intent(context, About::class.java) // Default activity or handle accordingly
            }
            context.startActivity(intent)
        }


    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val btnGoToDetailActivity: Button = itemView.findViewById(R.id.btn_move_detail)
    }


}