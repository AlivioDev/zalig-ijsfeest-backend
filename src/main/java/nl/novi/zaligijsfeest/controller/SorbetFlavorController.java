package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.FlavorDto;
import nl.novi.zaligijsfeest.service.SorbetFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/open/sorbetflavors")
public class SorbetFlavorController {

    //koppeling met de servicelaag om de methoden te kunnen gebruiken
    @Autowired
    SorbetFlavorService sorbetFlavorService;

    //GET mapping voor opvragen alle sorbet smaken
    @GetMapping(path = "")
    public ResponseEntity<Object> getSorbetFlavors() {
        List<FlavorDto> flavorDtoList = sorbetFlavorService.getFlavors();
        return new ResponseEntity<>(flavorDtoList, HttpStatus.OK);
    }

    //GET mapping voor opvragen van een sorbet smaak
    @GetMapping(path = "/{name}")
    public ResponseEntity<Object> getFlavor(@PathVariable("name") String name) {
        FlavorDto flavorDto = sorbetFlavorService.getFlavor(name);
        return new ResponseEntity<>(flavorDto, HttpStatus.OK);
    }

    //Post mapping voor toevoegen van een sorbet smaak
    @PostMapping(path = "")
    public ResponseEntity<Object> createSorbetFlavor(@Valid @RequestBody FlavorDto sorbetFlavorDto) {
        FlavorDto sorbetFlavor = sorbetFlavorService.addFlavor (sorbetFlavorDto);
        return new ResponseEntity<>("ijssmaak" + sorbetFlavor + " aangemaakt", HttpStatus.CREATED);
    }

    //Delete mapping voor verwijderen sorbet smaak
    @DeleteMapping(path = "/{name}")
    public ResponseEntity<Object> deleteFlavor(@PathVariable("name") String name) {
        sorbetFlavorService.deleteFlavor(name);
        return new ResponseEntity<>("Roomijs smaak met id " + name + " is verwijderd.", HttpStatus.OK);
    }

    //PUT mapping voor aanpassen van een sorbet smaak
    @PutMapping(path = "/{name}")
    public ResponseEntity<Object> updateFlavor(@PathVariable("name") String name, @RequestBody FlavorDto sorbetFlavor) {
        FlavorDto sorbetFlavorDto = sorbetFlavorService.updateFlavor(name, sorbetFlavor);
        return new ResponseEntity<> (sorbetFlavorDto, HttpStatus.OK);
    }
}
