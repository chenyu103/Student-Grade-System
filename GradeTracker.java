
/* July 24 2026
 Changes: - improved Back Navigation 
 Hello future me! This is how you wrote code back then!
 I know you'll look at this code smiling and not cringing, lol!
 That's just who you are. You cherish and love every little part of you. 
 Even if its something to be embarressed, you just smiles genuinely because you've already accepted that part of you.
 And that is also how you love people around you. They're insecure about something, you accept their insecurities and says, 
 "That's what makes you unique to others. Don't avoid it, learn to accept it".
 Damn, it's getting long... That's it, future me! Always remember how and why you started, and you will never get lost. :>
*/


/*  Student Grade System v0.6 */
import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    public static String signIn(Scanner scan) {
        String name;

        System.out.print("Enter Student Name: ");
        name = scan.nextLine();
        return name;
    }

    public static void subjMenu(Scanner scan, ArrayList<String> menu, ArrayList<String> mathMenu, ArrayList<String> gradeListMenu, ArrayList<String> arList, ArrayList<String> inGradeListMenu)  throws InterruptedException {
        int chosen;
        
        showSubjMenu(menu);
        do {
            chosen = inputSubject(scan, menu);

            switch (chosen) {
                case 1:
                    System.out.println("You chose Mathematics!");
                    Thread.sleep(1000);
                    subjMath(scan, menu, mathMenu, gradeListMenu, arList, inGradeListMenu);
                    break;
                case 2:
                    System.out.println("You chose English!");
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("You chose Science!");
                    Thread.sleep(1000);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    Thread.sleep(1000);
                    break;
                default:
                    System.out.println("Invalid Input");
                    Thread.sleep(1000);
                    break;
            }
        } while (chosen != 4);
    }

    public static void showSubjMenu(ArrayList<String> menu) {
        System.out.println("\n===Subject Menu===");
        for(String subjects : menu) {
            System.out.println(subjects);
        }
    }

    public static ArrayList<String> subjectMenuList() {
        ArrayList<String> subjectMenu = new ArrayList<>();
        subjectMenu.add("1. Mathematics");
        subjectMenu.add("\n2. English");
        subjectMenu.add("\n3. Science");
        subjectMenu.add("\n4. Exit");
        return subjectMenu;
    }

    public static int inputSubject(Scanner scan, ArrayList<String> menu) throws InterruptedException {
        int choice;

        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input");
                Thread.sleep(1000);
                scan.next();
                continue;
            }

            choice = scan.nextInt();

            if (choice >= 1 && choice <= menu.size()) {
                return choice;
            }
            System.out.println("Please choose from 1 to " + menu.size());
        }
    }

    // for English

    // for Science

    public static void subjMath(Scanner scan, ArrayList<String> mainMenu, ArrayList<String> subjMenu, ArrayList<String> gradeListMenu, ArrayList<String> arList, ArrayList<String> inGradeListMenu) throws InterruptedException {
        int chosen;

        showSubjMath(subjMenu);
        do {
            chosen = inputMath(scan, subjMenu);

            switch (chosen) {
                case 1:
                    System.out.println("You chose Score Input!");
                    gradeList(scan, mainMenu, subjMenu, gradeListMenu, arList, inGradeListMenu);
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("You chose Academic Remarks!");
                    AR(scan, mainMenu, subjMenu, gradeListMenu, arList, inGradeListMenu);
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("Returning...");
                    Thread.sleep(1000);
                    return;
                default:
                    System.out.println("Invalid input");
                    Thread.sleep(1000);
                    break;
            }
        } while (chosen != subjMenu.size());
    }

    public static void showSubjMath(ArrayList<String> mathMenu) {
        System.out.println("\n====Math Menu====");
        for (String mathGradeMenu : mathMenu) {
            System.out.println(mathGradeMenu);
        }
    }

    public static ArrayList<String> subjMenuList() {
        ArrayList<String> mathList = new ArrayList<>();
        mathList.add("1. Grades List");
        mathList.add("\n2. Academic Remarks");
        mathList.add("\n3. Back");
        return mathList;
    }

    public static int inputMath(Scanner scan, ArrayList<String> mathMenu) throws InterruptedException {
        int choice;
        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input");
                Thread.sleep(1000);
                scan.next();
                continue;
            }

            choice = scan.nextInt();

            if (choice >= 1 && choice <= mathMenu.size()) {
                return choice;
            }
            System.out.println("Please choose from 1 to " + mathMenu.size() + "!");
            Thread.sleep(1000);
        }
    }

    public static void gradeList(Scanner scan, ArrayList<String> mainMenu, ArrayList<String> subjMenu, ArrayList<String> gradeListMenu, ArrayList<String> arList, ArrayList<String> inGradeListMenu)  throws InterruptedException {
        int chosen;

        do {
            showGradeList(scan, gradeListMenu);
            chosen = inputGradeList(scan, gradeListMenu);

            switch (chosen) {
                case 1:
                    System.out.println("You chose Quiz Score!");
                    Thread.sleep(1000);
                    inGradeList(scan, mainMenu, subjMenu, gradeListMenu, arList, inGradeListMenu);
                        break;
                case 2:
                    System.out.println("You chose Midterms Score!");
                    Thread.sleep(1000);
                        break;
                case 3:
                    System.out.println("You chose Finals Score!");
                    Thread.sleep(1000);
                        break;
                case 4:
                    System.out.println("Returning...");
                    Thread.sleep(1000);
                        return;
                default:
                    System.out.println("Invalid input");
                    Thread.sleep(1000);
                        break;
            }
        } while (chosen != gradeListMenu.size());
    }

    public static void showGradeList(Scanner scan, ArrayList<String> gradeListMenu) {
        System.out.println("\n====Grade List Menu====");
        for (String scoreInput : gradeListMenu) {
            System.out.println(scoreInput);
        }
    }

    public static ArrayList<String> gradeList_List() {
        ArrayList<String> scoreInputMenu = new ArrayList<>();
        scoreInputMenu.add("1. Quiz Score");
        scoreInputMenu.add("\n2. Midterms Score");
        scoreInputMenu.add("\n3. Finals Score");
        scoreInputMenu.add("\n4. Back");
        return scoreInputMenu;
    }

    public static int inputGradeList(Scanner scan, ArrayList<String> gradeListMenu) throws InterruptedException {
        int choice;

        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input");
                Thread.sleep(1000);
                continue;
            }
        
            choice = scan.nextInt();

            if (choice >= 1 && choice <= gradeListMenu.size()) {
                return choice;
            }
            System.out.println("Please choose from 1 to " + gradeListMenu.size() + "!");
        }
    }

    // for Quiz Score
    public static void inGradeList(Scanner scan, ArrayList<String> mainMenu, ArrayList<String> subjMenu, ArrayList<String> gradeListMenu, ArrayList<String> arList, ArrayList<String> inGradeListMenu) throws InterruptedException {
        int chosen;

        do {
            chosen = inputInGradeList(scan, inGradeListMenu);

            switch (chosen) {
                case 1:
                    System.out.println("You chose Input Score!");
                    Thread.sleep(1000);
                        break;
                case 2:
                    System.out.println("You chose Input History!");
                    Thread.sleep(1000);
                        break;
                case 3:
                    System.out.println("Returning...");
                    Thread.sleep(1000);
                        return;
                default:
                    System.out.println("Invalid input");
                    Thread.sleep(1000);
                        break;
            }

        } while (chosen != inGradeListMenu.size());
    }

    public static void showInGradeList() {
        System.out.println("\n====Quiz Score====");
    }
    
    public static ArrayList<String> inGradeList_List() {
        ArrayList<String> quizScore = new ArrayList<>();
        quizScore.add("1. Input Score");
        quizScore.add("\n2. Input History");
        quizScore.add("\n3. Back");
        return quizScore;
    }

    public static int inputInGradeList(Scanner scan, ArrayList<String> inGradeListMenu) throws InterruptedException {
        int choice;

        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input");
                Thread.sleep(1000);
                continue;
            }

            choice = scan.nextInt();

            if (choice >=1 && choice <= inGradeListMenu.size()) {
            return choice;
            }
        }
        
    }

    // for Input Score

    // for Midterms Score

    // for Finals Score

    public static void AR(Scanner scan, ArrayList<String> menu, ArrayList<String> mathMenu, ArrayList<String> gradeListMenu, ArrayList<String> arList, ArrayList<String> inGradeListMenu) throws InterruptedException {
        int chosen;

        showAR(arList);
        do {
            chosen = inputShowAR(scan, arList);

            switch (chosen) {
                case 1:
                    System.out.println("Returning...");
                    Thread.sleep(1000);
                        return;
                default:
                    System.out.println("Invalid input");
                        break;
            }

        } while (chosen != arList.size());
    }

    public static void showAR(ArrayList<String> arList) throws InterruptedException {
            System.out.println("\n====Academic Remarks====");
            System.out.println("      100 - 95 = +A        ");
            System.out.println("       94 - 90 = A        ");
            System.out.println("       89 - 85 = +B        ");
            System.out.println("       84 - 80 = B        ");
            System.out.println("       79 - 75 = +C        ");
            System.out.println("       74 - 70 = C        ");
            System.out.println("       69 - 65 = +D        ");
            System.out.println("       64 - 60 = D        ");
            System.out.println("      59 below = F        ");
            for (String showAR : arList) {
                System.out.println(showAR);
            }
    }

    public static ArrayList<String> showARList() {
        ArrayList<String> showARList = new ArrayList<>();
        showARList.add("1. Back");
        return showARList;
    }

    public static int inputShowAR(Scanner scan, ArrayList<String> arList) {
        int choice;
        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("Invalid Input");
                continue;
            }

            choice = scan.nextInt();

            if (choice >= 1 && choice <= arList.size()) {
                return choice;
            }
            System.out.println("Please choose from 1 to " + arList.size() + "!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        String student = signIn(scan);
        ArrayList<String> mainMenu = subjectMenuList();
        ArrayList<String> subjMenu = subjMenuList();
        ArrayList<String> gradeListMenu = gradeList_List();
        ArrayList<String> arList = showARList();
        ArrayList<String> inGradeListMenu = inGradeList_List();

        System.out.println("Hello " + student + "!");
        subjMenu(scan, mainMenu, subjMenu, gradeListMenu, arList, inGradeListMenu);
    }
}
