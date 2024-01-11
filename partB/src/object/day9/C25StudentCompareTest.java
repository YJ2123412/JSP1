package object.day9;
//Arrays.sort. 메소드에 두번째 인자로 Comparator 인터페이스 타입 객체를 전달하면 비교 기준과 정렬 방법을 실행시점에서 결정됩니다.

import java.util.Arrays;
import java.util.Comparator;

public class C25StudentCompareTest {
    


    public static void main(String[] args) {
        
        Student[] students = new Student[4];
        students[0]= new Student("장모모", 23);
        students[1]= new Student("박나연", 22);
        students[2]= new Student("김다현", 24);
        students[3]= new Student("사나", 21);
        
        System.out.println("초기 students 배열: "+Arrays.toString(students));
        //Arrays.sort(students); //오류: Student 객체는 Comparable이 아님.

        System.out.println("정렬 후 students 배열: "+Arrays.toString(students));
    // 한번만 사용할 Coparator는 선언하지 않고 바로 인자에 넣어서 사용        
    //람다식은 Comparator 구현 클래스 정의 : 추상메소드 1개는 compare
    //메소드 인자는 Student 타입 o1, o2/ 메소드 실행과 리턴은 {몸통}에 작성
        Arrays.sort(students, (o1, o2) -> {
                return  o1.getAge()- o2.getAge();
        });
// o1(오른쪽), o2(왼쪽)이며 오름/내림 상관없이 교환을 안해도되는 경우를 음수값으로 리턴함
//sort 메소드 정렬 알고리즘은 비교결과 음수 리턴하면 교환하지 않고 양수리턴하면 교환함
//2-3=-1<0 교환하지 않음
//o2-o1<0이면 교환하지 않습니다
        System.out.println("나이 오름차순 정렬 후 students 배열: "+Arrays.toString(students));

        Comparator<Student> ageDecending = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getAge()- o1.getAge() ;
            }
        //내림차순 o1>o2이 되어야 함. 만약 o2-o1<0이면 교환하지 않음

        };
        Arrays.sort(students,ageDecending);
        System.out.println("나이 내림차순 정렬 후 students 배열: "+Arrays.toString(students));


        Comparator<Student> nameAscending = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName()) ;
            }
        };
        Arrays.sort(students,nameAscending);
        System.out.println("이름 오름차순 정렬 후 students 배열: "+Arrays.toString(students));


        Comparator<Student> nameDecending = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return  o2.getName().compareTo(o1.getName());
            }
        };
        Arrays.sort(students,nameDecending);
        System.out.println("이름 내림차순 정렬 후 students 배열: "+Arrays.toString(students));





        //ageDecending
        //nameAscending
        //nameDecending
    }
}
