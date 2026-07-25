// July 25 2026
/*
=========================================
Student Grade System v0.7
Refactoring & Menu System Update
=========================================

Changes:
✔ Organized the entire source code into logical sections
  - Student Sign In
  - Subjects Menu
  - Menu Inside Subjects
  - User Input
  - Grade List Menu
  - Scores Menu
  - Academic Remarks
  - Main Method

✔ Renamed methods for better readability and consistency
  - subjectMenuList()      -> createSubjectsMenu()
  - inSpecificSubjMenuList() -> createInSubjectsMenu()
  - gradeList_List()       -> createGradeList()
  - inScoresList()         -> createScoresMenu()
  - showARList()           -> createARMenu()

✔ Improved naming convention
  - Changed "show" methods to only display menus.
  - Changed "create" methods to only create and return menu data.

✔ Removed duplicate Subject methods
  - Removed subjMath()
  - Removed subjEnglish()
  - Removed subjScience()
  - Replaced with a single reusable inSubjectsMenu().

✔ Removed duplicate Score methods
  - Removed quizScore()
  - Removed midtermScore()
  - Removed finalScore()
  - Replaced with a single reusable scoresMenu().

✔ Simplified menu header handling
  - Menu headers are now printed from the switch statement before calling
    the reusable menu methods.

✔ Improved code reusability
  - Reused inputChosen() for all menu input validation.
  - Reused inSubjectsMenu() for every subject.
  - Reused scoresMenu() for Quiz, Midterm, and Final Score menus.

✔ Fixed Back Navigation
  - Menus are displayed inside their loops so returning from a submenu
    correctly redraws the previous menu.

✔ Refactored overall project structure
  - Reduced duplicated code.
  - Improved readability.
  - Easier to maintain and expand for future features.

Next Goals:
- Implement Input Score feature.
- Store scores using ArrayLists.
- Display Score List.
- Compute Score Average.
- Implement Grade Equivalent computation.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    // ============================================================================================================================================================================
    // Student Sign In

    public static String signIn(Scanner scan) {
        String name;

        System.out.print("Enter Student Name: ");
        name = scan.nextLine();
        return name;
    }

    // ============================================================================================================================================================================
    // Subjects Menu

    public static void subjectsMenu(Scanner scan, ArrayList<String> mainSubjMenu, ArrayList<String> subjMenu, ArrayList<String> gradeListMenu, ArrayList<String> arList, ArrayList<String> inGradeListMenu)  throws InterruptedException {
        int chosen;
        
        
        do {
            showSubjectsMenu(mainSubjMenu);
            chosen = inputChosen(scan, mainSubjMenu);

            switch (chosen) {
                case 1:
                    System.out.println("You chose Mathematics!");
                    Thread.sleep(1000);
                    System.out.println("\n====Math Menu====");
                    inSubjectsMenu(scan, subjMenu, gradeListMenu, arList, inGradeListMenu);
                    break;
                case 2:
                    System.out.println("You chose English!");
                    Thread.sleep(1000);
                    System.out.println("\n====English Menu====");
                    inSubjectsMenu(scan, subjMenu, gradeListMenu, arList, inGradeListMenu);
                    break;
                case 3:
                    System.out.println("You chose Science!");
                    Thread.sleep(1000);
                    System.out.println("\n====Science Menu====");
                    inSubjectsMenu(scan, subjMenu, gradeListMenu, arList, inGradeListMenu);
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

    public static void showSubjectsMenu(ArrayList<String> menu) {
        System.out.println("\n===Subject Menu===");
        for(String subjects : menu) {
            System.out.println(subjects);
        }
    }

    public static ArrayList<String> createSubjectsMenu() {
        ArrayList<String> subjectMenu = new ArrayList<>();
        subjectMenu.add("1. Mathematics");
        subjectMenu.add("\n2. English");
        subjectMenu.add("\n3. Science");
        subjectMenu.add("\n4. Exit");
        return subjectMenu;
    }

    // ============================================================================================================================================================================
    // Menu Inside of Subjects

    public static void inSubjectsMenu(Scanner scan, ArrayList<String> subjMenu, ArrayList<String> gradeListMenu, ArrayList<String> arList, ArrayList<String> inGradeListMenu) throws InterruptedException {
        int chosen;

        do {
            showInSubjectsMenu(subjMenu);
            chosen = inputChosen(scan, subjMenu);

            switch (chosen) {
                case 1:
                    System.out.println("You chose Grade List!");
                    Thread.sleep(1000);
                    gradeList(scan, gradeListMenu, inGradeListMenu);
                    break;
                case 2:
                    System.out.println("You chose Grade Equivalent!");
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("You chose Academic Remarks!");
                    Thread.sleep(1000);
                    ARMenu(scan, arList);
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
        } while (chosen != subjMenu.size());
    }

    public static void showInSubjectsMenu(ArrayList<String> subjMenu) {
        for (String subjGradeMenu : subjMenu) {
            System.out.println(subjGradeMenu);
        }
    }

    public static ArrayList<String> createInSubjectsMenu() {
        ArrayList<String> subjMenuList = new ArrayList<>();
        subjMenuList.add("1. Grades List");
        subjMenuList.add("\n2. Grades Equivalent");
        subjMenuList.add("\n3. Academic Remarks");
        subjMenuList.add("\n4. Back");
        return subjMenuList;
    }

    // ============================================================================================================================================================================
    // User Input

    public static int inputChosen(Scanner scan, ArrayList<String> subjMenu) throws InterruptedException {
        int choice;
        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input");
                Thread.sleep(1000);
                scan.next();
                continue;
            }

            choice = scan.nextInt();

            if (choice >= 1 && choice <= subjMenu.size()) {
                return choice;
            }
            System.out.println("Please choose from 1 to " + subjMenu.size() + "!");
            Thread.sleep(1000);
        }
    }

    // ============================================================================================================================================================================
    // Grade List Menu

    public static void gradeList(Scanner scan, ArrayList<String> gradeListMenu, ArrayList<String> inGradeListMenu)  throws InterruptedException {
        int chosen;

        do {
            showGradeList(scan, gradeListMenu);
            chosen = inputChosen(scan, gradeListMenu);

            switch (chosen) {
                case 1:
                    System.out.println("You chose Quiz Score!");
                    Thread.sleep(1000);
                    System.out.println("\n====Quiz Score====");
                    scoresMenu(scan, inGradeListMenu);
                        break;
                case 2:
                    System.out.println("You chose Midterm Score!");
                    Thread.sleep(1000);
                    System.out.println("\n====Midterm Score Menu====");
                    scoresMenu(scan, inGradeListMenu);
                        break;
                case 3:
                    System.out.println("You chose Final Score!");
                    Thread.sleep(1000);
                    System.out.println("\n====Final Score Menu====");
                    scoresMenu(scan, inGradeListMenu);
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

    public static ArrayList<String> createGradeList() {
        ArrayList<String> scoreInputMenu = new ArrayList<>();
        scoreInputMenu.add("1. Quiz Score");
        scoreInputMenu.add("\n2. Midterm Score");
        scoreInputMenu.add("\n3. Final Score");
        scoreInputMenu.add("\n4. Back");
        return scoreInputMenu;
    }
    
    // ============================================================================================================================================================================
    // Scores Menu

    public static void scoresMenu(Scanner scan, ArrayList<String> inGradeList) throws InterruptedException {
        int chosen;

        
        do {
            showScoresMenu(inGradeList);
            chosen = inputChosen(scan, inGradeList);

            switch (chosen) {
                case 1:
                    System.out.println("You chose Input Score!");
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("You chose Score List!");
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("You chose Score Average!");
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
        } while (chosen != inGradeList.size());

    }

    public static void showScoresMenu(ArrayList<String> inGradeList) {
        for (String scoresMenu : inGradeList) {
            System.out.println(scoresMenu);
        }
    }
    
    public static ArrayList<String> createScoresMenu() {
        ArrayList<String> quizScore = new ArrayList<>();
        quizScore.add("1. Input Score");
        quizScore.add("\n2. Score List");
        quizScore.add("\n3. Scores Average");
        quizScore.add("\n4. Back");
        return quizScore;
    }

    // ============================================================================================================================================================================
    // Academic Remarks 

    public static void ARMenu(Scanner scan, ArrayList<String> arList) throws InterruptedException {
        int chosen;

        
        do {
            showARMenu(arList);
            chosen = inputChosen(scan, arList);

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

    public static void showARMenu(ArrayList<String> arList) throws InterruptedException {
            System.out.println("\n          ====Academic Remarks====                ");
            System.out.println("           +A = Exceptional Performance             ");
            System.out.println("            A = Excellent Performance               ");
            System.out.println("           -A = Near Excellent Performance          ");
            System.out.println("           +B = Above Average Performance           ");
            System.out.println("            B = Good Performance                    ");
            System.out.println("           -B = Slightly Above Average Performance  ");
            System.out.println("           +C = Decent Performance                  ");
            System.out.println("            C = Average / Satisfactory Performance  ");
            System.out.println("           -C = Below Average Performance           ");
            System.out.println("           +D = Struggling Performance              ");
            System.out.println("            D = Poor / Barely Passing Performance   ");
            System.out.println("           -D = Minimally Passing Performance       ");
            System.out.println("            F = Failing / Unsatisfactory Performance");
            for (String showAR : arList) {
                System.out.println(showAR);
            }
    }

    public static ArrayList<String> createARMenu() {
        ArrayList<String> showARList = new ArrayList<>();
        showARList.add("1. Back");
        return showARList;
    }

    // ============================================================================================================================================================================
    // Main();

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        String student = signIn(scan);
        ArrayList<String> subjectsMenu = createSubjectsMenu();
        ArrayList<String> inSubjMenu = createInSubjectsMenu();
        ArrayList<String> gradeListMenu = createGradeList();
        ArrayList<String> ARMenu = createARMenu();
        ArrayList<String> scoresMenu = createScoresMenu();

        System.out.println("Hello " + student + "!");
        subjectsMenu(scan, subjectsMenu, inSubjMenu, gradeListMenu, ARMenu, scoresMenu);
    }

    // ============================================================================================================================================================================
}