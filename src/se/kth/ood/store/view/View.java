package se.kth.ood.store.view;

import se.kth.ood.store.ItemDTO;
import se.kth.ood.store.controller.Controller;
import se.kth.ood.store.exceptions.*;

/**
 * A place-holder class to represent what would otherwise be the real view and interface
 */
public class View {
    private Controller controller;
    private final int firstItemID = 1;
    private final int firstItemQuantity = 5;

    private final int secondItemID = 2;
    private final int secondItemQuantity = 3;
    private LogHandler logHandler = new LogHandler();
    private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();

    /**
     * constructor for view, also runs the hardcoded view
     * @param controller reference to call methods from controller
     */
    public View (Controller controller){
        this.controller = controller;
        controller.addTotalRevenueObserver(new TotalRevenueView());
        controller.addTotalRevenueObserver(new TotalRevenueFileOutput());
    }
    /**
     * A hardcoded method with all the inputs from an imaginary view
     */
    public void hardcodeView(){

        firstHardcodedSale();
        secondHardcodedSale();

    }

    private void firstHardcodedSale(){
        controller.startSale();

        printToConsole("Sale started.");

        tryAddItem(firstItemID, firstItemQuantity);

        tryAddItem(secondItemID, secondItemQuantity);
        int invalidQuantity = -1000;
        tryAddItem(firstItemID, invalidQuantity);

        int errorItemIDTest = 8888;
        tryAddItem(firstItemID, errorItemIDTest);

        int serverErrorID = 404;

        tryAddItem(firstItemID, serverErrorID);

        float totalPrice = controller.endSale();
        controller.enterAmountPaid(totalPrice);
        controller.finish();
    }
    private void tryAddItem(int ID, int quantity){
        try {
            ItemDTO dto = controller.scanItem(ID, quantity);
            sendItemInfoToDisplay(dto);
        }
        catch(InvalidAmountException e)
        {
            errorMessageHandler.printErrorMessage("The inputted amount (" + e.getAmount() + ") is invalid!");
            logHandler.logErrorMessage(e);
        }
        catch(ItemMissingException e)
        {
            errorMessageHandler.printErrorMessage("No item with ID: (" + e.getItemID()  + ") was found." );
            logHandler.logErrorMessage(e);
        }
        catch(ServerErrorException e)
        {
            errorMessageHandler.printErrorMessage("Could not connect to server!");
            logHandler.logErrorMessage(e);
        }
    }

    private void secondHardcodedSale(){
        controller.startSale();

        tryAddItem(firstItemID, firstItemQuantity);
        float totalPrice = controller.endSale();
        controller.enterAmountPaid(totalPrice);
        controller.finish();
    }

    /**
     * prints all necessary item info to "display"(console)
     * @param itemDTO to print
     */
    private void sendItemInfoToDisplay(ItemDTO itemDTO){
        if(!(itemDTO == null)) {

            printToConsole("[VIEW]\n"+ itemDTO.getName() + " x " + itemDTO.getQuantity() +
                    " \n" + "price per unit: " +
                    (itemDTO.getPrice() + itemDTO.getPrice() * itemDTO.getVATrate())
                    + " (" + itemDTO.getPrice() +
                    " + " + itemDTO.getPrice() * itemDTO.getVATrate() + " VAT)" +
                    ", Running total: " + controller.getRunningTotal());
        }
    }

    /**
     * method to print text to the console
     * @param textToPrint to the console
     */
    public void printToConsole(String textToPrint)
    {
        System.out.println(textToPrint);
    }


}
