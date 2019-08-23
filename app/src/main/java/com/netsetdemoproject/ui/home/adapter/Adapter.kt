package com.netsetdemoproject.ui.home
import android.util.SparseBooleanArray

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckedTextView
import androidx.recyclerview.widget.RecyclerView

import com.netsetdemoproject.R
import com.netsetdemoproject.api.pojo.Model
import java.util.ArrayList

class Adapter internal constructor() : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var items: List<Model>? = ArrayList()
    internal var itemStateArray = SparseBooleanArray()
    val selectedCat = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val layoutForItem = R.layout.list_item
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(layoutForItem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return if (items == null) {
            0
        } else items!!.size
    }

    internal fun loadItems(tournaments: List<Model>) {
        this.items = tournaments
        notifyDataSetChanged()
    }

    fun updateList(temp: ArrayList<Model>) {
        items =temp
        notifyDataSetChanged()
    }
    /**
     * ViewHolder Class
     * fetch Id's
     * */

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var mCheckedTextView: CheckedTextView

        init {
            mCheckedTextView = itemView.findViewById<View>(R.id.checked_text_view) as CheckedTextView
            itemView.setOnClickListener(this)
        }

        fun bind(position: Int) {
            mCheckedTextView.isChecked = selectedCat.contains(items!![position].nAme.toString())

            mCheckedTextView.text = items!![position].nAme.toString()
        }

        /**
         * Handling Clicks of the views.
         * */
        override fun onClick(v: View) {
            val adapterPosition = adapterPosition
            selectedCat.add(items!![adapterPosition].nAme.toString())
            if (!itemStateArray.get(adapterPosition, false)) {
                mCheckedTextView.isChecked = true
                itemStateArray.put(adapterPosition, true)
            } else {
                mCheckedTextView.isChecked = false
                itemStateArray.put(adapterPosition, false)
            }
        }

    }
}