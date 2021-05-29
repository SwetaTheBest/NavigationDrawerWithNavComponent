package com.swetajain.navigationdrawerwithnavcomponent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.swetajain.navigationdrawerwithnavcomponent.databinding.ItemLayoutBinding
import com.swetajain.navigationdrawerwithnavcomponent.models.ContactData
import com.swetajain.navigationdrawerwithnavcomponent.utils.ContactsDiffUtils

class ContactListAdapter(var listener: ContactsClickListener) :
    RecyclerView.Adapter<ContactListAdapter.ContactsViewHolder>() {
    var list = emptyList<ContactData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        return ContactsViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.binding.personName.text = list[position].name
        holder.binding.personEmail.text = list[position].email
        holder.binding.personMobile.text = list[position].phone.toString()
        holder.binding.personAddress.text = list[position].address
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(newList: List<ContactData>) {
        val contactDiffUtil = ContactsDiffUtils(list, newList)
        val diffResultList = DiffUtil.calculateDiff(contactDiffUtil)
        list = newList
        diffResultList.dispatchUpdatesTo(this)
    }

    inner class ContactsViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (adapterPosition != RecyclerView.NO_POSITION)
                listener.onContactClick(adapterPosition)
        }
    }

    interface ContactsClickListener {
        fun onContactClick(position: Int)
    }
}

