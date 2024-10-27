package org.myexchange.domain.orders

import org.myexchange.domain.constants.Side

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
    val transactionTime: Long,
    var prev: Order? = null,
    var next: Order? = null
) {

    override fun toString(): String {
        return "{ \"orderId\": \"$orderId\", \"productId\": \"$productId\", \"price\": \"$price\", " +
                " \"quantity\": \"$quantity\", \"side\": \"$side\", \"orderStatus\": \"$orderStatus\", " +
                " \"symbol\": \"$symbol\", \"userId\": \"$userId\", \"clientOrderId\": \"$clientOrderId\"," +
                " \"broker\": \"$broker\", \"accountId\": \"$accountId\"," +
                " \"entryTime\": \"$entryTime\", \"transactionTime\": \"$transactionTime\" }"
    }
}
