package pro.sorokovsky.level2;

import pro.sorokovsky.common.validation.DivideByZeroException;
import pro.sorokovsky.common.validation.TransportTypeException;
import pro.sorokovsky.common.validation.ValidationException;

public abstract class Transport {
    private String type;

    public Transport(String type) throws ValidationException {
        setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws ValidationException {
        if (type == null || type.isEmpty()) {
            throw new TransportTypeException();
        }
        this.type = type;
    }

    public final double divide(double a, double b) throws DivideByZeroException {
        if (b == 0) throw new DivideByZeroException();
        return a / b;
    }

    public void printInfo() {
        System.out.println("Тип транспорту: " + getType() + '.');
    }
}