package pvt.repository;
import org.springframework.data.repository.CrudRepository;
import pvt.pojo.Sensor;

public interface SensorRepository extends CrudRepository<Sensor, Long> {
    }

