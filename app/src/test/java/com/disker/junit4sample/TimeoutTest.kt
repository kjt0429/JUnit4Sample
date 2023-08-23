package com.disker.junit4sample

import org.junit.Rule
import org.junit.Test
import org.junit.rules.Timeout
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * @Test Annotation 에 'timeout' parameter 설정을 통해 메서드 별 timeout 을 설정할 수 있음
 * 해당 설정은 별도 스레드를 실행하여 구현 됨
 */
class TimeoutTest {

    @Test(timeout = 1L)
    fun Test(){
        print("HaHa")
        var sum = 0

        for(i in 0..100000){
            sum += i
        }
        print("sum = $sum")
    }
}

/**
 * 해당 클래스에 전역 timeout 설정을 할 수 있음
 * (CountDownLatch 은 단순 무한 대기를 위한 샘플 코드)
 * https://codechacha.com/ko/java-countdownlatch/
 */
class HasGlobalTimeout {
    private val latch = CountDownLatch(1)

    @JvmField
    @Rule
    var globalTimeout: Timeout = Timeout.seconds(10) // 10 seconds max per method tested
    @Test
    @Throws(Exception::class)
    fun testSleepForTooLong() {
        log += "ran1"
        TimeUnit.SECONDS.sleep(100) // sleep for 100 seconds
    }

    @Test
    @Throws(Exception::class)
    fun testBlockForever() {
        log += "ran2"
        latch.await() // will block 
    }

    companion object {
        var log: String? = null
    }
}