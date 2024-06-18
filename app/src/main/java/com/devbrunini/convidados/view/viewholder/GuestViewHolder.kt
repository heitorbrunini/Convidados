package com.devbrunini.convidados.view.viewholder

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devbrunini.convidados.R
import com.devbrunini.convidados.databinding.RowGuestBinding
import com.devbrunini.convidados.model.GuestsModel

class GuestViewHolder(bind: RowGuestBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestsModel) {
        itemView.findViewById<TextView>(R.id.text_name).text = guest.name
    }

}