package com.example.myjudiciaryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CourtAdapter(var context: Context, var data:ArrayList<Court>):BaseAdapter() {
    private class ViewHolder(row:View?){
        //This are codes for List View.
        var editCourtName:TextView
        var editCourtLocation:TextView
        var editRoomNumber:TextView
        var editDate:TextView
        var editTime:TextView
        init {
            this.editCourtName = row?.findViewById(R.id.txtCourtName) as TextView
            this.editCourtLocation = row?.findViewById(R.id.txtCourtLocation) as TextView
            this.editRoomNumber = row?.findViewById(R.id.txtCourtRoom) as TextView
            this.editDate=row?.findViewById(R.id.txtRulingDate) as TextView
            this.editTime=row?.findViewById(R.id.txtRulingTime) as TextView

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder: ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            // The section of clerk is what has been change from item_layout to court_layout
            view = layout.inflate(R.layout.court_layout,parent,false) // This is the section which has been change.
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item: Court = getItem(position) as Court
        viewHolder.editCourtName.text = item.CourtName // All of this section should look the same with the constructor.
        viewHolder.editCourtLocation.text = item.CourtLocation
        viewHolder.editRoomNumber.text = item.CourtRoom
        viewHolder.editDate.text=item.Date
        viewHolder.editTime.text=item.Time


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
