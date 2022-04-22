package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.FlavorDto;
import nl.novi.zaligijsfeest.exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.model.SorbetFlavor;
import nl.novi.zaligijsfeest.repository.SorbetFlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SorbetFlavorServiceImpl implements SorbetFlavorService {

    //Koppeling met de repository
    @Autowired
    SorbetFlavorRepository sorbetFlavorRepository;

    //Methode voor het ophalen van alle sorbet smaken
    @Override
    public List<FlavorDto> getFlavors() {
        List<SorbetFlavor> flavorList = sorbetFlavorRepository.findAll();
        List<FlavorDto> flavorDtoList = new ArrayList<>();

        for(SorbetFlavor flavor : flavorList) {
            FlavorDto flavorDto = transferToFlavorDto(flavor);
            flavorDtoList.add(flavorDto);
        }
        return flavorDtoList;
    }

    //Methode voor het ophalen van een sorbet smaak
    @Override
    public FlavorDto getFlavor(String name) {
        if (sorbetFlavorRepository.findById(name).isPresent()) {
            SorbetFlavor flavor = sorbetFlavorRepository.findById(name).get();
            FlavorDto dto = transferToFlavorDto(flavor);
            return dto;
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met naam " + name + ".");
        }
    }

    //Methode voor het toevoegen van een sorbet smaak
    @Override
    public FlavorDto addFlavor(FlavorDto flavorDto) {
        SorbetFlavor flavor = transferToFlavor(flavorDto);
        sorbetFlavorRepository.save(flavor);
        return flavorDto;
    }

    //Methode voor het verwijderen van een sorbet smaak
    @Override
    public void deleteFlavor(String name) {
        if (sorbetFlavorRepository.findById(name).isPresent()) {
            sorbetFlavorRepository.deleteById(name);
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met naam " + name + ".");
        }
    }

    //Methode voor het updaten van een sorbet smaak
    @Override
    public FlavorDto updateFlavor(String name, FlavorDto flavorDto) {
        if (sorbetFlavorRepository.findById(name).isPresent()) {
            SorbetFlavor flavor = sorbetFlavorRepository.findById(name).get();

            flavor.setName(flavorDto.getName());

            sorbetFlavorRepository.save(flavor);
            return flavorDto;
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met naam " + name + ".");
        }
    }

    //Methode om gegevens vanuit de dto aan de sorbet entity door te geven
    public SorbetFlavor transferToFlavor(FlavorDto dto) {
        var flavor = new SorbetFlavor();
        flavor.setName(dto.getName());
        return flavor;
    }

    //Methode om de gegevens vanuit de entity aan de sorbet dto door te geven
    public FlavorDto transferToFlavorDto(SorbetFlavor flavor) {
        var dto = new FlavorDto();
        dto.setName(flavor.getName());
        return dto;
    }
}
