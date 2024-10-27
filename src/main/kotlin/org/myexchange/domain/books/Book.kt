package org.myexchange.domain.books

@Suppress("unused")
class Book<Side>(
    private val side: Side,
    private val limitMap: Map<Long, PriceLevel>
)
