package com.example.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.databinding.ItemMainviewmodelBinding

class UserAdapter(private val MainViewModel: List<MainViewModel>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
     class UserViewHolder(private val binding: ItemMainviewmodelBinding): RecyclerView.ViewHolder(binding.root) {
          fun bind(mainViewModel: MainViewModel){
               binding.mainViewModel = mainViewModel
               binding.executePendingBindings()
          }
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
          val layoutInflater = LayoutInflater.from(parent.context)
          val binding = ItemMainviewmodelBinding.inflate(layoutInflater, parent, false)
          return UserViewHolder(binding)
     }

     override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
          val mainViewModel = MainViewModel[position]
          holder.bind(mainViewModel)
     }

     override fun getItemCount(): Int = MainViewModel.size
}