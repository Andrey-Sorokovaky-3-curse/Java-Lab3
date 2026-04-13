package pro.sorokovsky.level2;

import pro.sorokovsky.common.validation.NotPositiveNumberException;
import pro.sorokovsky.common.validation.ValidationException;

public class Car extends Transport{
    private long maxFull;

    public Car(long maxFull) throws ValidationException {
        super("Автомобіль");
        setMaxFull(maxFull);
    }

    public long getMaxFull() {
        return maxFull;
    }

    public void setMaxFull(long maxFull) throws ValidationException {
        if (maxFull < 0) {
            throw new NotPositiveNumberException("Розмір баку");
        }
        this.maxFull = maxFull;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Розмір баку: " + getMaxFull() + "л.");
    }
}