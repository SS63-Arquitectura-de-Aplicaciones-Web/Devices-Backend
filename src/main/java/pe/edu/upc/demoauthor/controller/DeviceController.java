package pe.edu.upc.demoauthor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.demoauthor.services.IDeviceService;

@RestController
@RequestMapping("/segura/devices")
@CrossOrigin(origins = "http://localhost:4200")
public class DeviceController {
    @Autowired
    private IDeviceService iDeviceService;

    @PreAuthorize("hasAnyAuthority('PROGRAMADOR', 'RECLUTADOR')")
    @GetMapping("/quantityByUser")
    public ResponseEntity<?> certificationsByUser() {
        try {
            return new ResponseEntity<>(iDeviceService.devicesByUser(), HttpStatus.OK);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PreAuthorize("hasAnyAuthority('PROGRAMADOR', 'RECLUTADOR')")
    @GetMapping("/investmentByUser")
    public ResponseEntity<?> investmentByUser() {
        try {
            return new ResponseEntity<>(iDeviceService.investmentByUser(), HttpStatus.OK);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
