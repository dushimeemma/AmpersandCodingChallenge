package com.ampersandcodingchallenge.retrofitgetrecyclerview.utils

import com.ampersandcodingchallenge.retrofitgetrecyclerview.models.Data
import com.ampersandcodingchallenge.retrofitgetrecyclerview.models.Product

object Utils {
    const val BASE_URL = "https://api.restful-api.dev/"
    val fallbackProducts = listOf(
        Product(
            id = 1,
            name = "Smartphone A",
            data = Data(
                cpu = "Octa-Core 2.4GHz",
                capacity = "64GB",
                case = "Aluminum",
                color = "Black",
                description = "A premium smartphone with a stunning display and great battery life.",
                generation = "5G",
                hard = "256GB SSD",
                screen = 6.5,
                strap = null,
                capacityGB = 64,
                price = 699.99,
                year = 2023
            )
        ),
        Product(
            id = 2,
            name = "Smartwatch B",
            data = Data(
                cpu = "Dual-Core 1.1GHz",
                capacity = "32GB",
                case = "Plastic",
                color = "Silver",
                description = "Stylish smartwatch with health tracking features.",
                generation = "4G",
                hard = null,
                screen = 1.4,
                strap = "Silicone",
                capacityGB = 32,
                price = 299.99,
                year = 2022
            )
        ),
        Product(
            id = 3,
            name = "Laptop C",
            data = Data(
                cpu = "Intel i7 10th Gen",
                capacity = "16GB RAM",
                case = "Metal",
                color = "Gray",
                description = "Powerful laptop for professionals.",
                generation = "10th Gen",
                hard = "512GB SSD",
                screen = 15.6,
                strap = null,
                capacityGB = 512,
                price = 1299.99,
                year = 2023
            )
        ),
        Product(
            id = 4,
            name = "Tablet D",
            data = Data(
                cpu = "Quad-Core 2.0GHz",
                capacity = "128GB",
                case = "Plastic",
                color = "Gold",
                description = "Compact tablet with a sharp display and long battery life.",
                generation = "WiFi Only",
                hard = "128GB",
                screen = 10.1,
                strap = null,
                capacityGB = 128,
                price = 499.99,
                year = 2021
            )
        ),
        Product(
            id = 5,
            name = "Smartphone E",
            data = Data(
                cpu = "Hexa-Core 1.8GHz",
                capacity = "128GB",
                case = "Glass",
                color = "Blue",
                description = "Mid-range smartphone with excellent camera performance.",
                generation = "4G",
                hard = "128GB",
                screen = 6.1,
                strap = null,
                capacityGB = 128,
                price = 399.99,
                year = 2022
            )
        )
    )


}
