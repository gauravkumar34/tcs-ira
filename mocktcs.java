import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class mocktcs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Project[] project = new Project[4];
        for (int i = 0; i < project.length; i++) {
            int projId = sc.nextInt();
            sc.nextLine();
            String projName = sc.nextLine();
            double projCost = sc.nextDouble();
            sc.nextLine();
            String technology1 = sc.nextLine();
            String technology2 = sc.nextLine();
            String technology3 = sc.nextLine();
            project[i] = new Project(projId, projName, projCost, technology1, technology2, technology3);
        }
        String projectName = sc.nextLine();
        sc.close();

        int getProctCount = findProjsCountForGivenTech(project, projectName);
        if (getProctCount > 0)
            System.out.println(getProctCount);
        else
            System.out.println("No Projects with this tech");

        Project pr = getProjectWithMaxCost(project);
        if (pr != null) {
            System.out.println(pr.getProjId() + "@" + pr.getProjName());
        } else {
            System.out.println("No Project");
        }
    }

    public static int findProjsCountForGivenTech(Project[] proArray, String tech) {
        int project = 0;
        for (int i = 0; i < proArray.length; i++) {
            if (proArray[i].getTechnology1().equalsIgnoreCase(tech)
                    || proArray[i].getTechnology2().equalsIgnoreCase(tech)
                    || proArray[i].getTechnology3().equalsIgnoreCase(tech)) {
                project++;
            }
        }
        return project;

    }

    public static Project getProjectWithMaxCost(Project[] proArray) {

        Project project = Arrays.stream(proArray).max(Comparator.comparing(Project::getProjCost)).orElse(null);
        return project;

    }
}

/**
 * Innermocktcs
 */
class Project {

    int projId;
    String projName;
    double projCost;
    String technology1;
    String technology2;
    String technology3;

    public Project(int projId, String projName, double projCost, String technology1, String technology2,
            String technology3) {
        this.projId = projId;
        this.projName = projName;
        this.projCost = projCost;
        this.technology1 = technology1;
        this.technology2 = technology2;
        this.technology3 = technology3;
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public double getProjCost() {
        return projCost;
    }

    public void setProjCost(double projCost) {
        this.projCost = projCost;
    }

    public String getTechnology1() {
        return technology1;
    }

    public void setTechnology1(String technology1) {
        this.technology1 = technology1;
    }

    public String getTechnology2() {
        return technology2;
    }

    public void setTechnology2(String technology2) {
        this.technology2 = technology2;
    }

    public String getTechnology3() {
        return technology3;
    }

    public void setTechnology3(String technology3) {
        this.technology3 = technology3;
    }

}