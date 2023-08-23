package com.disker.junit4sample

import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.anyOf
import org.hamcrest.CoreMatchers.both
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.either
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.everyItem
import org.hamcrest.CoreMatchers.hasItems
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.sameInstance
import org.hamcrest.CoreMatchers.startsWith
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNotSame
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Test

/**
 * JUnit4 에서 제공 하는 Assertions 메서드 테스트 샘플 코드
 *
 * JUnit4.11 이상 부터, Hamcrest 패키지 를 포함하여 함께 제공
 * org.junit 에서 제공하는 메서드의 경우 (선택적 실패 메시지, 예상 값, 실제 값)을 파라미터로 받지만,
 * org.hamcrest 에서 제공하는 메서드의 경우 (선택적 실패 메시지, 실제 값, 예상값)으로 파라미터가 반대임 주의!
 */
class Assertions {
    @Test
    fun testAssertArrayEquals() {
        val expected = "trial".toByteArray()
        val actual = "trial".toByteArray()
        assertArrayEquals("failure - byte arrays not same", expected, actual)
    }

    @Test
    fun testAssertEquals() {
        assertEquals("failure - strings are not equal", "text", "text")
    }

    @Test
    fun testAssertFalse() {
        assertFalse("failure - should be false", false)
    }

    @Test
    fun testAssertNotNull() {
        assertNotNull("should not be null", Any())
    }

    @Test
    fun testAssertNotSame() {
        assertNotSame("should not be same Object", Any(), Any())
    }

    @Test
    fun testAssertNull() {
        assertNull("should be null", null)
    }

    @Test
    fun testAssertSame() {
        val aNumber = Integer.valueOf(768)
        assertSame("should be same", aNumber, aNumber)
    }

    // Here below code is 'org.hamcrest example' test
    @Test
    fun testAssertThatBothContainsString() {
        assertThat("albumen", both(containsString("a")).and(containsString("b")))
    }

    @Test
    fun testAssertThatHasItems() {
        assertThat(listOf("one", "two", "three"), hasItems("one", "three"));
    }

    @Test
    fun testAssertThatEveryItemContainsString() {
        assertThat(listOf("fun", "ban", "net"), everyItem(containsString("n")))
    }

    @Test
    fun testAssertThatHamcrestCoreMatchers() {
        assertThat("good", allOf(equalTo("good"), startsWith("good")))
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))))
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")))
        assertThat(7, not(either(equalTo(3)).or(equalTo(4))))
        assertThat(Any(), not(sameInstance(Any())))
    }
}