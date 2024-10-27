package org.myexchange.domain.books

import org.myexchange.domain.orders.Order

class OrdersList : Iterable<Order> {
    private var head: Order? = null
    private var tail: Order? = null

    fun append(order: Order) {
        if (head == null) {
            head = order
            tail = order
        } else {
            val prevTail = tail
            tail = order
            order.next = null
            order.prev = prevTail

            prevTail?.next = order
        }
    }

    fun removeMatched(): Order? {
        if (head == null) {
            return null
        }

        val order = head!!
        head = order.next
        order.next?.prev = null

        order.nullifyLinks()
        return order
    }

    fun cancel(order: Order) {
        if (order == head && order == tail) {
            order.next = null
            order.prev = null
            head = null
            tail = null
        } else if (order == tail) {
            val previous = order.prev
            previous?.next = null
            tail = previous
        } else if (order == head) {
            val next = order.next
            next?.prev = null
            head = next
        } else {
            val next = order.next
            val previous = order.prev
            previous?.next = next
            next?.prev = previous
        }

        order.nullifyLinks()
    }

    private fun Order.nullifyLinks() {
        this.prev = null
        this.next = null
    }

    override fun iterator(): Iterator<Order> {
        return OrderListIterator(head)
    }

    class OrderListIterator(head: Order?): Iterator<Order> {
        var next: Order? = head

        override fun hasNext(): Boolean {
            return next != null
        }

        override fun next(): Order {
            return next?.let {
                val curr = it
                next = it.next
                curr
            } ?: throw NoSuchElementException()
        }
    }
}
