package nl.novi.zaligijsfeest.model;

import javax.persistence.*;

@Entity
@Table (name = "pictures")
public class FileUpload {

    @Id
    @GeneratedValue
    Long id;

    @Lob
    public byte [] content;

}
