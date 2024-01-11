package object.self;

import java.util.Arrays;
import java.util.Comparator;

import object.day9.Student;



public class Quiz {
    private int x;
    private int y;
    private int grade;
    public int getGrade() {
        return grade;
    }
    public static void main(String[] args) {
        Student[] students = new Student[4];
        
        Comparator<Student> gradeAscending = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return  o1.getGrade()- o2.getGrade();
            }
        };
        Arrays.sort(students, gradeAscending);

        Arrays.sort(students, (o1, o2) -> {
            return  o1.getGrade()- o2.getGrade();
            }
        );


        final int add(int x, int y){
            return x+y;
        };
     }
        
}
