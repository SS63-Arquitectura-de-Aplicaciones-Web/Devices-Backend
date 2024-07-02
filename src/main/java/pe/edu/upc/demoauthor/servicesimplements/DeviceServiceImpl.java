package pe.edu.upc.demoauthor.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoauthor.dtos.DevicesByUserDTO;
import pe.edu.upc.demoauthor.dtos.InvestmentByUser;
import pe.edu.upc.demoauthor.repositories.DeviceRepository;
import pe.edu.upc.demoauthor.services.IDeviceService;

import java.util.List;

@Service
public class DeviceServiceImpl implements IDeviceService {
    @Autowired
    private DeviceRepository deviceRepository;
    public List<DevicesByUserDTO> devicesByUser(){
        return deviceRepository.devicesByUser();
    }
    public List<InvestmentByUser> investmentByUser(){
        return deviceRepository.investmentByUser();
    }
}
