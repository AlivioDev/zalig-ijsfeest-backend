package nl.novi.zaligijsfeest.service;


import nl.novi.zaligijsfeest.dto.FlavorDto;

import java.util.List;

public interface IceCreamFlavorService {
    List<FlavorDto> getFlavors();
    FlavorDto getFlavor(String name);
    FlavorDto addFlavor(FlavorDto dto);
    void deleteFlavor(String name);
    FlavorDto updateFlavor(String name, FlavorDto dto);
}
