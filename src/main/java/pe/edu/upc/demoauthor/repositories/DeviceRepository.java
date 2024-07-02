package pe.edu.upc.demoauthor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoauthor.dtos.DevicesByUserDTO;
import pe.edu.upc.demoauthor.dtos.InvestmentByUser;
import pe.edu.upc.demoauthor.entities.Device;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query("select new pe.edu.upc.demoauthor.dtos.DevicesByUserDTO(d.user.username, count(d.id)) from Device d group by d.user.username")
    List<DevicesByUserDTO> devicesByUser();

    @Query("select new pe.edu.upc.demoauthor.dtos.InvestmentByUser(d.user.username, sum(d.price)) from Device d group by d.user.username")
    List<InvestmentByUser>investmentByUser();
}
