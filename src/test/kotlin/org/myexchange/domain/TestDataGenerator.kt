package org.myexchange.domain

import org.myexchange.domain.constants.Side
import org.myexchange.domain.orders.Order
import org.myexchange.domain.orders.OrderStatus
import java.time.Instant

object TestDataGenerator {

    fun createOrder(orderId: String = "1111-1111-1111", prev: Order? = null, next: Order? = null): Order {
        return Order(
            orderId,
            42,
            10020,
            100,
            Side.BUY,
            OrderStatus.NEW,
            1234,
            1,
            "1111",
            "Robinhood",
            400,
            Instant.now().minusSeconds(100).toEpochMilli(),
            Instant.now().toEpochMilli(),
            prev,
            next
        )
    }
}