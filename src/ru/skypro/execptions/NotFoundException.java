package ru.skypro.execptions;


//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private Object HttpStatus;

    public NotFoundException(String message) {
        super(message);
    }
}
