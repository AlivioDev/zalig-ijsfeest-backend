package nl.novi.zaligijsfeest.Service;

import nl.novi.zaligijsfeest.Dto.SorbetFlavorDto;

import java.util.List;

public interface SorbetFlavorService {
    //Methode voor het opvragen van alle sorbet smaken
    List<SorbetFlavorDto> getSorbetFlavors();

    //Methode voor het ophalen van een roomijs smaak
    SorbetFlavorDto getFlavorById(Long id);

    //Methode voor het toevoegen van een roomijs smaak
    SorbetFlavorDto addFlavor(SorbetFlavorDto sorbetFlavorDto);

    //Methode voor het verwijderen van een roomijs smaak
    void deleteFlavor(Long id);

    //Methode voor het updaten van een roomijs smaak
    SorbetFlavorDto updateFlavor(Long id, SorbetFlavorDto sorbetFlavorDto);
}
