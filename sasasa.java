
/**
 * Create class Medicine with below attributes: MedicineName - String batch -
 * String disease - String price - int
 * 
 * Create class Solution and implement static method "getPriceByDisease" in the
 * Solution class. This method will take array of Medicine objects and a disease
 * String as parameters. And will return another sorted array of Integer objects
 * where the disease String matches with the original array of Medicine object's
 * disease attribute (case insensitive search).
 * 
 * Write necessary getters and setters.
 * 
 * Before calling "getPriceByDisease" method in the main method, read values for
 * four Medicine objects referring the attributes in above sequence along with a
 * String disease. Then call the "getPriceByDisease" method and print the
 * result.
 * 
 * Input dolo650 FAC124W fever 100 paracetamol PAC545B bodypain 150 almox
 * ALM747S fever 200 aspirin ASP849Q flu 250 fever Output 100 200
 */
import java.util.Arrays;
import java.util.Scanner;

public class sasasa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Medicine[] mediArray = new Medicine[4];
        for (int i = 0; i < 4; i++) {
            String medicineName = sc.nextLine();
            String batch = sc.nextLine();
            String diseasel = sc.nextLine();
            int price = sc.nextInt();

            mediArray[i] = new Medicine(medicineName, batch, diseasel, price);
            sc.nextLine();
        }
        String disease = sc.nextLine();
        sc.close();

        Integer[] result = getPriceByDisease(mediArray, disease);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static Integer[] getPriceByDisease(Medicine[] mediArray, String disease) {
        Integer[] result = new Integer[0];
        for (int i = 0; i < mediArray.length; i++) {
            if (mediArray[i].getDiseasel().equalsIgnoreCase(disease)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = mediArray[i].getPrice();
            }
            Arrays.sort(result);
        }
        return result;

    }
}

class Medicine {

    String medicineName;
    String batch;
    String diseasel;
    int price;

    public Medicine(String medicineName, String batch, String diseasel, int price) {
        this.medicineName = medicineName;
        this.batch = batch;
        this.diseasel = diseasel;
        this.price = price;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDiseasel() {
        return diseasel;
    }

    public void setDiseasel(String diseasel) {
        this.diseasel = diseasel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
