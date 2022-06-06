package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.model.FileUpload;
import nl.novi.zaligijsfeest.repository.FileUploadRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "")
@CrossOrigin
public class FileUploadController {


    private final FileUploadRepository fileUploadRepository;

    public FileUploadController(FileUploadRepository fileUploadRepository) {
        this.fileUploadRepository = fileUploadRepository;
    }

    @PostMapping(path = "/upload")
    public String handleFileUpload(@RequestBody MultipartFile file) {
        FileUpload image = new FileUpload();
        try {
        image.content = file.getBytes();
        }
        catch(IOException iex) {
            return "Error while uploading...";
        }
        fileUploadRepository.save(image);
        return "afbeelding opgeslagen";
    }
}
