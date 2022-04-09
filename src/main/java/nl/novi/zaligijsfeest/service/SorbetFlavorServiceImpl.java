package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.SorbetFlavorDto;
import nl.novi.zaligijsfeest.exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.model.SorbetFlavor;
import nl.novi.zaligijsfeest.repository.SorbetFlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SorbetFlavorServiceImpl implements SorbetFlavorService {
    //Koppeling met repository
    @Autowired
    SorbetFlavorRepository sorbetFlavorRepository;

    //Methode voor het opvragen van alle sorbet smaken
    @Override
    public List<SorbetFlavorDto> getSorbetFlavors() {
        List<SorbetFlavor> sorbetFlavorList = sorbetFlavorRepository.findAll();
        List<SorbetFlavorDto> sorbetFlavorDtoList = new ArrayList<>();

        for(SorbetFlavor sorbetFlavor : sorbetFlavorList) {
            SorbetFlavorDto sorbetFlavorDto = transferToSorbetFlavorDto(sorbetFlavor);
            sorbetFlavorDtoList.add(sorbetFlavorDto);
        }
        return sorbetFlavorDtoList;
    }

    //Methode voor het ophalen van een sorbet smaak
    @Override
    public SorbetFlavorDto getFlavorById(Long id) {
        if (sorbetFlavorRepository.findById(id).isPresent()) {
            SorbetFlavor sorbetFlavor = sorbetFlavorRepository.findById(id).get();
            SorbetFlavorDto dto = transferToSorbetFlavorDto(sorbetFlavor);
            return dto;
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met id " + id + ".");
        }
    }

    //Methode voor het toevoegen van een sorbet smaak
    @Override
    public SorbetFlavorDto addFlavor(SorbetFlavorDto sorbetFlavorDto) {
        SorbetFlavor sorbetFlavor = transferToSorbetFlavor(sorbetFlavorDto);
        sorbetFlavorRepository.save(sorbetFlavor);
        return sorbetFlavorDto;
    }

    //Methode voor het verwijderen van een sorbet smaak
    @Override
    public void deleteFlavor(Long id) {
        if (sorbetFlavorRepository.findById(id).isPresent()) {
            sorbetFlavorRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met id " + id + ".");
        }
    }

    //Methode voor het updaten van een sorbet smaak
    @Override
    public SorbetFlavorDto updateFlavor(Long id, SorbetFlavorDto sorbetFlavorDto) {
        if (sorbetFlavorRepository.findById(id).isPresent()) {
            SorbetFlavor sorbetFlavor = sorbetFlavorRepository.findById(id).get();

            sorbetFlavor.setId(sorbetFlavor.getId());
            sorbetFlavor.setName(sorbetFlavorDto.getName());

            sorbetFlavorRepository.save(sorbetFlavor);
            return sorbetFlavorDto;
        } else {
            throw new RecordNotFoundException("Geen smaak gevonden met id " + id + ".");
        }
    }

    //Methode om gegevens vanuit de dto aan de sorbet entity door te geven
    public SorbetFlavor transferToSorbetFlavor(SorbetFlavorDto dto) {
        var flavor = new SorbetFlavor();

        flavor.setId(dto.getId());
        flavor.setName(dto.getName());

        return flavor;
    }

    //Methode om de gegevens vanuit de entitiy aan de sorbet dto door te geven
    public SorbetFlavorDto transferToSorbetFlavorDto(SorbetFlavor sorbetFlavor) {
        var dto = new SorbetFlavorDto();

        dto.setId(sorbetFlavor.getId());
        dto.setName(sorbetFlavor.getName());

        return dto;
    }
}

