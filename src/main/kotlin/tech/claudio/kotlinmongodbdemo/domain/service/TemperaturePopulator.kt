package tech.claudio.kotlinmongodbdemo.domain.service

import org.springframework.data.mongodb.core.CollectionOptions
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import tech.claudio.kotlinmongodbdemo.domain.models.Temperature
import tech.claudio.kotlinmongodbdemo.domain.repository.TemperatureRepository
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

@Service
class TemperaturePopulator(val temperatureRepository: TemperatureRepository,val mongo: ReactiveMongoTemplate) {

    fun sampleData(){
        mongo.dropCollection("temperature").then(mongo.createCollection("temperature", CollectionOptions.empty().capped().size(2048).maxDocuments(1000))).subscribe()
        Flux.interval(Duration.ofSeconds(1)).flatMap {
            temperatureRepository.save(Temperature(deviceId = "20",time = LocalDateTime.now(),value = Random().nextDouble()))
        }.subscribe()
    }

}