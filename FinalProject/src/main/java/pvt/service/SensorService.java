package pvt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pvt.pojo.Sensor;
import pvt.repository.SensorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {

        @Autowired
        SensorRepository sensorRepository;

        public List<Sensor> getAllSensors(int maxCount) {
            List<Sensor> sensors = new ArrayList<>();

            sensorRepository.findAll().forEach(
                    sensor -> {
                        Sensor sensor1 = new Sensor(sensor.getDeviceId(),sensor.getDeviceName(),
                                sensor.getDeviceIpAdress(),sensor.getDeviceLocation(),
                                 sensor.getSensorId(),
                                 sensor.getSensorValue());
                        if (sensors.size() < maxCount) {
                            sensors.add(sensor1);
                        }
                    }
            );
            return sensors;
        }

        public Sensor getSensorById(int orderId) {
            Sensor sensor = sensorRepository.findById((long) orderId).orElseThrow();

            return new Sensor(sensor.getDeviceId(), sensor.getDeviceName(),
                    sensor.getDeviceIpAdress(),sensor.getDeviceLocation(),
                    sensor.getSensorId(),
                    sensor.getSensorValue());
        }

        public void createNewSensor(Sensor newSensor) {
            Sensor sensor = new Sensor();
            sensor.setDeviceId(newSensor.getDeviceId());
            sensor.setDeviceName(newSensor.getDeviceName());
            sensor.setDeviceIpAdress(newSensor.getDeviceIpAdress());
            sensor.setDeviceLocation(newSensor.getDeviceLocation());
            sensor.setSensorId(newSensor.getSensorId());
            sensor.setSensorValue(newSensor.getSensorValue());
            sensorRepository.save(sensor);
        }
    }


