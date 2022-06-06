package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.FlavorDto;
import nl.novi.zaligijsfeest.service.IceCreamFlavorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/icecreamflavors")
public class IceCreamFlavorController {

    private final IceCreamFlavorService iceCreamFlavorService;

    public IceCreamFlavorController(IceCreamFlavorService iceCreamFlavorService) {
        this.iceCreamFlavorService = iceCreamFlavorService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getFlavors() {
        List<FlavorDto> flavorDtoList = iceCreamFlavorService.findFlavors();
        return new ResponseEntity<>(flavorDtoList, HttpStatus.OK);
    }

}
