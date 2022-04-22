package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.FlavorDto;
import nl.novi.zaligijsfeest.service.IceCreamFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/open/icecreamflavors")
public class IceCreamFlavorController {

    //koppeling met de servicelaag om de methodes te gebruiken
    @Autowired
    IceCreamFlavorService iceCreamFlavorService;

    //GET mapping voor opvragen alle roomijs smaken
    @GetMapping("")
    public ResponseEntity<Object> getFlavors() {
        List<FlavorDto> flavorDtoList = iceCreamFlavorService.getFlavors();
        return new ResponseEntity<>(flavorDtoList, HttpStatus.OK);
    }

    //GET mapping voor opvragen van een roomijs smaak
    @GetMapping("/{name}")
    public ResponseEntity<Object> getFlavor(@PathVariable("name") String name) {
        FlavorDto flavorDto = iceCreamFlavorService.getFlavor(name);
        return new ResponseEntity<>(flavorDto, HttpStatus.OK);
    }

    //Post mapping voor toevoegen van een roomijs smaak
    @PostMapping("")
    public ResponseEntity<Object> createFlavor(@Valid @RequestBody FlavorDto flavorDto) {
            FlavorDto flavor = iceCreamFlavorService.addFlavor(flavorDto);
        return new ResponseEntity<>("ijssmaak" + flavor + " aangemaakt", HttpStatus.CREATED);
    }

    //Delete mapping voor verwijderen roomijs smaak
    @DeleteMapping("/{name}")
    public ResponseEntity<Object> deleteFlavor(@PathVariable("name") String name) {
        iceCreamFlavorService.deleteFlavor(name);
        return new ResponseEntity<>("Roomijs smaak met naam " + name + " is verwijderd.", HttpStatus.OK);
    }
    //PUT mapping voor aanpassen van een roomijs smaak
    @PutMapping("/{name}")
    public ResponseEntity<Object> updateFlavor(@PathVariable("name") String name, @RequestBody FlavorDto flavor) {
        FlavorDto flavorDto = iceCreamFlavorService.updateFlavor(name, flavor);
        return new ResponseEntity<>(flavorDto, HttpStatus.OK);
    }
}
