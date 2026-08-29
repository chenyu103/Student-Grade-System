// August 29 2026
/*
=========================================
Student Grade System v0.8
Score Input & Student Record Update
=========================================

Changes:
✔ Implemented the Input Score feature
  - Added inputScore()
  - Allows entering a student's name.
  - Allows entering the student's score.
  - Calculates the student's grade percentage.
  - Determines the corresponding letter grade.
  - Displays the complete score result.

✔ Added Perfect Score input and validation
  - Added getPerfectScore()
  - Added perfectScoreValidation()
  - Perfect score must be greater than 0.
  - Perfect score is limited to a maximum of 200.
  - Added support for reusing the previous perfect score.

✔ Added Student Name input and validation
  - Added getStudentName()
  - Added studentNameValidation()
  - Prevents blank student names.
  - Stores student names using ArrayList.

✔ Added Student Score input and validation
  - Added getStudentScore()
  - Added scoreValidation()
  - Prevents invalid score input.
  - Score must be within the valid range of 0 up to the perfect score.
  - Stores student scores using ArrayList.

✔ Added Grade Percentage calculation
  - Added scoreConvertionToGrade()
  - Converts the student's score into a percentage.
  - Uses the formula:
    (student score / perfect score) × 100
  - Stores the calculated grade percentage.

✔ Implemented Letter Grade conversion
  - Added letterGrade()
  - Converts the grade percentage into the corresponding letter grade.
  - Supports:
    +A, A, -A
    +B, B, -B
    +C, C, -C
    +D, D, -D
    F
  - Stores letter grades using ArrayList.

✔ Added Student Records
  - Added studentRecord()
  - Stores the complete score result in an ArrayList.
  - Displays the student's:
    - Name
    - Score
    - Perfect Score
    - Grade Percentage
    - Letter Grade

✔ Added separate ArrayLists for student data
  - studentNameRecord
  - studentScoreRecord
  - studentGradeRecord
  - letterGradeRecord
  - perfectScoreRecord
  - studentRecord

✔ Added "Add Another Score" feature
  - Allows multiple student scores to be entered.
  - Asks whether the user wants to add another score.
  - Allows the user to reuse the previous perfect score.
  - Allows entering a new perfect score when needed.

✔ Improved Input Validation
  - Added reusable validation methods for:
    - Menu choices
    - Student names
    - Student scores
    - Perfect scores
    - Yes/No decisions
  - Prevents invalid values from being accepted.

✔ Improved Code Reusability
  - Reused inputScore() for Quiz, Midterm, and Final scores.
  - Reused scoresMenu() for all score categories.
  - Reused validation methods instead of duplicating input logic.
  - Reused letterGrade() for grade conversion.

✔ Expanded Scores Menu
  - Added "Input Score"
  - Added "Student's Record"
  - Added "Back"

✔ Added Grade Equivalent Menu
  - Displays the percentage ranges for each letter grade.
  - Added a Back option.

✔ Added Academic Remarks Menu
  - Displays the academic meaning of each letter grade.
  - Added a Back option.

✔ Improved Overall Project Structure
  - Continued the organized section-based structure from v0.7.
  - Added dedicated sections for:
    - Input Validation
    - Score Validation
    - Perfect Score Validation
    - Student Name Validation
    - Score and Name Retrieval
    - Grade Percentage Calculation
    - Boolean Input
    - Score Display
    - Student Records
    - Grade Equivalent
    - Letter Grade
    - Academic Remarks
  - Improved readability and maintainability.
  - Prepared the project for future grading features.

Next Goals:
- Improve Student Record organization.
- Separate records by subject.
- Separate records by Quiz, Midterm, and Final.
- Implement Grade Equivalent computation.
- Implement Academic Remarks computation.
- Compute averages and final grades.
- Improve the Student Record display.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    // ============================================================================================================================================================================
    // Student Sign In

    public static String signIn(Scanner scan) throws InterruptedException {
        String name;

        System.out.print("Enter your name: ");
        name = signInValidation(scan);
        return name;
    }

    public static String signInValidation(Scanner scan) throws InterruptedException {
        String name;

        while (true) {
            if (!scan.hasNextLine()) {
                System.out.println("\nInvalid input");
                Thread.sleep(1000);
                scan.next();
                continue;
            }
            
            name = scan.nextLine();

            if(!name.isBlank()) {
                return name;
            }
            System.out.println("\nPlease enter your name!");
            Thread.sleep(1000);
        }
    }

    // ============================================================================================================================================================================
    // Subjects Menu

    public static void subjectsMenu(Scanner scan, ArrayList<String> mainSubjMenu, ArrayList<String> subjMenu, ArrayList<String> gradeListMenu, ArrayList<String> arList, ArrayList<String> inGradeListMenu, ArrayList<String> gradeEquivalentMenu, ArrayList<String> studentNameRecord, ArrayList<Integer> studentScoreRecord, ArrayList<String> studentGradeRecord, ArrayList<String> asianGrading, ArrayList<String> letterGradeRecord, ArrayList<Integer> perfectScoreRecord, ArrayList<String> studentRecord)  throws InterruptedException {
        int chosen;
        
        
        do {
            showSubjectsMenu(mainSubjMenu);
            chosen = inputChosen(scan, mainSubjMenu);

            switch (chosen) {
                case 1:
                    System.out.println("\nYou chose Mathematics!");
                    Thread.sleep(1000);
                    inSubjectsMenu("\n====Math Menu====",scan, subjMenu, gradeListMenu, arList, inGradeListMenu, gradeEquivalentMenu, studentNameRecord, studentScoreRecord, studentGradeRecord, asianGrading, letterGradeRecord, perfectScoreRecord, studentRecord);
                    break;
                case 2:
                    System.out.println("\nYou chose English!");
                    Thread.sleep(1000);
                    inSubjectsMenu("\n====English Menu====",scan, subjMenu, gradeListMenu, arList, inGradeListMenu, gradeEquivalentMenu, studentNameRecord, studentScoreRecord, studentGradeRecord, asianGrading, letterGradeRecord, perfectScoreRecord, studentRecord);
                    break;
                case 3:
                    System.out.println("\nYou chose Science!");
                    Thread.sleep(1000);
                    inSubjectsMenu("\n====Science Menu====", scan, subjMenu, gradeListMenu, arList, inGradeListMenu, gradeEquivalentMenu, studentNameRecord, studentScoreRecord, studentGradeRecord, asianGrading, letterGradeRecord, perfectScoreRecord, studentRecord);
                    break;
                case 4:
                    System.out.println("\nExiting...");
                    Thread.sleep(1000);
                    break;
                default:
                    System.out.println("\nInvalid Input");
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

    public static void inSubjectsMenu(String Title, Scanner scan, ArrayList<String> subjMenu, ArrayList<String> gradeListMenu, ArrayList<String> arList, ArrayList<String> inGradeListMenu, ArrayList<String> gradeEquivalentMenu, ArrayList<String> studentNameRecord, ArrayList<Integer> studentScoreRecord, ArrayList<String> studentGradeRecord, ArrayList<String> asianGrading, ArrayList<String> letterGradeRecord, ArrayList<Integer> perfectScoreRecord, ArrayList<String> studentRecord) throws InterruptedException {
        int chosen;

        do {
            System.out.println(Title);
            showInSubjectsMenu(subjMenu);
            chosen = inputChosen(scan, subjMenu);

            switch (chosen) {
                case 1:
                    System.out.println("\nYou chose Grade List!");
                    Thread.sleep(1000);
                    gradeList(scan, gradeListMenu, inGradeListMenu, studentNameRecord, studentScoreRecord, studentGradeRecord, asianGrading, letterGradeRecord, perfectScoreRecord, studentRecord);
                    break;
                case 2:
                    System.out.println("\nYou chose Grade Equivalent!");
                    Thread.sleep(1000);
                    gradeEquivalent(scan, gradeEquivalentMenu);
                    break;
                case 3:
                    System.out.println("\nYou chose Academic Remarks!");
                    Thread.sleep(1000);
                    ARMenu(scan, arList);
                    break;
                case 4:
                    System.out.println("\nReturning...");
                    Thread.sleep(1000);
                    return;
                default:
                    System.out.println("\nInvalid input");
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
                System.out.println("\nInvalid input");
                Thread.sleep(1000);
                scan.next();
                continue;
            }

            choice = scan.nextInt();

            if (choice >= 1 && choice <= subjMenu.size()) {
                return choice;
            }
            System.out.println("\nPlease choose from 1 to " + subjMenu.size() + "!");
            Thread.sleep(1000);
        }
    }

    // ============================================================================================================================================================================
    // Grade List Menu

    public static void gradeList(Scanner scan, ArrayList<String> gradeListMenu, ArrayList<String> inGradeListMenu, ArrayList<String> studentNameRecord, ArrayList<Integer> studentScoreRecord, ArrayList<String> studentGradeRecord, ArrayList<String> asianGrading, ArrayList<String> letterGradeRecord, ArrayList<Integer> perfectScoreRecord, ArrayList<String> studentRecord)  throws InterruptedException {
        int chosen;

        do {
            showGradeList(scan, gradeListMenu);
            chosen = inputChosen(scan, gradeListMenu);

            switch (chosen) {
                case 1:
                    System.out.println("\nYou chose Quiz Score!");
                    Thread.sleep(1000);
                    scoresMenu("\n====Quiz Score====", scan, inGradeListMenu, studentNameRecord, studentScoreRecord, studentGradeRecord, asianGrading, letterGradeRecord, perfectScoreRecord, studentRecord);
                        break;
                case 2:
                    System.out.println("\nYou chose Midterm Score!");
                    Thread.sleep(1000);
                    scoresMenu("\n====Midterm Score Menu====", scan, inGradeListMenu,studentNameRecord, studentScoreRecord, studentGradeRecord, asianGrading, letterGradeRecord, perfectScoreRecord, studentRecord);
                        break;
                case 3:
                    System.out.println("\nYou chose Final Score!");
                    scoresMenu("\n====Final Score Menu====", scan, inGradeListMenu, studentNameRecord, studentScoreRecord, studentGradeRecord, asianGrading, letterGradeRecord, perfectScoreRecord, studentRecord);
                        break;
                case 4:
                    System.out.println("\nReturning...");
                    Thread.sleep(1000);
                        return;
                default:
                    System.out.println("\nInvalid input");
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

    public static void scoresMenu(String Title, Scanner scan, ArrayList<String> inGradeList, ArrayList<String> studentNameRecord, ArrayList<Integer> studentScoreRecord, ArrayList<String> studentGradeRecord, ArrayList<String> asianGrading, ArrayList<String> letterGradeRecord, ArrayList<Integer> perfectScoreRecord, ArrayList<String> studentRecord) throws InterruptedException {
        int chosen;
        
        do {
            System.out.println(Title);
            showScoresMenu(inGradeList);
            chosen = inputChosen(scan, inGradeList);
            int perfectScore = 0;

            switch (chosen) {
                case 1:
                    System.out.println("\nYou chose Input Score!");
                    Thread.sleep(1000);

                    if (perfectScore == 0) {
                        perfectScore = getPerfectScore(scan);
                        perfectScoreRecord.add(perfectScore);


                    }

                    boolean addAnother = inputScore(Title, scan, perfectScore, studentNameRecord, studentScoreRecord, studentGradeRecord, asianGrading, letterGradeRecord, studentRecord);

                    while (addAnother) {
                        Thread.sleep(1000);
                        System.out.print("\nWill you use the previous perfect score? (yes/no): ");

                        boolean reuse = inputBoolean(scan);

                        if(!reuse) {
                            perfectScore = getPerfectScore(scan);
                        }

                        addAnother = inputScore(Title, scan,  perfectScore, studentNameRecord, studentScoreRecord, studentGradeRecord, asianGrading, letterGradeRecord, studentRecord);
                        perfectScoreRecord.add(perfectScore);
                    }
                    break;
                case 2:
                    System.out.println("\nYou chose Student's Record!");
                    studentRecord("====Student's Records====", studentRecord);
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("\nReturning...");
                    Thread.sleep(1000);
                    return;
                default:
                    System.out.println("\nInvalid input");
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
        quizScore.add("\n2. Student's Record");
        quizScore.add("\n3. Back");
        return quizScore;
    }

    // ============================================================================================================================================================================
    // Input Score Validator & Input Range

    public static int scoreValidation(Scanner scan,  double max) throws InterruptedException {
        int score;

        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("\nInvalid input");
                scan.next();
                continue;
            }
            score = scan.nextInt();

            if (score >= 0 && score <= max) {
                return score;
            }
            System.out.println("\nInvalid number");
            Thread.sleep(1000);
        }
    }

    // ============================================================================================================================================================================
    // Input Perfect Score Validator & Input Range

    public static int perfectScoreValidation(Scanner scan) throws InterruptedException {
        int perfectScore;

        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("\nInvalid input");
                scan.next();
                continue;
            }

            perfectScore = scan.nextInt();

            if (perfectScore > 0 && perfectScore <= 200) {
                return perfectScore;
            }
            System.out.println("\nInvalid number");
            Thread.sleep(1000);
        }
    }

    // ============================================================================================================================================================================
    // Input Student Name Validator

    public static String studentNameValidation(Scanner scan) throws InterruptedException {
        String name;

        while (true) {
            if (!scan.hasNextLine()) {
                System.out.println("\nInvalid input");
                Thread.sleep(1000);
                scan.next();
                continue;
            }
            
            name = scan.nextLine();

            if(!name.isBlank()) {
                return name;
            }
        }
    }



    // ============================================================================================================================================================================
    // Get Student Name, Score & Perfect Score

    public static int getStudentScore(Scanner scan, double max, ArrayList<Integer> studentScoreRecord) throws InterruptedException {
         int score;

         while (true) {
            Thread.sleep(1000);
            System.out.print("\nEnter score: ");
            score = scoreValidation(scan, max);
            studentScoreRecord.add(score);
            return score;
         }
    }

    public static int getPerfectScore(Scanner scan) throws InterruptedException {
        int perfectScore;

        while (true) {
            Thread.sleep(1000);
            System.out.print("\nEnter perfect score: ");
            perfectScore = perfectScoreValidation(scan);
            return perfectScore;
        }
    }

    public static String getStudentName(Scanner scan, ArrayList<String> studentNameRecord) throws InterruptedException {
        String name;

        while (true) {
            Thread.sleep(1000);
            System.out.print("\nEnter the student's name: ");
            name = studentNameValidation(scan);
            studentNameRecord.add(name);
            return name;
        }
    }

    // ============================================================================================================================================================================
    // Calculation of Score to Grade %

    public static double scoreConvertionToGrade(int score, int max, ArrayList<String> studentGradeRecord) throws InterruptedException {
        double actualGrade = ((double) score / max) * 100;
        studentGradeRecord.add("\nGrade %: " + actualGrade);
        return actualGrade;
    }

    // ============================================================================================================================================================================
    // Input Boolean (yes/no)

    public static boolean inputBoolean(Scanner scan) throws InterruptedException {
        String decision;
        boolean choice = false;

        while (true) {
            if (!scan.hasNext()) {
                System.out.println("Invalid input");
                Thread.sleep(1000);
                scan.next();
                continue;
            }

            decision = scan.next();

            if (decision.equalsIgnoreCase("yes")) {
                return true;
            } else if (decision.equalsIgnoreCase("no")) {
                return choice;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
    // ============================================================================================================================================================================
    // Display of Input Score

    public static boolean inputScore(String Title, Scanner scan, int max, ArrayList<String> studentNameRecord, ArrayList<Integer> studentScoreRecord, ArrayList<String> studentGradeRecord, ArrayList<String> asianGrading, ArrayList<String> letterGradeRecord, ArrayList<String> studentRecord) throws InterruptedException {
        boolean choice = false;
        String name = getStudentName(scan, studentNameRecord);
        int studentScore = getStudentScore(scan, max, studentScoreRecord);
        double evaluation = scoreConvertionToGrade(studentScore, max, studentGradeRecord);
        String letter = letterGrade(scan, evaluation, asianGrading, letterGradeRecord);

        System.out.println("\n" + Title + "\nStudent Name: " + name + 
                           "\nScore: " + studentScore + 
                           "\nPerfect Score: " + max + 
                           "\nGrade %: " + evaluation +
                           "\nLetter Grade: " + letter);
                           studentRecord.add("\n" + Title + "\nStudent Name: " + name + 
                           "\nScore: " + studentScore + 
                           "\nPerfect Score: " + max + 
                           "\nGrade %: " + evaluation +
                           "\nLetter Grade: " + letter);
        
        while (true) {
            System.out.print("\nWill you add another score? (yes/no): ");
            choice = inputBoolean(scan);
            return choice;
        }
    }

    // ============================================================================================================================================================================
    // Student's Record

    public static ArrayList<String> createStudentNameRecord() {
        ArrayList<String> studentName = new ArrayList<>();
        return studentName;
    }

    public static ArrayList<Integer> createStudentScoreRecord() {
        ArrayList<Integer> studentScore = new ArrayList<>();
        return studentScore;
    }

    public static ArrayList<String> createStudentGradeRecord() {
        ArrayList<String> studentGrade = new ArrayList<>();
        return studentGrade;
    }

    public static ArrayList<Integer> createPerfectScoreRecord() {
        ArrayList<Integer> maxScore = new ArrayList<>();
        return maxScore;
    }

    public static ArrayList<String> createStudentRecord() {
        ArrayList<String> studentRecord = new ArrayList<>();
        return studentRecord;
    }

    public static void studentRecord(String Title, ArrayList<String> studentRecord) {
        System.out.println(Title);
        for (int i = 0; i < studentRecord.size(); i++) {
            //System.out.println("\nName: " + name.get(i) + "\nPerfect Score: " + perfectScoreRecord.get(i) + "\nScore: " + score.get(i) + "\nGrade %: " + grade.get(i) + "\nLetter Grade: " + letterGrade.get(i));
            System.out.println(studentRecord.get(i));
        }
    }

    // ============================================================================================================================================================================
    // Grade Equivalent Menu

    public static void gradeEquivalent(Scanner scan, ArrayList<String> gradeEquivalentMenu) throws InterruptedException {
        int chosen;

        do {
            showGradeEquivalentMenu(gradeEquivalentMenu);
            chosen = inputChosen(scan, gradeEquivalentMenu);

            switch (chosen) {
                case 1:
                    System.out.println("Returning...");
                    Thread.sleep(1000);
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (chosen != gradeEquivalentMenu.size());
    }

    public static void showGradeEquivalentMenu(ArrayList<String> gradeEquivalentMenu) {
        System.out.println("====Grade Equivalent====");
        System.out.println("    97 - 99 = +A    ");
        System.out.println("    93 - 96 = A     ");
        System.out.println("    90 - 92 = -A    ");
        System.out.println("    87 - 89 = +B    ");
        System.out.println("    83 - 86 = B     ");
        System.out.println("    80 - 82 = -B    ");
        System.out.println("    77 - 79 = +C    ");
        System.out.println("    73 - 76 = C     ");
        System.out.println("    70 - 72 = -C    ");
        System.out.println("    67 - 69 = +D    ");
        System.out.println("    63 - 66 = D     ");
        System.out.println("    60 - 62 = -D    ");
        System.out.println("     Below 60.0 = F     ");
        for (String gradeEquivalent : gradeEquivalentMenu) {
            System.out.println(gradeEquivalent);
        }
    }

    public static ArrayList<String> createGradeEquivalentMenu() {
        ArrayList<String> gradeEquivalent = new ArrayList<>();
        gradeEquivalent.add("1. Back");
        return gradeEquivalent;
    }

    // ============================================================================================================================================================================
    // Letter Grade

    public static String letterGrade(Scanner scan, double grade, ArrayList<String> asianGrading, ArrayList<String> letterGradeRecord) {
        ArrayList<String> letterGrade = asianGrading;
        double studentGrade = grade;

        while (true) {
            if (studentGrade >= 97) {
                letterGradeRecord.add(letterGrade.get(0));
                return letterGrade.get(0);
            } else if (studentGrade >= 93) {
                letterGradeRecord.add(letterGrade.get(1));
                return letterGrade.get(1);
            } else if (studentGrade >= 90) {
                letterGradeRecord.add(letterGrade.get(2));
                return letterGrade.get(2);
            } else if (studentGrade >= 87) {
                letterGradeRecord.add(letterGrade.get(3));
                return letterGrade.get(3);
            } else if (studentGrade >= 83) {
                letterGradeRecord.add(letterGrade.get(4));
                return letterGrade.get(4);
            } else if (studentGrade >= 80) {
                letterGradeRecord.add(letterGrade.get(5));
                return letterGrade.get(5);
            } else if (studentGrade >= 77) {
                letterGradeRecord.add(letterGrade.get(6));
                return letterGrade.get(6);
            } else if (studentGrade >= 73) {
                letterGradeRecord.add(letterGrade.get(7));
                return letterGrade.get(7);
            } else if (studentGrade >= 70) {
                letterGradeRecord.add(letterGrade.get(8));
                return letterGrade.get(8);
            } else if (studentGrade >= 67) {
                letterGradeRecord.add(letterGrade.get(9));
                return letterGrade.get(9);
            } else if (studentGrade >= 63) {
                letterGradeRecord.add(letterGrade.get(10));
                return letterGrade.get(10);
            } else if (studentGrade >= 60) {
                letterGradeRecord.add(letterGrade.get(11));
                return letterGrade.get(11);
            } else if (studentGrade <= 59) {
                letterGradeRecord.add(letterGrade.get(12));
                return letterGrade.get(12);
            } else {
                System.out.println("Invalid input");
                scan.next();
                continue;
            }
        }
    }

    public static ArrayList<String> createLetterGrade() {
        ArrayList<String> letterGrade = new ArrayList<>();
        letterGrade.add("+A");
        letterGrade.add("A");
        letterGrade.add("-A");
        letterGrade.add("+B");
        letterGrade.add("B");
        letterGrade.add("-B");
        letterGrade.add("+C");
        letterGrade.add("C");
        letterGrade.add("-C");
        letterGrade.add("+D");
        letterGrade.add("D");
        letterGrade.add("-D");
        letterGrade.add("F");
        return letterGrade;
    }

    public static ArrayList<String> createLetterGradeRecord() {
        ArrayList<String> letterGradeRecord = new ArrayList<>();
        return letterGradeRecord;
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

        String user = signIn(scan);
        ArrayList<String> subjectsMenu = createSubjectsMenu();
        ArrayList<String> inSubjMenu = createInSubjectsMenu();
        ArrayList<String> gradeListMenu = createGradeList();
        ArrayList<String> ARMenu = createARMenu();
        ArrayList<String> scoresMenu = createScoresMenu();
        ArrayList<String> gradeEquivalentMenu = createGradeEquivalentMenu();
        ArrayList<String> studentNameRecord = createStudentNameRecord();
        ArrayList<Integer> studentScoreRecord = createStudentScoreRecord();
        ArrayList<String> studentGradeRecord = createStudentGradeRecord();
        ArrayList<String> letterGrade = createLetterGrade();
        ArrayList<String> letterGradeRecord = createLetterGradeRecord();
        ArrayList<Integer> perfectScoreRecord = createPerfectScoreRecord();
        ArrayList<String> studentRecord = createStudentRecord();

        System.out.println("\nHello " + user + "!");
        subjectsMenu(scan, subjectsMenu, inSubjMenu, gradeListMenu, ARMenu, scoresMenu, gradeEquivalentMenu, studentNameRecord, studentScoreRecord, studentGradeRecord, letterGrade, letterGradeRecord, perfectScoreRecord, studentRecord);
    }

    // ============================================================================================================================================================================
}