package com.example.profile.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.profile.R
import com.example.profile.databinding.FragmentProfileBinding
import com.example.profile.presentation.adapter.FriendsAdapter

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)

        binding?.rvFriends?.adapter = FriendsAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}