package itachi_waiyan.com.padc_kotlin_first_assignment.adapters

import androidx.recyclerview.widget.RecyclerView
import itachi_waiyan.com.padc_kotlin_first_assignment.viewholders.BaseViewHolder

abstract class BaseAdapter<W : BaseViewHolder<T>,T> : RecyclerView.Adapter<W>(){

    private var dataList : MutableList<T> = ArrayList()

    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: W, position: Int) {
        holder.data = dataList[position]

    }

    fun setNewData(newData : MutableList<T>){
        dataList = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: MutableList<T>){
        dataList.addAll(newData)
        notifyDataSetChanged()
    }
}