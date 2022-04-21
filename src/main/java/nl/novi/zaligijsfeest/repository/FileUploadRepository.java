package nl.novi.zaligijsfeest.repository;


import nl.novi.zaligijsfeest.model.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
}
