package org.myexchange.domain.books

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.myexchange.domain.TestDataGenerator

class OrdersListTest {

    @Test
    fun emptyOrdersListTest() {
        val emptyList = OrdersList()
        assertThat(emptyList.removeMatched()).isNull()

        assertDoesNotThrow("Calling cancel on empty orders list shouldn't throw exceptions!") {
            emptyList.cancel(TestDataGenerator.createOrder())
        }
    }

    @Test
    fun appendingOrdersToListTest() {
        val firstOrder = TestDataGenerator.createOrder("1")
        val secondOrder = TestDataGenerator.createOrder("2")

        val ordersList = OrdersList()
        ordersList.append(firstOrder)
        ordersList.append(secondOrder)

        assertThat(firstOrder.next).isEqualTo(secondOrder)
        assertThat(firstOrder.prev).isNull()
        assertThat(secondOrder.prev).isEqualTo(firstOrder)
        assertThat(secondOrder.next).isNull()
    }

    @Test
    fun removeMatchedOrderTest() {
        val firstOrder = TestDataGenerator.createOrder("1")
        val secondOrder = TestDataGenerator.createOrder("2")

        val ordersList = OrdersList()
        ordersList.append(firstOrder)
        ordersList.append(secondOrder)

        val matchedOrder = ordersList.removeMatched()
        assertThat(matchedOrder!!.orderId).isEqualTo("1")

        assertThat(secondOrder.prev).isNull()
        assertThat(secondOrder.next).isNull()
    }

    @Test
    fun cancelTailOrderTest() {
        val firstOrder = TestDataGenerator.createOrder("1")
        val secondOrder = TestDataGenerator.createOrder("2")

        val ordersList = OrdersList()
        ordersList.append(firstOrder)
        ordersList.append(secondOrder)


        assertDoesNotThrow("Cancelling existing order shouldn't throw an exception!") {
            ordersList.cancel(secondOrder)
        }

        assertThat(secondOrder.prev).isNull()
        assertThat(secondOrder.next).isNull()
        assertThat(firstOrder.prev).isNull()
        assertThat(firstOrder.next).isNull()
    }

    @Test
    fun cancelMiddleOrderTest() {
        val firstOrder = TestDataGenerator.createOrder("1")
        val secondOrder = TestDataGenerator.createOrder("2")
        val thirdOrder = TestDataGenerator.createOrder("3")

        val ordersList = OrdersList()
        ordersList.append(firstOrder)
        ordersList.append(secondOrder)
        ordersList.append(thirdOrder)


        assertDoesNotThrow("Cancelling existing order shouldn't throw an exception!") {
            ordersList.cancel(secondOrder)
        }

        assertThat(secondOrder.prev).isNull()
        assertThat(secondOrder.next).isNull()

        assertThat(firstOrder.prev).isNull()
        assertThat(firstOrder.next).isEqualTo(thirdOrder)
        assertThat(thirdOrder.prev).isEqualTo(firstOrder)
        assertThat(thirdOrder.next).isNull()
    }

    @Test
    fun iterateOrderList() {
        val firstOrder = TestDataGenerator.createOrder("1")
        val secondOrder = TestDataGenerator.createOrder("2")
        val thirdOrder = TestDataGenerator.createOrder("3")

        val ordersList = OrdersList()
        ordersList.append(firstOrder)
        ordersList.append(secondOrder)
        ordersList.append(thirdOrder)

        val iterator = ordersList.iterator()
        assertThat(iterator).isNotNull
        assertThat(iterator.hasNext()).isTrue()
        assertThat(iterator.next()).isEqualTo(firstOrder)
        assertThat(iterator.next()).isEqualTo(secondOrder)
        assertThat(iterator.next()).isEqualTo(thirdOrder)
        assertThat(iterator.hasNext()).isFalse()
    }
}