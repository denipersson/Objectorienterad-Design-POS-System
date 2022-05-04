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
        hardcodeView();
    }

    /**
     * A hardcoded method with all the inputs from an imaginary view
     */
    private void hardcodeView(){
        controller.startSale();
        printToConsole("Sale started.");

        ItemDTO firstItemDTO = controller.scanItem(firstItemID, firstItemQuantity);
        sendItemInfoToDisplay(firstItemDTO);

        ItemDTO secondItemDTO = controller.scanItem(secondItemID, secondItemQuantity);
        sendItemInfoToDisplay(secondItemDTO);

        float totalPrice = controller.endSale();
        controller.enterAmountPaid(totalPrice);
        controller.finish();
    }

    /**
     * prints all necessary item info to "display"(console)
     * @param itemDTO to print
     */
    private void sendItemInfoToDisplay(ItemDTO itemDTO){
        printToConsole(itemDTO.getName() + " x " + itemDTO.getQuantity() +
                " \n" + " price per unit: " +
                (itemDTO.getPrice()+itemDTO.getPrice()*itemDTO.getVATrate())
                + " (" + itemDTO.getPrice() +
                " + " + itemDTO.getPrice()*itemDTO.getVATrate() + " VAT)" +
                ", Running total: " + controller.getRunningTotal());
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
