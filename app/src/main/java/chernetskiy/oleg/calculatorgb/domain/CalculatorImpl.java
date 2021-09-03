package chernetskiy.oleg.calculatorgb.domain;

public class CalculatorImpl implements Calculator {

    @Override
    public double performOperation(double numberOne, double numberTwo, PerformOperation operation) {
        switch (operation) {
            case ADD:
                return numberOne + numberTwo;

            case SUB:
                return numberOne - numberTwo;

            case MUL:
                return numberOne * numberTwo;

            case DIV:
                return numberOne / numberTwo;
        }
        return 0;
    }
}
