package com.example.profile.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.profile.databinding.ItemFriendBinding

class FriendsAdapter: RecyclerView.Adapter<FriendsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsHolder =
        FriendsHolder(
            binding = ItemFriendBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: FriendsHolder, position: Int) {

    }
}