package object.day9;

import java.util.Arrays;
import java.util.Comparator;


public class C21ArraySortTest {

    public static void main(String[] args) {
        int[] numbers = {67,34,77,89,82};
        System.out.println("초기 numbers= "+Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("정렬 후 numbers= "+Arrays.toString(numbers));


        String[] names = {"momo", " nayeon", "dahyeon", "Zewi","Beo"};
        System.out.println("초기 names = "+Arrays.toString(names));
        Arrays.sort(names); //대문자 순으로 정렬..
        System.out.println("정렬 후 names = "+Arrays.toString(names));

        //Arrays.sort(배열변수): 기본형 배열 ,String 배열의 오름차순 정렬 가능
        //->내림차순 또는 다른 참조타입에 대한 정렬은 메소드의 두번째 인자로 기준을 공식으로(인터페이스) 전달

        //순서정렬 알고리즘: 가장 단순한 알고리즘
        //내림차순 정렬 - Comparator는 <> 제너릭타입에 기본형을 사용못함. Wrapper클래스 사용(Integer)
        Integer[] numbers2 = {67,34,77,89,82};
        Arrays.sort(numbers2,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                //내림차순 리턴 수식을 만드세요
                return o2-o1;
                //대입문 또는 수식에서 Integer 타입과 int 사이의 캐스팅은 자동
            }
        });
        Arrays.sort(numbers2, (o1, o2) -> {return o2-o1;});
        System.out.println("number2 내림차순 정렬 후 : "+Arrays.toString(numbers2));

        //정렬 알고리즘: 비교와 교환
        //i=o 배열인덱스
        //j=0,j=1, j-2, j=3 ..오름차순 정렬에서는 왼쪽값<오른쪽 값이 되어야 함
        //그렇지 않다면 교환함
        
        /* System.out.println(Arrays.sort.reverses(names));
        System.out.println(Arrays.reverses.sort(names));
 */



    }
    
}
