package tech.claudio.kotlinmongodbdemo.domain.repository

import org.springframework.data.mongodb.repository.Tailable
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import tech.claudio.kotlinmongodbdemo.domain.models.Temperature

interface TemperatureRepository:ReactiveCrudRepository<Temperature,String>{

    @Tailable
    fun findByDeviceId(deviceId:String):Flux<Temperature>

}