package tech.claudio.kotlinmongodbdemo.domain.resources

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.claudio.kotlinmongodbdemo.domain.service.TemperatureService

@RestController
@RequestMapping("/api/device")
class DeviceResource(val temperatureService: TemperatureService) {

    @GetMapping(path = ["/{id}/real-time"],produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun byDeviceRealTime(@PathVariable("id")deviceId:String) = this.temperatureService.byDevice(deviceId)

}