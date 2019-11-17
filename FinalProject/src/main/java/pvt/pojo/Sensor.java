package pvt.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "sensorData")
public class Sensor implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GenericGenerator(name = "sensorId", strategy = "increment")

    private  String deviceId;

    private String deviceName;

    private  String deviceLocation;

    private String deviceIpAdress;

    private String sensorId;

    private int sensorValue;

    public Sensor(){};
    public Sensor(String deviceId, String deviceName, String deviceLocation, String deviceIpAdress, String sensorId, int sensorValue) {
        this.deviceId=deviceId;
        this.deviceName=deviceName;
        this.deviceLocation=deviceLocation;
        this.deviceIpAdress=deviceIpAdress;
        this.sensorId = sensorId;
        this.sensorValue = sensorValue;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public String getDeviceIpAdress() {
        return deviceIpAdress;
    }

    public void setDeviceIpAdress(String deviceIpAdress) {
        this.deviceIpAdress = deviceIpAdress;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public int getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(int sensorValue) {
        this.sensorValue = sensorValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sensor sensor = (Sensor) o;

        if (sensorValue != sensor.sensorValue) return false;
        if (!deviceId.equals(sensor.deviceId)) return false;
        if (!deviceName.equals(sensor.deviceName)) return false;
        if (deviceLocation != null ? !deviceLocation.equals(sensor.deviceLocation) : sensor.deviceLocation != null)
            return false;
        if (!deviceIpAdress.equals(sensor.deviceIpAdress)) return false;
        return sensorId.equals(sensor.sensorId);
    }

    @Override
    public int hashCode() {
        int result = deviceId.hashCode();
        result = 31 * result + deviceName.hashCode();
        result = 31 * result + (deviceLocation != null ? deviceLocation.hashCode() : 0);
        result = 31 * result + deviceIpAdress.hashCode();
        result = 31 * result + sensorId.hashCode();
        result = 31 * result + sensorValue;
        return result;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceLocation='" + deviceLocation + '\'' +
                ", deviceIpAdress='" + deviceIpAdress + '\'' +
                ", sensorId='" + sensorId + '\'' +
                ", sensorValue=" + sensorValue +
                '}';
    }
}
