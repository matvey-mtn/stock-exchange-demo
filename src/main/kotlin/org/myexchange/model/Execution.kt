package org.myexchange.model

import java.util.Currency

data class Execution(
    val execId: String,
    val orderId: String,
    val price: Long,
    val quantity: Long,
    val side: Side,
    val orderStatus: OrderStatus,
    val symbol: Long,
    val userId: Long,
    val feeCurrency: Currency,
    val feeRate: Long,
    val feeAmount: Long,
    val accountId: Long,
    val execStatus: ExecutionStatus,
    val transactionTime: Long
)
