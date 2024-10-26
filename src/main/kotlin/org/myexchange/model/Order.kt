package org.myexchange.model

data class Order(
    val orderId: String,
    val productId: Int,
    val price: Long,
    val quantity: Long,
    val side: Side,
    val orderStatus: OrderStatus,
    val symbol: Long,
    val userId: Long,
    val clientOrderId: String,
    val broker: String,
    val accountId: Long,
    val entryTime: Long,
    val transactionTime: Long
)
