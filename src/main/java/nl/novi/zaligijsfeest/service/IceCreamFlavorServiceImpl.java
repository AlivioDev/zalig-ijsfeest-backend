package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.FlavorDto;
import nl.novi.zaligijsfeest.exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.model.IceCreamFlavor;
import nl.novi.zaligijsfeest.repository.IceCreamFlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IceCreamFlavorServiceImpl implements IceCreamFlavorService {

    //Koppeling met de repository
    @Autowired
    IceCreamFlavorRepository iceCreamFlavorRepository;

    //Methode voor het ophalen van alle roomijs smaken
    @Override
    public List<FlavorDto> getFlavors() {
        List<IceCreamFlavor> flavorList = iceCreamFlavorRepository.findAll();
        List<FlavorDto> flavorDtoList = new ArrayList<>();

        for(IceCreamFlavor flavor : flavorList) {
            FlavorDto flavorDto = transferToFlavorDto(flavor);
            flavorDtoList.add(flavorDto);
        }
        return flavorDtoList;
    }

    //Methode voor het ophalen van een roomijs smaak
    @Override
    public FlavorDto getFlavor(String name) {
        if (iceCreamFlavorRepository.findById(name).isPresent()) {
            IceCreamFlavor flavor = iceCreamFlavorRepository.findById(name).get();
            FlavorDto dto = transferToFlavorDto(flavor);
            return dto;
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met naam " + name + ".");
        }
    }

    //Methode voor het toevoegen van een roomijs smaak
    @Override
    public FlavorDto addFlavor(FlavorDto flavorDto) {
        IceCreamFlavor flavor = transferToFlavor(flavorDto);
        iceCreamFlavorRepository.save(flavor);
        return flavorDto;
    }

    //Methode voor het verwijderen van een roomijs smaak
    @Override
    public void deleteFlavor(String name) {
        if (iceCreamFlavorRepository.findById(name).isPresent()) {
            iceCreamFlavorRepository.deleteById(name);
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met naam " + name + ".");
        }
    }

    //Methode voor het updaten van een roomijs smaak
    @Override
    public FlavorDto updateFlavor(String name, FlavorDto flavorDto) {
        if (iceCreamFlavorRepository.findById(name).isPresent()) {
            IceCreamFlavor flavor = iceCreamFlavorRepository.findById(name).get();

            flavor.setName(flavorDto.getName());

            iceCreamFlavorRepository.save(flavor);
            return flavorDto;
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met naam " + name + ".");
        }
    }

    //Methode om gegevens vanuit de dto aan de roomijs entity door te geven
    public IceCreamFlavor transferToFlavor(FlavorDto dto) {
        var flavor = new IceCreamFlavor();
        flavor.setName(dto.getName());
        return flavor;
    }

    //Methode om de gegevens vanuit de entity aan de roomijs dto door te geven
    public FlavorDto transferToFlavorDto(IceCreamFlavor flavor) {
        var dto = new FlavorDto();
        dto.setName(flavor.getName());
        return dto;
    }
}
