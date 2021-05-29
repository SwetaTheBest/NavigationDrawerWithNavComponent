package com.swetajain.navigationdrawerwithnavcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.swetajain.navigationdrawerwithnavcomponent.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {
    private var _binding: SecondFragmentBinding? = null
    private val binding get() = _binding!!
    private val args: SecondFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        binding.tvName.text = args.contact.name
        binding.tvPhone.text = args.contact.phone.toString()
        binding.tvAddress.text = args.contact.address
        binding.tvEmail.text = args.contact.email
        return view
    }
}