package pe.edu.upc.demoauthor.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.demoauthor.dtos.DevicesByUserDTO;
import pe.edu.upc.demoauthor.dtos.InvestmentByUser;

import java.util.List;

@Service
public interface IDeviceService {
    List<DevicesByUserDTO> devicesByUser();
    List<InvestmentByUser>investmentByUser();
}
