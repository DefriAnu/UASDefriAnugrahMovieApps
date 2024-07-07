package com.uas.defrianugrah.movieapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LinkAdapter(
    private val items: List<LinkModel>,
    private val listener: AdapterListener
) : RecyclerView.Adapter<LinkAdapter.ViewHolder>() {

    interface AdapterListener {
        fun onClick(linktree: LinkModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_link, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val icon: ImageView = itemView.findViewById(R.id.icon)
        private val name: TextView = itemView.findViewById(R.id.name)

        fun bind(linktree: LinkModel, listener: AdapterListener) {
            icon.setImageResource(linktree.iconResId)
            name.text = linktree.name
            itemView.setOnClickListener { listener.onClick(linktree) }
        }
    }
}
