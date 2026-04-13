package pro.sorokovsky.level2.model;

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
    public String getInfo() {
        return super.getInfo() + "\nРозмір баку: " + getMaxFull() + "л.";
    }
}