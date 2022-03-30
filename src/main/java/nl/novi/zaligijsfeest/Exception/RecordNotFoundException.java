package nl.novi.zaligijsfeest.Exception;

//klasse voor de RecordNotFoundException methode

import java.io.Serial;

public class RecordNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public RecordNotFoundException(String message) {
        super(message);
    }
}
