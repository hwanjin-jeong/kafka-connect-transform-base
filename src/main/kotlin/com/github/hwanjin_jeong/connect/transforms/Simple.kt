package com.github.hwanjin_jeong.connect.transforms

import org.apache.kafka.common.config.ConfigDef
import org.apache.kafka.connect.connector.ConnectRecord
import org.apache.kafka.connect.transforms.Transformation
import org.apache.kafka.connect.transforms.util.SimpleConfig

class Simple<R : ConnectRecord<R>> : Transformation<R> {

    private lateinit var none: String

    override fun configure(props: Map<String, *>) {
        val config = SimpleConfig(CONFIG_DEF, props)
        none = config.getString(ConfigName.NONE)
    }

    override fun config(): ConfigDef = CONFIG_DEF

    override fun apply(record: R): R {
        return record
    }

    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        val OVERVIEW_DOC = "Kafka connect transform base"

        private val PURPOSE = "base"

        val CONFIG_DEF = ConfigDef()
            .define(
                ConfigName.NONE, ConfigDef.Type.STRING, "", ConfigDef.Importance.HIGH,
                "base config")
    }

    interface ConfigName {
        companion object {
            const val NONE = "none"
        }
    }
}
