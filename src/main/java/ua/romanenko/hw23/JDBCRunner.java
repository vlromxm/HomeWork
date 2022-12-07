package ua.romanenko.hw23;

import ua.romanenko.hw23.generator.GenerateDevice;
import ua.romanenko.hw23.generator.GenerateFactory;
import ua.romanenko.hw23.repository.DeviceRepository;
import ua.romanenko.hw23.repository.FactoryRepository;

import java.sql.SQLException;

public class JDBCRunner {
    public static void main(String[] args) {
        DeviceRepository deviceRepository = new DeviceRepository();
        FactoryRepository factoryRepository = new FactoryRepository();

//        factoryRepository.createTableFactory();
//        deviceRepository.createTableDevice();

        try {
//            deviceRepository.addDeviceWithFactory();
//            deviceRepository.getById(1670339336807L);
//            deviceRepository.deleteById(1670339336699L);
//            deviceRepository.updateDeviceAndSaveIt(1670339336699L);
            deviceRepository.getDevicesFromFactory(1670341028706L);
//            deviceRepository.getCountAndSumDevicesForFactory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
