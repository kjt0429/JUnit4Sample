package com.disker.junit4sample

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Suite 를 Runner 로 설정. 여러 class 의 테스트 코드를 묶음으로 실행할 수 있음
 * Runner 설정된 class 는 empty class 로 있어야 함
 *
 * .java 에서는 아래 코드로 설정
 * @RunWith(Suite.class)
 * @Suite.SuiteClasses({Assertions.class, ExampleUnitTest.class})
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(*arrayOf(Assertions::class, ExampleUnitTest::class))
class AggregatingTestInSuites {
    // the class remains empty,
    // used only as a holder for the above annotations
}