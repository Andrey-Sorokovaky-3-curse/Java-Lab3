package pro.sorokovsky.level2.model;

import pro.sorokovsky.common.validation.MarkException;
import pro.sorokovsky.common.validation.ValidationException;

public class Express extends Train {
    private String mark;

    public Express(String name, String mark) throws ValidationException {
        super(name);
        setMark(mark);
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) throws ValidationException {
        if (mark == null || mark.isEmpty()) {
            throw new MarkException();
        }
        this.mark = mark;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nМарка експресу: " + getMark();
    }
}