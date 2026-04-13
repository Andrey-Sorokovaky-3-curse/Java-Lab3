package pro.sorokovsky.level2.model;

import pro.sorokovsky.common.validation.ValidationException;

public class Train extends Transport {
    private String name;
    public Train(String name) throws ValidationException {
        super("Потяг");
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidationException  {
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Назва має бути");
        }
        this.name = name;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nНавзва потягу: " + getName() + ".";
    }
}