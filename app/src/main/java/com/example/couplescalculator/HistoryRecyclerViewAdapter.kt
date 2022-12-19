package com.example.couplescalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HistoryRecyclerViewAdapter private val loveList: List<LoveTable>,
val onItemClickListener: OnItemClickListener
) : Adapter<HistoryRecyclerViewAdapter.HistoryViewHolder>() {
    inner class HistoryViewHolder(val historyCustomLayoutBinding: HistoryCustomLayoutBinding) :
        RecyclerView.ViewHolder(historyCustomLayoutBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_custom_layout, parent, false)
        return HistoryViewHolder(HistoryCustomLayoutBinding.bind(view))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val loveList = loveList[position]
        holder.historyCustomLayoutBinding.tvCvCouple.text = loveList.Your_Name + " and " + loveList.Partner_Name
        holder.historyCustomLayoutBinding.tvCvPercentage.text = loveList.Percentage + "Love"
        holder.historyCustomLayoutBinding.tvCmResult.text = loveList.Result

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(loveList, position)
        }
    }

    override fun getItemCount(): Int {
        return loveList.size
    }
}