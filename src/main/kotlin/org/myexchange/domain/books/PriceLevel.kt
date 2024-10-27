package org.myexchange.domain.books

import java.util.*

@Suppress("unused")
class PriceLevel(
    private val limitPrice: Long,
    private val totalVolume: Long,
    private val orders: TreeMap<Long, OrdersList>
)
