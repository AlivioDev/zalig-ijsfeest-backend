package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.AdminDto;

import java.util.List;

public interface AdminService {
    List<AdminDto> getAdmins();
    AdminDto getAdmin(String adminName);
    AdminDto addAdmin(AdminDto adminDto);
    void deleteAdmin(String adminName);
    AdminDto updateAdmin(String adminName, AdminDto adminDto);
}
