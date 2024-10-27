package org.myexchange.domain.products

import java.util.*

data class Product(
    val productId: Int,
    val symbol: String,
    val lotSize: Int,
    val tickSize: Int,
    val quoteCurrency: Currency,
    val settleCurrency: Currency,
    val description: String,
    val field: String
)
