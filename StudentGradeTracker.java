import java.util.ArrayList;
import java.util.Scanner;
public class StudentGradeTracker
 {
    private ArrayList<String> studentNames;
    private ArrayList<Double> studentGrades;
    private int numberOfStudents;
    public StudentGradeTracker(int numberOfStudents)
     {
        studentNames = new ArrayList<>();
        studentGrades = new ArrayList<>();
        this.numberOfStudents = numberOfStudents;
    }
    public void addStudent(String name, double grade)
     {
        studentNames.add(name);
        studentGrades.add(grade);
    }
    public double computeAverage()
     {
        if (studentGrades.size() == 0)
         {
            return 0;
        }
        double sum = 0;
        for (double grade : studentGrades)
         {
            sum += grade;
        }
        return sum / studentGrades.size();
    }
    public double findHighestGrade()
     {
        if (studentGrades.size() == 0) 
        {
            return 0;
        }
        double highest = studentGrades.get(0);
        for (double grade : studentGrades)
         {
            if (grade > highest)
             {
                highest = grade;
            }
        }
        return highest;
    }
    public double findLowestGrade() 
    {
        if (studentGrades.size() == 0)
         {
            return 0;
        }
        double lowest = studentGrades.get(0);
        for (double grade : studentGrades)
         {
            if (grade < lowest)
             {
                lowest = grade;
            }
        }
        return lowest;
    }
    public void displayStudentData()
     {
        System.out.println("Student Grades:");
        for (int i = 0; i < studentNames.size(); i++)
         {
            System.out.println(studentNames.get(i) + ": " + studentGrades.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int numberOfStudents;
        while (true)
         {
            try {
                numberOfStudents = Integer.parseInt(scanner.nextLine());
                if (numberOfStudents > 0)
                 {
                    break;
                }
                 else
                  {
                    System.out.println("Please enter a positive number for the number of students:");
                }
            } 
            catch (NumberFormatException e)
             {
                System.out.println("Invalid input. Please enter a valid number for the number of students:");
            }
        }
        StudentGradeTracker tracker = new StudentGradeTracker(numberOfStudents);
        for (int i = 0; i < numberOfStudents; i++)
         {
            System.out.println("Enter student name for student " + (i + 1) + ":");
            String name = scanner.nextLine();
            System.out.println("Enter grade for " + name + ":");
            double grade;
            while (true)
             {
                try
                 {
                    grade = Double.parseDouble(scanner.nextLine());
                    break;
                }
                 catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for the grade:");
                }
            }
            tracker.addStudent(name, grade);
        }
        tracker.displayStudentData();
        System.out.println("Average grade: " + tracker.computeAverage());
        System.out.println("Highest grade: " + tracker.findHighestGrade());
        System.out.println("Lowest grade: " + tracker.findLowestGrade());
    }
}

