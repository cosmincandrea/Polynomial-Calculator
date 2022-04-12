package Controllers;

import Models.Polynom;
import Views.PolynomView;
import Models.PolyonmModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolynomController {

    private PolynomView view;
    private PolyonmModel model;

    public PolynomController(PolynomView view, PolyonmModel model) {
        this.view = view;
        this.model = model;
    }

    public void init(){
        view.view();
        view.addClearListener();
        view.addAddListener(new AddListener());
        view.addSubListener(new DiffListener());
        view.addMultListener(new MulListener());
        view.addIntegrateListener(new IntegrationListener());
        view.addDerivateListener(new DerivListener());
    }

    private void modelInit(){
        model.setPolynomA(model.constructPolynom(view.getInputP1()));
        model.setPolynomB(model.constructPolynom(view.getinputP2()));
    }

    class AddListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            modelInit();
            model.add();
            view.displayResult(model.getPolynomA().toString());
        }
    }

    class DiffListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            modelInit();
            model.diff();
            view.displayResult(model.getPolynomA().toString());
        }
    }

    class MulListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            modelInit();
            Polynom res = model.mul();
            view.displayResult(res.toString());
        }
    }

    class DerivListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            modelInit();
            model.deriv();
            view.displayResult(model.getPolynomA().toString());
        }
    }

    class IntegrationListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            modelInit();
            model.integrate();
            view.displayResult(model.getPolynomA().toString());
        }
    }

}
