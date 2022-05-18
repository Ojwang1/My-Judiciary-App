package com.example.myjudiciaryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SearchAdapter(var context: Context, var data:ArrayList<Search>):BaseAdapter() {
    private class ViewHolder(row:View?){
        //This are codes for List View.
        var editSearchCase:TextView
//        var mBtnSearch:Button


        init {
            // On this part of the section has been change from editName to txtName accordind to new naming from judge_layout.
            this.editSearchCase = row?.findViewById(R.id.textView2) as TextView
//            this.mBtnSearch= row?.findViewById(R.id.mBtnSearch) as Button

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder: ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.search_layout,parent,false) //Remember to change item_layout to judge_layout.
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item: Search = getItem(position) as Search
        viewHolder.editSearchCase.text = item.search // All of this section should look the same with the constructor.
//        viewHolder.mBtnSearch.text = item.id



        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}
