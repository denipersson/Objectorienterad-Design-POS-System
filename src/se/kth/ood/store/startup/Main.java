package se.kth.ood.store.startup;

import se.kth.ood.store.controller.Controller;
import se.kth.ood.store.view.TotalRevenueView;
import se.kth.ood.store.view.View;

/**
Starts the entire application
 */
public class Main {

    /**
    The method used to start the application.
    @param args The application does not take any commandline parameter
     */
    public static void main(String[] args){

        Controller controller = new Controller();
        View view = new View(controller);
        view.hardcodeView();

    }

}
