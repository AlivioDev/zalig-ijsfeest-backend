package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.AdminDto;
import nl.novi.zaligijsfeest.exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.exception.UsernameNotFoundException;
import nl.novi.zaligijsfeest.model.Admin;
import nl.novi.zaligijsfeest.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    //Koppeling met de repository
    @Autowired
    private AdminRepository adminRepository;

    //Methode voor het ophalen van alle Admins
    @Override
    public List<AdminDto> getAdmins() {
        List<AdminDto> adminDtoList = new ArrayList<>();
        List<Admin> list = adminRepository.findAll();
        for (Admin admin : list) {
            adminDtoList.add(fromAdmin(admin));
        }
        return adminDtoList;
    }

    //Methode voor het opvragen van een admin
    @Override
    public AdminDto getAdmin(String name) {
        AdminDto adminDto;
        Optional<Admin> admin = adminRepository.findById(name);
        if (admin.isPresent()){
            adminDto = fromAdmin(admin.get());
        }else {
            throw new UsernameNotFoundException(name);
        }
        return adminDto;
    }

    //Methode voor het toevoegen van een admin
    @Override
    public AdminDto addAdmin(AdminDto adminDto) {
        Admin admin = toAdmin(adminDto);
        adminRepository.save(admin);
        return adminDto;
    }

    //Methode voor het verwijderen van een admin
    @Override
    public void deleteAdmin(String name) {
        adminRepository.deleteById(name);
    }

    //Methode voor het wijzigen van een admin
    @Override
    public AdminDto updateAdmin(String name, AdminDto adminDto) {
        if (adminRepository.existsById(name)) {
            Admin admin = adminRepository.findById(name).get();

            admin.setName(adminDto.getName());
            admin.setPassword(adminDto.getPassword());
            admin.setEmail(adminDto.getEmail());
            admin.setRole(adminDto.getRole());

            adminRepository.save(admin);
            return adminDto;
        } else {
            throw new RecordNotFoundException("Geen gegevens gevonden met gebruikersnaam " + name + ".");
        }
    }

    //Methode om de gegevens vanuit de dto aan de entity door te geven
    public Admin toAdmin(AdminDto adminDto) {
        var admin = new Admin();

        admin.setName(adminDto.getName());
        admin.setPassword(adminDto.getPassword());
        admin.setEmail(adminDto.getEmail());
        admin.setRole(adminDto.getRole());

        return admin;
    }

    //Methode om de gegevens vanuit de entity door te geven aan de dto
    public static AdminDto fromAdmin(Admin admin) {
        var adminDto = new AdminDto();

        adminDto.setName(admin.getName());
        adminDto.setPassword(admin.getPassword());
        adminDto.setEmail(admin.getEmail());
        adminDto.setRole(admin.getRole());

        return adminDto;
    }
}

