package pro.sorokovsky.common.validation;

public class NotPositiveNumberException extends ValidationException {
    public NotPositiveNumberException(String name) {
        super(name + " має бути позитвним числом.");
    }
}