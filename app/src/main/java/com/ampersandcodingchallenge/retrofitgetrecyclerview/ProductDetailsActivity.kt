package com.ampersandcodingchallenge.retrofitgetrecyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ampersandcodingchallenge.retrofitgetrecyclerview.models.Product
import com.ampersandcodingchallenge.retrofitgetrecyclerview.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable the back button in the toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Retrieve the product object passed from the previous activity
        val product: Product? = intent.getParcelableExtra("PRODUCT")

        if (product == null) {
            Toast.makeText(this, "Product not found", Toast.LENGTH_LONG).show()
            finish() // Close the activity if product is null
            return
        }

        // Set the toolbar title to the product name, if available
        supportActionBar?.title = product.name ?: "Product Details"

        // Display product details
        binding.productName.text = product.name ?: "No Name Available"
        binding.productPrice.text = "Price: $${product.data?.price ?: "N/A"}"
        binding.productImage.setImageResource(R.drawable.ic_placeholder_image) // Use your placeholder image resource

    }

    // Handle back navigation
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
