import Controllers.PolynomController;
import Models.Polynom;
import Models.PolyonmModel;
import Views.PolynomView;

public class Main {
    public static void main(String[] args) {
        PolynomView view = new PolynomView();
        PolyonmModel model = new PolyonmModel();
        PolynomController controller = new PolynomController(view, model);
        controller.init();
    }

}
