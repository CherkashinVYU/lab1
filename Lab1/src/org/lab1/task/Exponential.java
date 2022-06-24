package org.lab1.task;

class Exponential extends BaseSeries {
    public Exponential(int a0, int r, String name) {
        this.a0 = a0;
        this.d = r;
        this.name = name;
    }

    @Override
    public int getSum(int n) {
        return (a0 - getNumber(n) * d) / (1 - d);
    }

    @Override
    public int getNumber(int j) {
        int tmp = a0;
        for (int i = 1; i <= j; i++) {
            tmp *= d;
        }
        return tmp;
    }

    public int getA0() {
        return a0;
    }

    public int getD() {
        return d;
    }
}
