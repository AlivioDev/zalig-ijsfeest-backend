package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.IceCreamFlavorDto;
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
    public List<IceCreamFlavorDto> getIceCreamFlavors() {
        List<IceCreamFlavor> iceCreamFlavorList = iceCreamFlavorRepository.findAll();
        List<IceCreamFlavorDto> iceCreamFlavorDtoList = new ArrayList<>();

        for(IceCreamFlavor iceCreamFlavor : iceCreamFlavorList) {
            IceCreamFlavorDto iceCreamFlavorDto = transferToIceCreamFlavorDto(iceCreamFlavor);
            iceCreamFlavorDtoList.add(iceCreamFlavorDto);
        }
        return iceCreamFlavorDtoList;
    }

    //Methode voor het ophalen van een roomijs smaak
    @Override
    public IceCreamFlavorDto getFlavorById(Long id) {
        if (iceCreamFlavorRepository.findById(id).isPresent()) {
            IceCreamFlavor iceCreamFlavor = iceCreamFlavorRepository.findById(id).get();
            IceCreamFlavorDto dto = transferToIceCreamFlavorDto(iceCreamFlavor);
            return dto;
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met id " + id + ".");
        }
    }

    //Methode voor het toevoegen van een roomijs smaak
    @Override
    public IceCreamFlavorDto addFlavor(IceCreamFlavorDto iceCreamFlavorDto) {
        IceCreamFlavor iceCreamFlavor = transferToIceCreamFlavor(iceCreamFlavorDto);
        iceCreamFlavorRepository.save(iceCreamFlavor);
        return iceCreamFlavorDto;
    }

    //Methode voor het verwijderen van een roomijs smaak
    @Override
    public void deleteFlavor(Long id) {
        if (iceCreamFlavorRepository.findById(id).isPresent()) {
            iceCreamFlavorRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met id " + id + ".");
        }
    }

    //Methode voor het updaten van een roomijs smaak
    @Override
    public IceCreamFlavorDto updateFlavor(Long id, IceCreamFlavorDto iceCreamFlavorDto) {
        if (iceCreamFlavorRepository.findById(id).isPresent()) {
            IceCreamFlavor iceCreamFlavor = iceCreamFlavorRepository.findById(id).get();

            iceCreamFlavor.setId(iceCreamFlavor.getId());
            iceCreamFlavor.setName(iceCreamFlavorDto.getName());

            iceCreamFlavorRepository.save(iceCreamFlavor);
            return iceCreamFlavorDto;
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met id " + id + ".");
        }
    }

    //Methode om gegevens vanuit de dto aan de roomijs entity door te geven
    public IceCreamFlavor transferToIceCreamFlavor(IceCreamFlavorDto dto) {
        var flavor = new IceCreamFlavor();

        flavor.setId(dto.getId());
        flavor.setName(dto.getName());

        return flavor;
    }

    //Methode om de gegevens vanuit de entity aan de roomijs dto door te geven
    public IceCreamFlavorDto transferToIceCreamFlavorDto(IceCreamFlavor iceCreamFlavor) {
        var dto = new IceCreamFlavorDto();

        dto.setId(iceCreamFlavor.getId());
        dto.setName(iceCreamFlavor.getName());

        return dto;
    }
}
