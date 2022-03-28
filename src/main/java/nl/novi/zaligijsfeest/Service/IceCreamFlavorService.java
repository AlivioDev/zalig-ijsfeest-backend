package nl.novi.zaligijsfeest.Service;


import nl.novi.zaligijsfeest.Dto.IceCreamFlavorDto;

import java.util.List;

public interface IceCreamFlavorService {

    //Methode voor het ophalen van alle roomijs smaken
    List<IceCreamFlavorDto> getIceCreamFlavors();

    //Methode voor het ophalen van een roomijs smaak
    IceCreamFlavorDto getFlavorById(Long id);

    //Methode voor het toevoegen van een roomijs smaak
    IceCreamFlavorDto addFlavor(IceCreamFlavorDto dto);

    //Methode voor het verwijderen van een roomijs smaak
    void deleteFlavor(Long id);

    //Methode voor het updaten van een roomijs smaak
    IceCreamFlavorDto updateFlavor(Long id, IceCreamFlavorDto dto);
}
