/**
 * Amazon
 */
public class Amazon {
    public String accHolderName = "Krishna";
    public String itemName;

    public double calculateEmiPM(double amount, int noOfEmis, boolean isNoCostEmi) {
        double processingFees = 99;
        int gstRate = 18;
        int interestRate = 14;

        // Step 1: Calculate Interest
        double interestPA = amount * (interestRate / 100.0);
        double interestPM = interestPA / 12;

        double totalInterest = interestPM * noOfEmis;

        // Step 2 : Calculate GST on interest amount

        double gst = totalInterest * (gstRate / 100.0);

        // Step 3: Calculate emi for given months

        double totalEmi;
        if (isNoCostEmi) {
            totalEmi = amount + gst + processingFees;
        } else {
            totalEmi = amount + totalInterest + gst + processingFees;
        }

        // Step 4: Calculate emi per month;

        double emiPM = totalEmi / noOfEmis;

        return emiPM;
    }
}