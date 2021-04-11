
/**
 * Create a class AutonomousCar with the below attributes:
carld – int
brand – String noOfTestsConducted – int
noOfTestsPassed- int
environment – String
grade – String

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence except grade.

Create class Solution with main method. Implement two static methods – findTestPassedByEnv and updateCarGrade in Solution class.

findTestPassedByEnv method:

This method will take two input parameters -array of AutonomousCar objects and string parameter environment. The method will return the sum of the noOfTestsPassed attribute from autonomousCar objects for the environment passed as parameter. If no autonomousCar with the given environment is present in the array of AutonomousCar objects, then the method should return 0.

updateCarGrade method:

This method will take a String parameter brand, along with the array of AutonomousCar objects. The method will return the autonomousCar object, if the input String parameter matches with the brand attribute of the autonomousCar object. Before returning the object, the grade should be derived based on the rating calculation mentioned below. This grade value should be assigned to the object. If any of the above conditions are not met, then the method should return null. The grade attribute should be calculated as follows: rating .(noOfTestsPassed * 100)/noOfTestsConducted If the rating > = 80 then grade should be ‘A1’, otherwise the grade should be ‘B2’.

The above mentioned static methods should be called from the main method. For findTestPassedByEnv method – The main method should print the totalTestPassed as it is, if the returned value is greater than 0, or it should print “There are no tests passed in this particular environment”.

For updateCarGrade method – The main method should print the brand and grade of the returned autonomousCar object. The brand and grade should be concatinated with :: while printing. eg:- Tesla::A1, where Tesla is the brand and Al is the grade.

If the returned value is null then it should print “No Car is available with the specified brand”. Before calling these static methods in main, use Scanner object to read the values of four autonomousCar objects referring attributes in the above mentioned attribute sequence (except grade attribute). Next, read the value for environment and brand.

Input
100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez
Output
1900
Mercedez::B2
 */
import java.util.Scanner;

public class mock {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AutonomousCar[] autoArray = new AutonomousCar[4];
        for (int i = 0; i < 4; i++) {
            int cardId = sc.nextInt();
            sc.nextLine();
            String brand = sc.nextLine();
            int noOfTestsConducted = sc.nextInt();
            int noOfTestsPassed = sc.nextInt();
            sc.nextLine();
            String environment = sc.nextLine();
            autoArray[i] = new AutonomousCar(cardId, brand, noOfTestsConducted, noOfTestsPassed, environment);
        }
        String environment = sc.nextLine();
        String brand = sc.nextLine();
        sc.close();

        int findTestPassedByEnv = findTestPassedByEnv(autoArray, environment);
        if (findTestPassedByEnv > 0) {
            System.out.println(findTestPassedByEnv);
        } else {
            System.out.println("There are no tests passed in this particular environment");
        }

        AutonomousCar updatedData = updateCarGrade(autoArray, brand);
        if (updatedData != null) {
            System.out.println(updatedData.getBrand() + "::" + updatedData.getGrade());
        } else {
            System.out.println("No Car is available with the specified brand");
        }

    }

    public static int findTestPassedByEnv(AutonomousCar[] autonomousCarArray, String environment) {
        int sum = 0;
        for (int i = 0; i < autonomousCarArray.length; i++) {
            if (autonomousCarArray[i].getEnvironment().equalsIgnoreCase(environment)) {
                sum += autonomousCarArray[i].getNoOfTestsPassed();
            }

        }
        return sum;
    }

    public static AutonomousCar updateCarGrade(AutonomousCar[] autonomousCarArray, String brand) {

        for (int i = 0; i < autonomousCarArray.length; i++) {
            if (autonomousCarArray[i].getBrand().equalsIgnoreCase(brand)) {
                int rating = (autonomousCarArray[i].getNoOfTestsPassed() * 100)
                        / autonomousCarArray[i].getNoOfTestsConducted();
                if (rating >= 80) {
                    autonomousCarArray[i].setGrade("A1");
                } else {
                    autonomousCarArray[i].setGrade("B2");
                }
                return autonomousCarArray[i];
            }
        }
        return null;

    }
}

/**
 * AutonomousCar
 */
class AutonomousCar {
    int cardId;
    String brand;
    int noOfTestsConducted;
    int noOfTestsPassed;
    String environment;
    String grade;

    public AutonomousCar(int cardId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
        this.cardId = cardId;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoOfTestsConducted() {
        return noOfTestsConducted;
    }

    public void setNoOfTestsConducted(int noOfTestsConducted) {
        this.noOfTestsConducted = noOfTestsConducted;
    }

    public int getNoOfTestsPassed() {
        return noOfTestsPassed;
    }

    public void setNoOfTestsPassed(int noOfTestsPassed) {
        this.noOfTestsPassed = noOfTestsPassed;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}