package se.kth.ood.store.model;

import se.kth.ood.store.ItemDTO;

/**
 * Receipt class, will be printed after a sale
 */
public class Receipt {
    /**
     * Constructor
     */
    private String textOnReceipt;

    /**
     * Constructor for Receipt, takes in a Sale-object, takes data from that to write information to display on receipt
     * @param sale object with data to put on receipt
     */
    public Receipt(Sale sale){
        textOnReceipt = "\n_____________________\nSale Receipt " + sale.getSaleTime() + "\n";
        ItemDTO itemDTOSInSale[] = sale.getItemDTOSInSale();

        for (int i = 0; i < itemDTOSInSale.length; i++){

            ItemDTO currentDTO = itemDTOSInSale[i];

            textOnReceipt += currentDTO.getName() + " " +
                             (currentDTO.getPrice() + currentDTO.getPrice()*currentDTO.getVATrate()) +
                             " x " + currentDTO.getQuantity() + "\n";
        }

        textOnReceipt += "TOTAL PRICE: " + sale.roundedTotal() + "(" +
                          sale.getRunningTotal() + ")\n" +
                         "THANK YOU, COME AGAIN! \n_____________________";


    }

    @Override
    /**
     * Returns text on receipt
     */
    public String toString() {
        return textOnReceipt;
    }
}
