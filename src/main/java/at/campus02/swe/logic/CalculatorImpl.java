package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {

        double b;
        double a;

        switch (op) {
            case add:
                b = pop();
                a = pop();
                return a + b;
            case sub:
                b = pop();
                a = pop();
                return a - b;
            case div:
                b = pop();
                a = pop();
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                b = pop();
                a = pop();
                return a * b;
            case mod:
                b = pop();
                a = pop();
                if (b == 0.0) {
                    throw new CalculatorException("Mod by zero");
                }
                return  a % b;
            case sin:
                a = pop();
                return Math.sin(a);
            case cos:
                a = pop();
                return Math.cos(a);
            case dotproduct:
                return dotproduct();
        }
        return 0;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

    private double dotproduct() throws CalculatorException {
        int nPerVector = (int) pop();

        if (nPerVector < 0) {
            throw new CalculatorException("Number of elements per vector must be > 0");
        }

        double[] aVec = new double[nPerVector];
        for (int i = nPerVector - 1; i >= 0; i--) {
            aVec[i] = pop();
        }

        double[] bVec = new double[nPerVector];
        for (int i = nPerVector - 1; i >= 0; i--) {
            bVec[i] = pop();
        }

        double result = 0.0;
        for (int i = 0; i < nPerVector; i++) {
            result += aVec[i] * bVec[i];
        }

        return result;
    }

}
