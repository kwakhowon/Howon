import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class QuizInfo {
	Scanner sc = new Scanner(System.in);
	HashMap<String, String> quiz = new HashMap<>();
	int score;
	Set<String> quizSet;
	Iterator<String> i;

	public void quizPlay() {
		sc = new Scanner(System.in);
		score = 0;
		quiz = new HashMap<String, String>();
		
		quiz.put("임진왜란이 일어난 연도는?  ", "1592");
		quiz.put("고구려를 건국한 사람은? ", "주몽");
		quiz.put("디자인패턴 총 개수? ", "23");
		quiz.put("get의 과거형 ?  ", "got");
		quiz.put("보노보노는 눈이 몇개일까요 ? ", "2개");
		quiz.put("한국은 원, 일본은 엔, 호주는?(4글자) ", "호주머니");
		quiz.put("현재 강의실에 있는 컴퓨터의 총 대수는(노트북 포함)? ", "41");
		quiz.put("백인이 보드를 타면? ", "화이트보드");
		quiz.put("임경균강사님 전화번호는? ", "01083605668");
		quiz.put("비트캠프 강남점 전화번호? ", "0234535404");
		quizSet = quiz.keySet();
		i = quizSet.iterator();
	}
	
	public void quizStart() {
		while(i.hasNext()) {
			System.out.println("여러가지 퀴즈");
			String quiz = i.next();
			String answer = showQuiz(quiz);
			if(checkResult(quiz, answer)) {
				System.out.println("정답");
				System.out.println();
				score++;
			}else {
				System.out.println("틀렸습니다.");
				System.out.println();
			}
		}
		System.out.println("끝!!!!");
		System.out.println("점수 : " +score+"점");
	}

	private boolean checkResult(String quiz, String answer) {
		
		return false;
	}

	private String showQuiz(String quiz) {
		System.out.println(quiz);
		System.out.println("답 : ");
		String answer = sc.next();
		return answer;
	}

}