package tech.claudio.kotlinmongodbdemo.domain.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document(collection = "temperature")
class Temperature(@Id val id:String = UUID.randomUUID().toString(), val deviceId:String, val value:Double, val time:LocalDateTime)

class TemperatureRequest(val deviceId:String,val value:Double)