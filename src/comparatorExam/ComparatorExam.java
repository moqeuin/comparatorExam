package comparatorExam;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorExam {

	public static void main(String[] args) {
		
		String[] strArr = {"Dog", "cat", "lion" , "tiger"};
		
		// String의 comparable에의한 정렬, 기본적으로 아스키코드가 작은 순으로 정렬한다.
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr)); //[Dog, cat, lion, tiger]
		
		// 다른 방식으로 정렬하고 싶다면 따로 클래스 구현한다.
		Arrays.sort(strArr, new Descending());
		System.out.println(Arrays.toString(strArr)); //[tiger, lion, cat, Dog]
		
		// 대소문자 구분하지 않고 정렬
		Arrays.sort(strArr,String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strArr)); //[[cat, Dog, lion, tiger]
	}

}

class Descending implements Comparator<String>{
	@Override
	public int compare(String s1, String s2) {
		// instanceof는 상속관계, 구현관계도 확인시켜준다.
		if(s1 instanceof Comparable && s2 instanceof Comparable) {
			
			// compareTo는 같으면 0, 작으면 -1, 크면 1로 반환한다.
			
			String c1 = s1;
			String c2 = s2;
			// 두 방식 모두 같은 결과가 출력이 된다.
			//return c1.compareTo(c2)*-1;
			return c2.compareTo(c1);
		}
		return -1;
	}
}