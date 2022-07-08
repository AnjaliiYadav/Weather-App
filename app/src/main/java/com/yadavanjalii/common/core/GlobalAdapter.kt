package com.yadavanjalii.common.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yadavanjalii.common.utils.Helper
import com.yadavanjalii.weather_app.BR

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */

class GlobalAdapter<T>(
    private val layoutId: Int,
    var mutableList: MutableList<T>,
    private val br: Int,
    private var clickListener: RvClickListener,
    private val brs: Map<Int, Any>,
) : RecyclerView.Adapter<GlobalAdapter<T>.ViewHolder>() {
    inner class ViewHolder(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root)

    private lateinit var binding: ViewDataBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.setVariable(br, mutableList[holder.adapterPosition])
        Helper.print("onBindViewHolder br: $br ${mutableList[holder.adapterPosition]}")
        brs.forEach {
            binding.setVariable(it.key, it.value)
            Helper.print("key: ${it.key} value: ${it.value}")
        }
        Helper.print("onBindViewHolder brs: $brs")
        holder.binding.setVariable(
            BR.click,
            View.OnClickListener { v ->
                clickListener.click(
                    v,
                    mutableList[holder.adapterPosition],
                    holder.adapterPosition,
                    this as GlobalAdapter<Any>
                )
            })
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = mutableList.size

    fun setList(mutableList: MutableList<T>) {
        this.mutableList = mutableList
        notifyDataSetChanged()
    }
}