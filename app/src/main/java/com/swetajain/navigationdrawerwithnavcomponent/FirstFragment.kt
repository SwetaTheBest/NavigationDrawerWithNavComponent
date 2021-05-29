package com.swetajain.navigationdrawerwithnavcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.swetajain.navigationdrawerwithnavcomponent.adapters.ContactListAdapter
import com.swetajain.navigationdrawerwithnavcomponent.databinding.FirstFragmentBinding
import com.swetajain.navigationdrawerwithnavcomponent.models.ContactData

class FirstFragment : Fragment(), ContactListAdapter.ContactsClickListener {
    private var _binding: FirstFragmentBinding? = null
    private val binding: FirstFragmentBinding get() = _binding!!
    private var contactList = mutableListOf<ContactData>()
    private val contactAdapter by lazy { ContactListAdapter(this) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FirstFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        binding.rvContacts.adapter = contactAdapter
        val c1 = ContactData("Sweta", 12, 1234567890, "abc@gmail.com", "Sweet home")
        val c2 = ContactData("S", 12, 1234567890, "abc@gmail.com", "Sweet home")
        val c3 = ContactData("Sw", 12, 1234567890, "abc@gmail.com", "Sweet home")
        val c4 = ContactData("Swe", 12, 1234567890, "abc@gmail.com", "Sweet home")
        val c5 = ContactData("Swet", 12, 1234567890, "abc@gmail.com", "Sweet home")
        val c6 = ContactData("weta", 12, 1234567890, "abc@gmail.com", "Sweet home")
        val c7 = ContactData("eta", 12, 1234567890, "abc@gmail.com", "Sweet home")
        contactList = mutableListOf(c1, c2, c3, c4, c5, c6, c7)

        contactAdapter.setData(contactList)
        return view
    }

    override fun onContactClick(position: Int) {
        val action =
            FirstFragmentDirections.actionFirstFragmentToSecondFragment(contactList[position])
        Navigation.findNavController(binding.root)
            .navigate(action)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}