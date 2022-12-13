/**
 * Amazon
 */
public class Amazon extends ECommerce {
    public String accHolderName = "Krishna";
    public String item;
    public int price;

    public Amazon(String item, int price) {
        this.item = item;
        this.price = price;
    }

    public String getCurrentSale() {
        return "Great Indian Sale";
    }

    public String getWebsiteName() {
        return "Amazon.in";
    }
}