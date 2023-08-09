package com.disker.junit4sample

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * [예외 테스트]
 * v4.13 이후 사용 가능한 assertThrows method 를 통해 assertion.
 * Expected Exception 이 발생할 때, 통과. 통과 할 때, exception 객체를 얻을 수 있기 때문에,
 * 메시지와 같은 부분을 추가 검증할 수 있음.
 */
class TestException {

    @Test
    fun testException() {
        val list = ArrayList<Any>()

        val thrown = assertThrows(
            IndexOutOfBoundsException::class.java
        ) { list.add(1, Any()) }

        // assertions on the thrown exception
        assertEquals("Index: 1, Size: 0", thrown.message)
        // assertions on the state of a domain object after the exception has been thrown
        assertTrue(list.isEmpty());
    }
}