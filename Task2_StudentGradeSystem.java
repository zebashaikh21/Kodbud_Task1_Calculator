import java.util.Scanner;

class Student {
    String name;
    double[] marks = new double[3];
    double average;
    char grade;

    Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
        calculateAverage();
        assignGrade();
    }

    void calculateAverage() {
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        average = sum / marks.length;
    }

    void assignGrade() {
        if (marks[0] < 40 || marks[1] < 40 || marks[2] < 40) {
            grade = 'F'; // Fail if any subject is below passing marks
        } else if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 40) {
            grade = 'C';
        } else {
            grade = 'F';
        }
    }

    void displayReport() {
        System.out.println("\n----- Student Report -----");
        System.out.println("Name: " + name);
        System.out.println("Subject 1: " + marks[0]);
        System.out.println("Subject 2: " + marks[1]);
        System.out.println("Subject 3: " + marks[2]);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Grade: " + (grade == 'F' ? "Fail" : grade));
        System.out.println("---------------------------");
    }
}

public class Task2_StudentGradeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(sc.nextLine());

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            double[] marks = new double[3];
            for (int j = 0; j < 3; j++) {
                System.out.print("Marks in Subject " + (j + 1) + ": ");
                marks[j] = Double.parseDouble(sc.nextLine());
            }

            students[i] = new Student(name, marks);
        }

        System.out.println("\n===== Final Reports =====");
        for (Student s : students) {
            s.displayReport();
        }

        sc.close();
    }
}
