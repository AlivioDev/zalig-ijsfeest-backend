package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.IceCreamFlavorDto;

import nl.novi.zaligijsfeest.service.IceCreamFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class IceCreamFlavorController {

    //koppeling met de servicelaag om de methodes te gebruiken
    @Autowired
    IceCreamFlavorService iceCreamFlavorService;

    //GET mapping voor opvragen alle roomijs smaken
    @GetMapping("/icecreamflavors")
    public ResponseEntity<Object> getIceCreamFlavors() {
        List<IceCreamFlavorDto> iceCreamFlavorDtoList = iceCreamFlavorService.getIceCreamFlavors();
        return new ResponseEntity<>(iceCreamFlavorDtoList, HttpStatus.OK);
    }

    //GET mapping voor opvragen van een roomijs smaak
    @GetMapping("/icecreamflavors/{id}")
    public ResponseEntity<Object> getFlavorById(@PathVariable("id") Long id) {
        IceCreamFlavorDto flavorDto = iceCreamFlavorService.getFlavorById(id);
        return new ResponseEntity<>(flavorDto, HttpStatus.OK);
    }

    //Post mapping voor toevoegen van een roomijs smaak
    @PostMapping("/icecreamflavors")
    public ResponseEntity<Object> createIceCreamFlavor(@Valid @RequestBody IceCreamFlavorDto iceCreamFlavorDto) {
            IceCreamFlavorDto iceCreamFlavor = iceCreamFlavorService.addFlavor(iceCreamFlavorDto);
        return new ResponseEntity<>("ijssmaak" + iceCreamFlavor + " aangemaakt", HttpStatus.CREATED);
    }

    //Delete mapping voor verwijderen roomijs smaak
    @DeleteMapping("/icecreamflavors/{id}")
    public ResponseEntity<Object> deleteFlavor(@PathVariable("id") Long id) {
        iceCreamFlavorService.deleteFlavor(id);
        return new ResponseEntity<>("Roomijs smaak met id " + id + " is verwijderd.", HttpStatus.OK);
    }
    //PUT mapping voor aanpassen van een roomijs smaak
    @PutMapping("/icecreamflavors/{id}")
    public ResponseEntity<Object> updateFlavor(@PathVariable("id") Long id, @RequestBody IceCreamFlavorDto iceCreamFlavor) {
        IceCreamFlavorDto iceCreamFlavorDto = iceCreamFlavorService.updateFlavor(id, iceCreamFlavor);
        return new ResponseEntity<>(iceCreamFlavorDto, HttpStatus.OK);
    }
}
