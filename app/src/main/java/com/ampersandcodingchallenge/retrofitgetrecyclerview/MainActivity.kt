package com.ampersandcodingchallenge.retrofitgetrecyclerview

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ampersandcodingchallenge.retrofitgetrecyclerview.adapters.RvAdapter
import com.ampersandcodingchallenge.retrofitgetrecyclerview.databinding.ActivityMainBinding
import com.ampersandcodingchallenge.retrofitgetrecyclerview.models.Product
import com.ampersandcodingchallenge.retrofitgetrecyclerview.utils.RetrofitInstance
import com.ampersandcodingchallenge.retrofitgetrecyclerview.utils.Utils.fallbackProducts
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: RvAdapter
    private var productList: List<Product> = emptyList() // Simplified to avoid redundant initialization

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.VISIBLE // Show progress bar when starting

        fetchProducts() // Call the method to fetch products
    }

    // Function to fetch the list of products from the API
    private fun fetchProducts() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = try {
                RetrofitInstance.api.getAllUsers()
            } catch (e: IOException) {
                handleError("App error: ${e.message}") // Handle IOException
                return@launch
            } catch (e: HttpException) {
                handleError("HTTP error: ${e.message}") // Handle HttpException
                return@launch
            }

            if (response.isSuccessful && response.body() != null) {
                productList = response.body()!!
                withContext(Dispatchers.Main) {
                    setupRecyclerView() // Set up RecyclerView with the fetched products
                }
            } else {
                handleError("Failed to retrieve products.") // Handle unsuccessful response
            }
        }
    }

    // Function to handle API call errors and display fallback data
    private fun handleError(message: String) {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
            displayFallbackProducts() // Show fallback products when an error occurs
        }
    }

    // Function to display the fallback list of products
    private fun displayFallbackProducts() {
        productList = fallbackProducts
        setupRecyclerView() // Reuse the same method to set up RecyclerView
    }

    // Function to set up the RecyclerView
    private fun setupRecyclerView() {
        rvAdapter = RvAdapter(productList) { product ->
            // Navigate to ProductDetailsActivity with the selected product
            val intent = Intent(this, ProductDetailsActivity::class.java).apply {
                putExtra("PRODUCT", product) // Pass the product object
            }
            startActivity(intent)
        }


        binding.rvMain.apply {
            adapter = rvAdapter

            // Dynamically set LayoutManager based on orientation
            layoutManager = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                GridLayoutManager(this@MainActivity, 3) // 3 columns in landscape
            } else {
                LinearLayoutManager(this@MainActivity) // Linear layout in portrait
            }
        }

        binding.progressBar.visibility = View.GONE // Hide progress bar once data is loaded
    }
}
