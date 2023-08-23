package com.disker.junit4sample

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Ignore
import org.junit.Test

/**
 * 테스트 제외
 *
 * 몇몇 이유로 테스트를 제외할 수 있음. 메서드 주석처리 또는 @Test Annotation을 지울 수 있지만,
 * test report에 남지 않음. 대안으로 @Ignore 처리로 제외할 수 있음
 */
class IgnoreTest {
    @Ignore("Test is ignored as a demonstration")
    @Test
    fun testSame() {
        assertThat(1, `is`(1))
    }
}