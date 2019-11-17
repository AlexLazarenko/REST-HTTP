package pvt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pvt.pojo.Sensor;
import pvt.service.SensorService;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class SensorController {
        Logger log = Logger.getLogger("OrderController");

        @Autowired
        SensorService service;

        @GetMapping("/device")
        public List<Sensor> getSensors(@RequestParam int maxCount) {
            if (maxCount < 1) throw new IllegalArgumentException();
            return service.getAllSensors(maxCount);
        }

        @GetMapping("/sensor/{sensorId}")
        public Sensor getSensor(@PathVariable("sensorId") int sensorId) {
            return service.getSensorById(sensorId);
        }

        @PostMapping("/sensor")
        public void createNewSensor(@RequestBody Sensor newSensor) {
            service.createNewSensor(newSensor);
            log.info("New sensor: " + newSensor);
        }

        @PutMapping("/sensor/{id}")
        public void updateSensor(@PathVariable int id,
                                @RequestBody Sensor sensor) {
            log.info("Update sensor ID=" + id + " " + sensor);
        }

        @DeleteMapping("/sensor/{id}")
        public void deleteSensor(@PathVariable int id) {
            log.info("Delete sensor ID=" + id);
        }

    }


