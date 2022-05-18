package com.example.myjudiciaryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class JudgesAdapter(var context: Context, var data:ArrayList<Judge>):BaseAdapter() {
    private class ViewHolder(row:View?){
        //This are codes for List View.
        var editName:TextView
        var editId:TextView
        var editPhone:TextView
        var editEmail:TextView
        var editPassword:TextView
        init {
            // On this part of the section has been change from editName to txtName accordind to new naming from judge_layout.
            this.editName = row?.findViewById(R.id.txtName) as TextView
            this.editId = row?.findViewById(R.id.txtId) as TextView
            this.editPhone = row?.findViewById(R.id.txtPhone) as TextView
            this.editEmail=row?.findViewById(R.id.txtEmail) as TextView
            this.editPassword=row?.findViewById(R.id.txtPassword) as TextView

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder: ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.judge_layout,parent,false) //Remember to change item_layout to judge_layout.
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item: Judge = getItem(position) as Judge
        viewHolder.editName.text = item.name // All of this section should look the same with the constructor.
        viewHolder.editId.text = item.id
        viewHolder.editPhone.text = item.phone
        viewHolder.editEmail.text=item.email
        viewHolder.editPassword.text=item.password


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

