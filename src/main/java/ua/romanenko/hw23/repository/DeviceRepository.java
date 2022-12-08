package ua.romanenko.hw23.repository;

import ua.romanenko.hw23.entity.Device;
import ua.romanenko.hw23.entity.Factory;
import ua.romanenko.hw23.generator.GenerateDevice;
import ua.romanenko.hw23.generator.GenerateFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeviceRepository extends JDBCRepository<Device, Long> {

    private final String createDeviceSQL = "INSERT INTO device (device_id, type, model,price, " +
            "date_of_manufacture, description, availability,factory_id_fk) VALUES (?,?,?,?,?,?,?,?)";

    private final String selectDeviceByIdSQL = "SELECT * FROM device WHERE device_id = ?";

    private final String updateDeviceAndSaveIt = "UPDATE device SET type =?,model=?," +
            "price = ?, date_of_manufacture =?,description = ?, availability =? WHERE device_id = ?";

    private final String deleteDeviceById = "DELETE FROM device WHERE device_id = ?";

    private final String selectAllDevicesFromFactory = "SELECT * FROM device WHERE factory_id_fk=?";

    private final String selectCountDevicesAndSumDeviceForFactory = "SELECT COUNT(device_id), factory_id_fk, SUM(price) FROM database.device GROUP BY factory_id_fk;";

    private final String createTableDevice = "CREATE TABLE Device(" +
            "device_id BIGINT NOT NULL," +
            "type VARCHAR(15) NOT NULL," +
            "model VARCHAR(15) NOT NULL," +
            "price int NOT NULL," +
            "date_of_manufacture DATE NOT NULL," +
            "description Text NOT NULL," +
            "availability boolean NOT NULL," +
            "PRIMARY KEY(device_id)," +
            "factory_id_fk BIGINT, " +
            "FOREIGN KEY (factory_id_fk) REFERENCES factory (factory_id));";

    public void createTableDevice() {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createTableDevice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDeviceWithFactory() throws SQLException {
        GenerateFactory generateFactory = new GenerateFactory();
        GenerateDevice generateDevice = new GenerateDevice();
        FactoryRepository factoryRepository = new FactoryRepository();
        DeviceRepository deviceRepository = new DeviceRepository();
        List<Factory> factoryList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            factoryList.add(generateFactory.generateFactory());
            factoryRepository.add(factoryList.get(i));
            int randomIndex = random.nextInt(0, factoryList.size());
            deviceRepository.add(generateDevice.generateDevice(factoryList.get(randomIndex).getId()));
        }
    }

    @Override
    public boolean add(Device device) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(createDeviceSQL)) {
            statement.setLong(1, device.getId());
            statement.setString(2, device.getType());
            statement.setString(3, device.getModel());
            statement.setInt(4, device.getPrice());
            statement.setDate(5, (Date) device.getDateOfManufacture());
            statement.setString(6, device.getDescription());
            statement.setBoolean(7, device.isAvailability());
            statement.setLong(8, device.getFactoryId());
            return statement.execute();
        }
    }

    @Override
    public Device getById(Long id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(selectDeviceByIdSQL)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return deviceFromResultSet(resultSet);
                }
                return null;
            }
        }
    }

    private Device deviceFromResultSet(ResultSet set) throws SQLException {
        Device device = new Device();
        device.setId(set.getLong("device_id"));
        device.setType(set.getString(2));
        device.setModel(set.getString(3));
        device.setPrice(set.getInt(4));
        device.setDateOfManufacture(set.getDate(5));
        device.setDescription(set.getString(6));
        device.setAvailability(set.getBoolean(7));
        device.setFactoryId(set.getLong(8));
        System.out.println(device);
        return device;
    }

    public void getCountAndSumDevicesForFactory() throws SQLException {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectCountDevicesAndSumDeviceForFactory);
            while (resultSet.next()) {
                int count = resultSet.getInt("COUNT(device_id)");
                long factoryIdFk = resultSet.getLong("factory_id_fk");
                int sum = resultSet.getInt("SUM(price)");

                System.out.print("Factory ID = " + factoryIdFk + "; ");
                System.out.print("The number of devices = " + count + "; ");
                System.out.print("The amount of devices = " + sum + ";");
                System.out.println(" ");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDeviceAndSaveIt(Long id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement pr = connection.prepareStatement(updateDeviceAndSaveIt)) {
            GenerateDevice gn = new GenerateDevice();
            GenerateFactory gf = new GenerateFactory();
            Factory factory = gf.generateFactory();
            Device device = gn.generateDevice(factory.getId());
            pr.setString(1, String.valueOf(device.getType()));
            pr.setString(2, String.valueOf(device.getModel()));
            pr.setInt(3, device.getPrice());
            pr.setDate(4, (Date) device.getDateOfManufacture());
            pr.setString(5, String.valueOf(device.getDescription()));
            pr.setBoolean(6, device.isAvailability());
            pr.setLong(7, id);
            pr.executeUpdate();
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(deleteDeviceById)) {
            statement.setLong(1, id);
            statement.execute();
        }
    }

    public List<Device> getDevicesFromFactory(long id) throws SQLException {
        List<Device> deviceList = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(selectAllDevicesFromFactory)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
               while (resultSet.next()){
                    deviceList.add(deviceFromResultSet(resultSet));
                }
            }
            return deviceList;
        }
    }
}
