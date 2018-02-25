package tech.claudio.kotlinmongodbdemo.domain.resources

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.claudio.kotlinmongodbdemo.domain.models.TemperatureRequest
import tech.claudio.kotlinmongodbdemo.domain.service.TemperatureService

@RestController
@RequestMapping("/api/temperature")
class TemperatureResource(val temperatureService: TemperatureService) {

    @GetMapping
    fun all() = this.temperatureService.all()

    @PostMapping
    fun register(request: TemperatureRequest) = this.temperatureService.register(request)

}