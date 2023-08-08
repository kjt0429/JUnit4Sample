package com.disker.junit4sample

import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.OrderWith
import org.junit.runner.manipulation.Alphanumeric
import org.junit.runners.MethodSorters

/**
 * [테스트 실행 순서]
 * Junit 에서 default 호출 순서는 JVM reflection API 를 통해 리턴 받는 순 으로 순서가 일정 하지 않음
 * 4.11 부터는 deterministic, but not predictable, order (보통 C++ 에서 랜덤 함수 호출하면, 시드 안 바꿔주면 항상 같은 것과 같은 의미)
 *
 * v4.13 이후, @OrderWith Annotation parameter 로 org.junit.tests.manipulation package's Ordering.Factory 구현체 를 전달할 수 있음
 * https://github.com/junit-team/junit4/wiki/Test-execution-order
 */
@OrderWith(Alphanumeric::class)
class TestExecutionOrder {
    @Test
    fun testA() {
        println("first")
    }

    @Test
    fun testB() {
        println("second")
    }

    @Test
    fun testC() {
        println("third")
    }
}

/**
 * v4.11 이후, @FixMethodOrder annotation 을 통해 순서를 결정할 수 있음
 *
 * MethodSorters.JVM : JVM에 의해 리턴되는 순. 실행마다 다름
 * MethodSorters.NAME_ASCENDING : 메서드 이름 사전순 정렬
 * MethodSorters.DEFAULT: @FixMethodOrder 또는 @OrderWith annotation 을 설정 않을 시 기본 설정 값
 * (deterministic, but not predictable, order)
 */
@FixMethodOrder(MethodSorters.JVM)
class TestExecutionOrder2 {
    @Test
    fun testA() {
        println("first")
    }

    @Test
    fun testB() {
        println("second")
    }

    @Test
    fun testC() {
        println("third")
    }
}