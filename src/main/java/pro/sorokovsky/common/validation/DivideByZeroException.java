package pro.sorokovsky.common.validation;

public class DivideByZeroException extends ValidationException{
    public DivideByZeroException() {
        super("Ділити на 0 не можна.");
    }
}