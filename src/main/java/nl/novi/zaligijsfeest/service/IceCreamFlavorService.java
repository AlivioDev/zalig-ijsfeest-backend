package nl.novi.zaligijsfeest.service;


import nl.novi.zaligijsfeest.dto.FlavorDto;

import java.util.List;

public interface IceCreamFlavorService {
    List<FlavorDto> findFlavors();
}
