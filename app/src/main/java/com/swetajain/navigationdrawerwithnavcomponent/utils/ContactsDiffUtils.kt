package com.swetajain.navigationdrawerwithnavcomponent.utils

import androidx.recyclerview.widget.DiffUtil
import com.swetajain.navigationdrawerwithnavcomponent.models.ContactData

class ContactsDiffUtils(
    private val oldContacts: List<ContactData>,
    private val newContacts: List<ContactData>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldContacts.size
    }

    override fun getNewListSize(): Int {
        return newContacts.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldContacts[oldItemPosition].phone == newContacts[newItemPosition].phone
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldContacts[oldItemPosition].name != newContacts[newItemPosition].name -> false
            oldContacts[oldItemPosition].phone != newContacts[newItemPosition].phone -> false
            oldContacts[oldItemPosition].email != newContacts[newItemPosition].email -> false
            oldContacts[oldItemPosition].address != newContacts[newItemPosition].address -> false
            else -> true
        }
    }
}