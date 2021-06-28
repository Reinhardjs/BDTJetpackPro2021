package com.example.jetpackpro.view.home.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackpro.R
import com.example.jetpackpro.model.DataModel
import com.example.jetpackpro.utils.Helper.setImage
import kotlinx.android.synthetic.main.item_row_data.view.*

class Adapter(private val callback: Callback) :
    RecyclerView.Adapter<Adapter.ListViewHolder>() {
    private val listData = ArrayList<DataModel>()

    fun setData(data: List<DataModel>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: DataModel) {
            with(itemView) {
                setImage(context, data.poster, img_data)
                tv_data_title.text = data.name
                tv_data_desc.text = data.desc

                container.setOnClickListener {
                    callback.onItemClicked(data)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_data, parent, false)
        )

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: Adapter.ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }

}