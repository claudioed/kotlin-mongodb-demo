package tech.claudio.kotlinmongodbdemo.domain.service

import org.springframework.stereotype.Service
import tech.claudio.kotlinmongodbdemo.domain.models.Temperature
import tech.claudio.kotlinmongodbdemo.domain.models.TemperatureRequest
import tech.claudio.kotlinmongodbdemo.domain.repository.TemperatureRepository
import java.time.LocalDateTime
import javax.annotation.PostConstruct

@Service
class TemperatureService(val temperatureRepository: TemperatureRepository,val temperaturePopulator: TemperaturePopulator) {

    @PostConstruct
    fun init() = this.temperaturePopulator.sampleData()

    fun all() = this.temperatureRepository.findAll()

    fun register(request: TemperatureRequest) = {
        this.temperatureRepository.save(request.let { Temperature(deviceId = it.deviceId, value = it.value, time = LocalDateTime.now()) })
    }

    fun byDevice(deviceId:String) = this.temperatureRepository.findByDeviceId(deviceId)

}