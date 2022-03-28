package nl.novi.zaligijsfeest.Controller;

import nl.novi.zaligijsfeest.Dto.IceCreamFlavorDto;

import nl.novi.zaligijsfeest.Service.IceCreamFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class IceCreamFlavorController {

    //Basislijst met smaken
    List<IceCreamFlavorDto> iceCreamFlavorDtos = new ArrayList<>();

    public IceCreamFlavorController() {
        //roomijs smaken
        IceCreamFlavorDto aardbeien = new IceCreamFlavorDto("aardbeien");
        IceCreamFlavorDto banaan = new IceCreamFlavorDto("banaan");
        IceCreamFlavorDto roomijs = new IceCreamFlavorDto("roomijs");
        IceCreamFlavorDto amarena = new IceCreamFlavorDto("amarena");
        IceCreamFlavorDto lemon_cheesecake = new IceCreamFlavorDto("lemon cheesecake");
        IceCreamFlavorDto bosbessenyoghurt = new IceCreamFlavorDto("bosbessenyoghurt");
        IceCreamFlavorDto yoghurt = new IceCreamFlavorDto("yoghurt");
        IceCreamFlavorDto yoghurt_passievrucht = new IceCreamFlavorDto("yoghurt passievrucht");
        IceCreamFlavorDto zuppa_inglese = new IceCreamFlavorDto("zuppa inglese");
        IceCreamFlavorDto chocolade = new IceCreamFlavorDto("chocolade");
        IceCreamFlavorDto mokka = new IceCreamFlavorDto("mokka");
        IceCreamFlavorDto brownies = new IceCreamFlavorDto("brownies");
        IceCreamFlavorDto biscotti = new IceCreamFlavorDto("biscotti");
        IceCreamFlavorDto stracciatella = new IceCreamFlavorDto("stracciatella");
        IceCreamFlavorDto soesocholato = new IceCreamFlavorDto("soesocholato");
        IceCreamFlavorDto tiramisu = new IceCreamFlavorDto("tiramisû");
        IceCreamFlavorDto black_cookies = new IceCreamFlavorDto("black cookies");
        IceCreamFlavorDto bianco_doro = new IceCreamFlavorDto("bianco d'Oro");
        IceCreamFlavorDto hazelnoot = new IceCreamFlavorDto("hazelnoot");
        IceCreamFlavorDto pralinone = new IceCreamFlavorDto("pralinone");
        IceCreamFlavorDto pistache = new IceCreamFlavorDto("pistache");
        IceCreamFlavorDto malaga = new IceCreamFlavorDto("malaga");
        IceCreamFlavorDto kaneel = new IceCreamFlavorDto("kaneel");
        IceCreamFlavorDto butterschotch = new IceCreamFlavorDto("butterschotch");
        IceCreamFlavorDto stroopwafel = new IceCreamFlavorDto("stroopwafel");
        IceCreamFlavorDto salted_caramel = new IceCreamFlavorDto("salted caramel");

        //roomijs
        iceCreamFlavorDtos.add(aardbeien);
        iceCreamFlavorDtos.add(banaan);
        iceCreamFlavorDtos.add(roomijs);
        iceCreamFlavorDtos.add(amarena);
        iceCreamFlavorDtos.add(lemon_cheesecake);
        iceCreamFlavorDtos.add(bosbessenyoghurt);
        iceCreamFlavorDtos.add(yoghurt);
        iceCreamFlavorDtos.add(yoghurt_passievrucht);
        iceCreamFlavorDtos.add(zuppa_inglese);
        iceCreamFlavorDtos.add(chocolade);
        iceCreamFlavorDtos.add(mokka);
        iceCreamFlavorDtos.add(brownies);
        iceCreamFlavorDtos.add(biscotti);
        iceCreamFlavorDtos.add(stracciatella);
        iceCreamFlavorDtos.add(soesocholato);
        iceCreamFlavorDtos.add(tiramisu);
        iceCreamFlavorDtos.add(black_cookies);
        iceCreamFlavorDtos.add(bianco_doro);
        iceCreamFlavorDtos.add(hazelnoot);
        iceCreamFlavorDtos.add(pralinone);
        iceCreamFlavorDtos.add(pistache);
        iceCreamFlavorDtos.add(malaga);
        iceCreamFlavorDtos.add(kaneel);
        iceCreamFlavorDtos.add(butterschotch);
        iceCreamFlavorDtos.add(stroopwafel);
        iceCreamFlavorDtos.add(salted_caramel);

    }

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
