package com.github.hwanjin_jeong.connect.transforms

import io.kotlintest.shouldBe
import org.apache.kafka.connect.sink.SinkRecord
import org.junit.Test

class SimpleTest {

    @Test
    fun `test`() {
        val xform = Simple<SinkRecord>()
        val expect = "test"

        val ret = xform.apply(SinkRecord(
            "test",
            0,
            null,
            null,
            null,
            null,
            0L
        ))

        ret.topic() shouldBe expect
    }

}
