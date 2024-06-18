package com.devbrunini.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devbrunini.convidados.databinding.RowGuestBinding
import com.devbrunini.convidados.model.GuestsModel
import com.devbrunini.convidados.view.viewholder.GuestViewHolder

class GuestsAdapter: RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuestList: List<GuestsModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(item)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    override fun getItemCount(): Int {
        return mGuestList.count()
    }

    fun updatedGuests(guestsModels: List<GuestsModel>) {
        mGuestList = guestsModels
    }

}