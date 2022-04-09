package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.SorbetFlavorDto;
import nl.novi.zaligijsfeest.service.SorbetFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SorbetFlavorController {

    //koppeling met de servicelaag om de methoden te kunnen gebruiken
    @Autowired
    SorbetFlavorService sorbetFlavorService;

    //GET mapping voor opvragen alle sorbet smaken
    @GetMapping("/sorbetflavors")
    public ResponseEntity<Object> getSorbetFlavors() {
        List<SorbetFlavorDto> sorbetFlavorDtoList = sorbetFlavorService.getSorbetFlavors();
        return new ResponseEntity<>(sorbetFlavorDtoList, HttpStatus.OK);
    }

    //GET mapping voor opvragen van een sorbet smaak
    @GetMapping("/sorbetflavors/{id}")
    public ResponseEntity<Object> getFlavorById(@PathVariable("id") Long id) {
        SorbetFlavorDto flavorDto = sorbetFlavorService.getFlavorById(id);
        return new ResponseEntity<>(flavorDto, HttpStatus.OK);
    }

    //Post mapping voor toevoegen van een sorbet smaak
    @PostMapping("/sorbetflavors")
    public ResponseEntity<Object> createSorbetFlavor(@Valid @RequestBody SorbetFlavorDto sorbetFlavorDto) {
        SorbetFlavorDto sorbetFlavor = sorbetFlavorService.addFlavor (sorbetFlavorDto);
        return new ResponseEntity<>("ijssmaak" + sorbetFlavor + " aangemaakt", HttpStatus.CREATED);
    }

    //Delete mapping voor verwijderen sorbet smaak
    @DeleteMapping("/sorbetflavors/{id}")
    public ResponseEntity<Object> deleteFlavor(@PathVariable("id") Long id) {
        sorbetFlavorService.deleteFlavor(id);
        return new ResponseEntity<>("Roomijs smaak met id " + id + " is verwijderd.", HttpStatus.OK);
    }

    //PUT mapping voor aanpassen van een sorbet smaak
    @PutMapping("/sorbetflavors/{id}")
    public ResponseEntity<Object> updateFlavor(@PathVariable("id") Long id, @RequestBody SorbetFlavorDto sorbetFlavor) {
        SorbetFlavorDto sorbetFlavorDto = sorbetFlavorService.updateFlavor(id, sorbetFlavor);
        return new ResponseEntity<> (sorbetFlavorDto, HttpStatus.OK);
    }
}
