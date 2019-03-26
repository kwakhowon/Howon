import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Quiz_Lotto {
	private Scanner scanner; // 부품정보 상태정보 , 부품정보 , 고유정보
	private int lottoCount;
	private int nameCount;
	
	public Quiz_Lotto() { // 특수한 목적 : member field 초기화 (생성자 함수) , constructor
		scanner = new Scanner(System.in); // 초기화 (참조 변수 주소값을 갖는것)
		lottoCount=0;
		nameCount=0;
	}
	
	public void show_MainMenu() { // 첫 메뉴 출력

		do {
				System.out.println("\n***로또 프로그램***\n");
				System.out.println("1. 로또 룰렛 돌리기");
				System.out.println("2. 로또 회차정보 보기");

				System.out.println("3. 시스템 종료");
				
				System.out.print("\n메뉴 선택 : ");
				int menu = Integer.parseInt(scanner.nextLine());
				switch (menu) {
				case 1:
					 // 일단 한번 로또번호 출력
					show_PrintMenu(selectBasicLottoNumber());
					break;
				case 2:
					lottoLogPreview();
					break;
				case 3:
					System.out.println("너가 감히 나를꺼?");
					System.exit(0);;
				default:
					System.out.println("바부");
			} 
		} while (true);

	}

	private List selectBasicLottoNumber() { //번호 추출 및 카운팅/ 리스트 리턴
		Set<Integer> hashset = new HashSet<Integer>();
		for (int i = 0; hashset.size() < 6; i++) {
			hashset.add((int) (Math.random() * 45 + 1));
		}
		List<Integer> list = new ArrayList<Integer>(hashset);
		Collections.sort(list);
		System.out.println(list +"\n");
		this.lottoCount++;
		lottoLog(list);
		return list;
	}
	
	private void show_PrintMenu(List list) {
		do {
				System.out.println("\n***부가 기능***\n");
				System.out.println("1. 내보내기(txt)");
				System.out.println("2. 로또 번호 회차별 정보");
				System.out.println("3. 시스템 종료");
				System.out.print("\n메뉴 선택 : ");
				int menu = Integer.parseInt(scanner.nextLine());
				switch (menu) {
				case 1:
					txtWrite(list); 
					break;
				case 2:
					lottoLogPreview();
					break;					
				case 3:
					System.out.println("너가 감히 나를꺼?");
					System.exit(0);;
				default:
					System.out.println("바부");
			}
		}while(false);
	}
	
	private void lottoLog(List list) {
		String date = DateString(Calendar.getInstance(), "-"); 
		FileWriter filewriter = null;
		BufferedWriter bufferedwriter = null;
		File file = null;
		
		String path = "./temp";
		file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		file = new File(path+"/lottoLog.txt");
		try {
			filewriter = new FileWriter(file, true);
			bufferedwriter = new BufferedWriter(filewriter);
			bufferedwriter.write(date + " ");
			bufferedwriter.write(lottoCount + "times ");
			bufferedwriter.write(list.toString()+ " ");
			bufferedwriter.write(System.getProperty("user.name")+"\n");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bufferedwriter.flush();
				bufferedwriter.close();
				filewriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void txtWrite(List list) {
		FileWriter filewriter = null;
		BufferedWriter bufferedwriter = null;
		File file = null;
		String path = "./lottoLog.txt";
		file = new File(path);
		if(!file.exists()) {
			file = new File("./"+lottoCount+"times lottoLog("+this.nameCount+").txt");
			this.nameCount++;
		}
		
		try {
			filewriter = new FileWriter(file,true);
			bufferedwriter = new BufferedWriter(filewriter);
			bufferedwriter.write(lottoCount + "회차 ");
			bufferedwriter.write(list.toString()+"\n");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bufferedwriter.flush();
				bufferedwriter.close();
				filewriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void lottoLogPreview() {
		String log = "데이터가 없습니다.";
		
		FileInputStream fileinputstream = null;
		DataInputStream datainputstream = null;
		
		try {
			fileinputstream = new FileInputStream("./temp/lottoLog.txt");
			datainputstream = new DataInputStream(fileinputstream);
			while((log = datainputstream.readLine())!=null) {
				System.out.println(log);
			}
		} catch (Exception e) {
			System.out.println(log);
		}finally {
			try {
				datainputstream.close();
				fileinputstream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public static String DateString(Calendar date, String opr) {
		return date.get(Calendar.YEAR) + opr + (date.get(Calendar.MONTH) + 1) + opr 
				+ date.get(Calendar.DATE) + opr + date.get(Calendar.HOUR)+ ":" + date.get(Calendar.MINUTE)
				+ ":" + date.get(Calendar.SECOND);
	}
	
}