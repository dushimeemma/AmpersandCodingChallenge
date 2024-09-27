package com.ampersandcodingchallenge.retrofitgetrecyclerview.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ampersandcodingchallenge.retrofitgetrecyclerview.ProductDetailsActivity
import com.ampersandcodingchallenge.retrofitgetrecyclerview.databinding.ItemLayoutBinding
import com.ampersandcodingchallenge.retrofitgetrecyclerview.models.Product

class RvAdapter(
    private val productList: List<Product>,
    private val itemClick: (Product) -> Unit
) :
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    // Inner ViewHolder class to bind item layout
    inner class ViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the custom item layout using ViewBinding
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.binding.apply {
            // Bind the product details to the TextViews
            tvProductName.text = "Name: ${currentItem.name}"
            tvProductPrice.text = "Price: ${currentItem.data?.price ?: "N/A"}"
            tvProductCapacity.text = "Capacity: ${currentItem.data?.capacity ?: "N/A"}"
        }

        // Handle click event to navigate to ProductDetailsActivity
        holder.itemView.setOnClickListener {
            // Navigate to ProductDetailsActivity with the selected product
            val intent = Intent(holder.itemView.context, ProductDetailsActivity::class.java).apply {
                putExtra("PRODUCT", currentItem) // Pass the product object
            }
            holder.itemView.context.startActivity(intent)
        }
    }
}
