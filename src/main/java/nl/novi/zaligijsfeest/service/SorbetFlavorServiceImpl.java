package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.FlavorDto;
import nl.novi.zaligijsfeest.model.SorbetFlavor;
import nl.novi.zaligijsfeest.repository.SorbetFlavorRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SorbetFlavorServiceImpl implements SorbetFlavorService {

    private final SorbetFlavorRepository sorbetFlavorRepository;

    public SorbetFlavorServiceImpl(@Lazy SorbetFlavorRepository sorbetFlavorRepository) {
        this.sorbetFlavorRepository = sorbetFlavorRepository;
    }

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

    public FlavorDto transferToFlavorDto(SorbetFlavor flavor) {
        var dto = new FlavorDto();
        dto.setName(flavor.getName());
        return dto;
    }
}
