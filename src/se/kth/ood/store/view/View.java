package se.kth.ood.store.view;

import se.kth.ood.store.ItemDTO;
import se.kth.ood.store.controller.Controller;

/**
 * A place-holder class to represent what would otherwise be the real view and interface
 */
public class View {
    private Controller controller;
    private final int firstItemID = 1;
    private final int firstItemQuantity = 5;

    private final int secondItemID = 2;
    private final int secondItemQuantity = 3;

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

        ItemDTO firstItemDTO = controller.scanItem(firstItemID, firstItemQuantity);
        sendItemInfoToDisplay(firstItemDTO);

        ItemDTO secondItemDTO = controller.scanItem(secondItemID, secondItemQuantity);
        sendItemInfoToDisplay(secondItemDTO);

        ItemDTO wrongQuantityItemDTO = controller.scanItem(firstItemID, -1000);
        sendItemInfoToDisplay(wrongQuantityItemDTO);

        int errorItemIDTest = 8888;
        ItemDTO nonExistantItemDTO = controller.scanItem(errorItemIDTest, 1);
        sendItemInfoToDisplay(nonExistantItemDTO);

        int serverErrorID = 404;

        ItemDTO serverErrorItem = controller.scanItem(serverErrorID, 1);
        sendItemInfoToDisplay(serverErrorItem);

        float totalPrice = controller.endSale();
        controller.enterAmountPaid(totalPrice);
        controller.finish();
    }

    private void secondHardcodedSale(){
        controller.startSale();

        ItemDTO firstItemDTO = controller.scanItem(firstItemID, firstItemQuantity);
        sendItemInfoToDisplay(firstItemDTO);
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
