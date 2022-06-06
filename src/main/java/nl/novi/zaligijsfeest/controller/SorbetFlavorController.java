package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.FlavorDto;
import nl.novi.zaligijsfeest.service.SorbetFlavorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/sorbetflavors")
public class SorbetFlavorController {

    private final SorbetFlavorService sorbetFlavorService;

    public SorbetFlavorController(SorbetFlavorService sorbetFlavorService) {
        this.sorbetFlavorService = sorbetFlavorService;
    }

    @GetMapping(path = "")
    public ResponseEntity<Object> getSorbetFlavors() {
        List<FlavorDto> flavorDtoList = sorbetFlavorService.getFlavors();
        return new ResponseEntity<>(flavorDtoList, HttpStatus.OK);
    }

}
