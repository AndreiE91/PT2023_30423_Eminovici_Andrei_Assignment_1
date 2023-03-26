import controllers.CalculatorController;
import models.Polynomial;
import models.CalculatorMain;
import views.*;

public class App {
    public static void main(String[] args) {

        CalculatorMain calculatorMain = new CalculatorMain();
        ViewMain viewMain = new ViewMain();

        CalculatorController calculatorController = new CalculatorController(viewMain, calculatorMain);
    }
}

