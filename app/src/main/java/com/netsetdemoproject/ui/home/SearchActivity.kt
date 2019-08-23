package com.netsetdemoproject.ui.home

import android.os.Bundle

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.netsetdemoproject.R
import com.netsetdemoproject.api.pojo.Model

import com.netsetdemoproject.ui.base.BaseActivity
import com.netsetdemoproject.utils.CommonInterface
import java.util.ArrayList


class SearchActivity : BaseActivity(), CommonInterface.SearchView  {

    lateinit var recyclerView: RecyclerView

    val adapter = Adapter()

    internal var items: MutableList<Model> = ArrayList()


    internal var valueList: MutableList<String> = ArrayList()

    private var searchEdit: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search)

        searchEdit = findViewById(R.id.searchET)

        recyclerView = findViewById(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = adapter

        ListItemValue()

        fillItems()

        adapter.loadItems(items)

        searchValue()


    }
    /**
     * List View Item List
     * */
    private fun ListItemValue(): MutableList<String> {
        valueList.add("Android")
        valueList.add("Bluetooth")
        valueList.add("Computer")
        valueList.add("Debugger")
        valueList.add("Error")
        valueList.add("Froyo")
        valueList.add("GingerBread")
        valueList.add("HoneyComb")
        valueList.add("IceCream")
        valueList.add("JellyBean")
        valueList.add("Kitkat")
        valueList.add("Lollipop")
        valueList.add("Marshmallow")
        valueList.add("Nougat")
        valueList.add("Oreo")
        valueList.add("Pie")

        return valueList

    }

    /**
     * List filter.
     * */
    fun filter(text: String?) {
        val temp = ArrayList<Model>()
        for (d in items) {
            if (d.nAme != null)
                if (d.nAme!!.contains(text!!,true) ) {
                    temp.add(d)
                }
        }
        adapter?.updateList(temp)
    }

    private fun fillItems() {
        for (x in valueList.indices) {
            val model = Model()
            model.nAme = valueList[x]
            items.add(model)
        }
    }
    /**
     * Handling Searching
     * */

    private fun searchValue() {
        searchEdit!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                filter(s.toString())
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

    }

    override fun ResponseSucess(message: Void?) {

    }


}

