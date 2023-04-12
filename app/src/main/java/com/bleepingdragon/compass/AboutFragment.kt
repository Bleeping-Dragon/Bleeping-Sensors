package com.bleepingdragon.compass

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bleepingdragon.compass.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    //Fragment binding
    private var _binding: FragmentAboutBinding? = null

    //This property is only valid between onCreateView and onDestroyView.
    //https://developer.android.com/topic/libraries/view-binding?hl=es-419
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Inflate the layout for this fragment
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Make links clickable
        binding.bleepingDragonLink.movementMethod = LinkMovementMethod.getInstance()
        binding.privacyPolicyLink.movementMethod = LinkMovementMethod.getInstance()

        //When clicks navigation icon
        binding.toolbar.setNavigationOnClickListener{
            this.findNavController().navigate(R.id.settingsFragment)
        }

    }

    //Delete the bindings
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}