package com.example.myjudiciaryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ClerksAdapter(var context: Context, var data:ArrayList<Clerk>):BaseAdapter() {
    private class ViewHolder(row:View?){
        //This are codes for List View.
        var editName:TextView
        var editEmail:TextView
        var editId:TextView
        var editPhone:TextView
        var editPassword:TextView
        init {
            // The section with textName has been change from editName to txtName according to the names which are use in clerk_layout.
            this.editName = row?.findViewById(R.id.txtName) as TextView
            this.editEmail = row?.findViewById(R.id.txtEmail) as TextView
            this.editId = row?.findViewById(R.id.txtId) as TextView
            this.editPhone = row?.findViewById(R.id.txtPhone) as TextView
            this.editPassword=row?.findViewById(R.id.txtPassword) as TextView

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder: ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            // The section of clerk is what has been change from item_layout to clerk_layout
            view = layout.inflate(R.layout.clerk_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item: Clerk = getItem(position) as Clerk
        viewHolder.editName.text = item.name // All of this section should look the same with the constructor.
        viewHolder.editEmail.text = item.email
        viewHolder.editId.text = item.id
        viewHolder.editPhone.text = item.phone
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
