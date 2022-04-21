package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.model.FileUpload;
import nl.novi.zaligijsfeest.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/open")
@CrossOrigin
public class FileUploadController {

    @Autowired
    FileUploadRepository fileUploadRepository;


    //een POST-request voor een productafbeelding
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
