package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.AdminDto;
import nl.novi.zaligijsfeest.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(path = "/admins")
public class AdminController {

    //Koppeling met de servicelaag om de methoden te kunnen gebruiken
    @Autowired
    private AdminService adminService;

    //een GET-request voor alle admins
    @GetMapping(path = "")
    public ResponseEntity<Object> getAdmins() {
        List<AdminDto> adminDtoList = adminService.getAdmins();
        return new ResponseEntity<>(adminDtoList, HttpStatus.OK);
    }

    //en GET-request voor 1 user via admins
    @GetMapping(path = "/{name}")
    public ResponseEntity<Object> getAdminByUsername(@PathVariable("name") String name) {
        AdminDto adminDto = adminService.getAdmin(name);
        return new ResponseEntity<>(adminDto, HttpStatus.OK);
    }

    //een POST-request voor 1 admin
    @PostMapping(path = "")
    public ResponseEntity<Object> addAdmin(@RequestBody AdminDto adminDto) {
        AdminDto admin = adminService.addAdmin(adminDto);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    //een DELETE-request voor 1 admin
    @DeleteMapping(path = "/{name}")
    public ResponseEntity<Object> deleteAdmin(@PathVariable("name") String name) {
        adminService.deleteAdmin(name);
        return ResponseEntity.noContent().build();
    }

    //een PUT-request voor 1 admin
    @PutMapping(path = "/{name}")
    public ResponseEntity<Object> updateAdmin(@PathVariable("name") String name, @RequestBody AdminDto adminDto) {
        AdminDto user = adminService.updateAdmin(name, adminDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
