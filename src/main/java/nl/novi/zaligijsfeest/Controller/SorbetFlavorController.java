package nl.novi.zaligijsfeest.Controller;

import nl.novi.zaligijsfeest.Dto.SorbetFlavorDto;
import nl.novi.zaligijsfeest.Dto.SorbetFlavorDto;
import nl.novi.zaligijsfeest.Service.SorbetFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SorbetFlavorController {

    List<SorbetFlavorDto> sorbetFlavorDtos = new ArrayList<>();

    public SorbetFlavorController() {


    //sorbet smaken
    SorbetFlavorDto meloen = new SorbetFlavorDto("meloen");
    SorbetFlavorDto citroen = new SorbetFlavorDto("citroen");
    SorbetFlavorDto sinaasappel = new SorbetFlavorDto("sinaasappel");
    SorbetFlavorDto mango = new SorbetFlavorDto("mango");
    SorbetFlavorDto cassis = new SorbetFlavorDto("cassis");
    SorbetFlavorDto rode_guave = new SorbetFlavorDto("rode guave");
    SorbetFlavorDto appel = new SorbetFlavorDto("appel");
    SorbetFlavorDto framboos = new SorbetFlavorDto("framboos");

    //sorbet
    sorbetFlavorDtos.add(meloen);
    sorbetFlavorDtos.add(citroen);
    sorbetFlavorDtos.add(sinaasappel);
    sorbetFlavorDtos.add(mango);
    sorbetFlavorDtos.add(cassis);
    sorbetFlavorDtos.add(rode_guave);
    sorbetFlavorDtos.add(appel);
    sorbetFlavorDtos.add(framboos);
    }

    @Autowired
    SorbetFlavorService sorbetFlavorService;

    //GET mapping voor opvragen alle sorbet smaken
    @GetMapping("/sorbetflavors")
    public ResponseEntity<Object> getSorbetFlavors() {
        List<SorbetFlavorDto> sorbetFlavorDtoList = sorbetFlavorService.getSorbetFlavors();
        return new ResponseEntity<>(sorbetFlavorDtoList, HttpStatus.OK);
    }

    //GET mapping voor opvragen van een sorbet smaak
    @GetMapping("/icecreamflavors/{id}")
    public ResponseEntity<Object> getFlavorById(@PathVariable("id") Long id) {
        SorbetFlavorDto flavorDto = sorbetFlavorService.getFlavorById(id);
        return new ResponseEntity<>(flavorDto, HttpStatus.OK);
    }

    //Post mapping voor toevoegen van een sorbet smaak
    @PostMapping("/icecreamflavors")
    public ResponseEntity<Object> createSorbetFlavor(@Valid @RequestBody SorbetFlavorDto sorbetFlavorDto) {
        SorbetFlavorDto sorbetFlavor = sorbetFlavorService.addFlavor (sorbetFlavorDto);
        return new ResponseEntity<>("ijssmaak" + sorbetFlavor + " aangemaakt", HttpStatus.CREATED);
    }

    //Delete mapping voor verwijderen sorbet smaak
    @DeleteMapping("/icecreamflavors/{id}")
    public ResponseEntity<Object> deleteFlavor(@PathVariable("id") Long id) {
        sorbetFlavorService.deleteFlavor(id);
        return new ResponseEntity<>("Roomijs smaak met id " + id + " is verwijderd.", HttpStatus.OK);
    }

    //PUT mapping voor aanpassen van een sorbet smaak
    @PutMapping("/icecreamflavors/{id}")
    public ResponseEntity<Object> updateFlavor(@PathVariable("id") Long id, @RequestBody SorbetFlavorDto sorbetFlavor) {
        SorbetFlavorDto sorbetFlavorDto = sorbetFlavorService.updateFlavor(id, sorbetFlavor);
        return new ResponseEntity<> (sorbetFlavorDto, HttpStatus.OK);
    }
}
