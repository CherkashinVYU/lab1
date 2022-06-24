package org.lab1.task;

import java.io.Serial;
import java.io.Serializable;

abstract class BaseSeries implements Series, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    protected int a0;
    protected int d;
    protected String name;

    public abstract int getNumber(int j);

    public abstract int getSum(int n);

    public String getName() {
        return name;
    }
}
