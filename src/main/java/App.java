import controllers.CalculatorController;
import models.Polynomial;
import views.*;

public class App {
    public static void main(String[] args) {

        ViewMain viewMain = new ViewMain();

        CalculatorController calculatorController = new CalculatorController(viewMain);
    }
}

