package exercise1.structural.adapter;

public class SensorAdapter implements SensorData {
    private Object sensor;

    public SensorAdapter(Object sensor) {
        this.sensor = sensor;
    }

    @Override
    public void readData() {
        if (sensor instanceof JsonSensor jsonSensor) {
            String data = jsonSensor.getJsonData();
            System.out.println("Reading JSON Sensor Data: " + data);
        } else if (sensor instanceof CsvSensor csvSensor) {
            String data = csvSensor.getCsvData();
            System.out.println("Reading CSV Sensor Data: " + data);
        } else {
            System.out.println("Unknown sensor type.");
        }
    }
}
