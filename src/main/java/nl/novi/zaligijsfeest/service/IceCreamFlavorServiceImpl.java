package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.FlavorDto;
import nl.novi.zaligijsfeest.model.IceCreamFlavor;
import nl.novi.zaligijsfeest.repository.IceCreamFlavorRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class IceCreamFlavorServiceImpl implements IceCreamFlavorService {

    private final IceCreamFlavorRepository iceCreamFlavorRepository;


    public IceCreamFlavorServiceImpl(@Lazy IceCreamFlavorRepository iceCreamFlavorRepository) {
        this.iceCreamFlavorRepository = iceCreamFlavorRepository;
    }

    @Override
    public List<FlavorDto> findFlavors() {
        List<IceCreamFlavor> flavorList = iceCreamFlavorRepository.findAll();
        List<FlavorDto> flavorDtoList = new ArrayList<>();

        for(IceCreamFlavor flavor : flavorList) {
            FlavorDto flavorDto = transferToFlavorDto(flavor);
            flavorDtoList.add(flavorDto);
        }
        return flavorDtoList;
    }

    public FlavorDto transferToFlavorDto(IceCreamFlavor flavor) {
        var dto = new FlavorDto();
        dto.setName(flavor.getName());
        return dto;
    }
}
