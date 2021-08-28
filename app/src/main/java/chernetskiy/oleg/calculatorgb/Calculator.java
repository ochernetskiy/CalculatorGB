package chernetskiy.oleg.calculatorgb;

public class Calculator implements PerformOperation {

    Double operand = null;
    String lastOperation = "=";

    @Override
    public void performOperation(Double number, String operation) {
        if(operand == 0) {
            operand = number;
        } else {
            if (lastOperation.equals("=")){
                lastOperation = operation;
            }
            switch(lastOperation) {
                case "=":
                    operand = number;
                    break;
                case "/":
                    if (number == 0) {
                        operand = 0.0;
                    } else {
                        operand /= number;
                    }
                    break;
                case "*":
                    operand *= number;
                    break;
                case "+":
                    operand += number;
                    break;
                case "-":
                    operand -= number;
                    break;
            }
        }
    }
}
