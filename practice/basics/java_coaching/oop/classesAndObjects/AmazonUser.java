public class AmazonUser {
    public static void main(String[] args) {
        Amazon a = new Amazon();
        double emiPM = a.calculateEmiPM(7800, 9, false);
        System.out.println(emiPM);
    }
}
