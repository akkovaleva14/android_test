package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView


class TagAdapter(private val tags: List<String>) :
    RecyclerView.Adapter<TagAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tag: AppCompatTextView = view.findViewById(R.id.tag)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_tag, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val tagModel: String = tags.get(position)
        val tag = viewHolder.tag
        tag.text = tagModel


    }

    override fun getItemCount() = tags.size
}
