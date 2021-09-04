package chernetskiy.oleg.calculatorgb.ui;

import chernetskiy.oleg.calculatorgb.domain.Calculator;
import chernetskiy.oleg.calculatorgb.domain.PerformOperation;

public class MainPresenter {

    private final MainView view;

    private final Calculator calculator;

    private Double numberOne = 0.0;
    private Double numberTwo = null;

    private PerformOperation operation;

    public MainPresenter(MainView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onKeyPressed(int value) {
        if (numberTwo == null) {
            numberOne = addDigit(numberOne, value);

            view.showResult(String.valueOf(numberOne));
        } else {
            numberTwo = addDigit(numberTwo, value);

            view.showResult(String.valueOf(numberTwo));
        }
    }

    public void onKeyPlusPressed() {
        operation(PerformOperation.ADD);
    }

    public void onKeyMinusPressed() {
        operation(PerformOperation.SUB);
    }

    public void onKeyMultPressed() {
        operation(PerformOperation.MUL);
    }

    public void onKeyDivPressed() {
        operation(PerformOperation.DIV);
    }

    private void operation(PerformOperation op) {
        if (numberTwo == null) {
            operation = op;
            numberTwo = 0.0;
        } else {
            double res = calculator.performOperation(numberOne, numberTwo, operation);
            view.showResult(String.valueOf(res));
        }
    }

    private double addDigit(double number, int digit) {
        double result = number + digit;
        return result;
    }
}
