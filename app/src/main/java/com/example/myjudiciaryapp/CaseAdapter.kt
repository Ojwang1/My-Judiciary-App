package com.example.myjudiciaryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CaseAdapter(var context: Context, var data:ArrayList<Case>):BaseAdapter() {
    private class ViewHolder(row:View?){
        //This are codes for List View.
        var Name:TextView
        var Email:TextView
        var phone:TextView
        var IdNumber:TextView
        var caseNumber:TextView
        init {
            this.Name = row?.findViewById(R.id.tvName) as TextView
            this.Email = row?.findViewById(R.id.tvEmail) as TextView
            this.phone = row?.findViewById(R.id.tvPhone) as TextView
            this.IdNumber=row?.findViewById(R.id.tvIdNumber) as TextView
            this.caseNumber=row?.findViewById(R.id.tvCaseNumber) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder: ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.case_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item: Case = getItem(position) as Case
        viewHolder.Name.text = item.name
        viewHolder.Email.text = item.email
        viewHolder.phone.text = item.phone
        viewHolder.IdNumber.text=item.idNumber
         viewHolder.caseNumber.text =item.case
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
