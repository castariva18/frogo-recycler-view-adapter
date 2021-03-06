package com.frogobox.frogorecyclerviewadapter.kotlinsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.frogorecyclerviewadapter.R
import com.frogobox.frogorecyclerviewadapter.mdoel.ExampleModel
import com.frogobox.frogoviewadapter.FrogoRecyclerViewListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FrogoRecyclerViewListener<ExampleModel> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun listData(): MutableList<ExampleModel> {
        val listString = mutableListOf<ExampleModel>()
        listString.add(ExampleModel("Amir Is Back"))
        listString.add(ExampleModel("Amir Is Back"))
        listString.add(ExampleModel("Amir Is Back"))
        listString.add(ExampleModel("Amir Is Back"))
        return listString
    }

    private fun setupAdapter() {
        val adapter =
            MainViewAdapter()
        adapter.setupRequirement(
            this, listData(),
            R.layout.example_list_item
        )
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClicked(data: ExampleModel) {
        Toast.makeText(this, data.name, Toast.LENGTH_SHORT).show()
    }

    override fun onItemLongClicked(data: ExampleModel) {
        Toast.makeText(this, data.name, Toast.LENGTH_LONG).show()
    }

}