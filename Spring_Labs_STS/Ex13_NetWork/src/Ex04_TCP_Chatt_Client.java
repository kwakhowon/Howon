import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//Inner Class 사용해서 구현
//Clientsend 
//ClientReceive

public class Ex04_TCP_Chatt_Client {

	public static void main(String[] args) {
		//Socket socket = new Socket("192.168.0.24", 9999);
		//System.out.println("서버와 연결 되었습니다");
		Ex04_TCP_Chatt_Client client = new Ex04_TCP_Chatt_Client();
		

	}
	
	Socket socket; //member field  //Ex04_TCP_Chatt_Client >> outer 자원
	Ex04_TCP_Chatt_Client(){
		try {
			socket = new Socket("192.168.0.51",9999);
			System.out.println("Chatt 서버와 연결 되었습니다");
			new ClientSend().start();
			new CleintReceive().start();
		}catch (Exception e) {
		
		}
	}
	
	//Inner Class 작업
	class ClientSend extends Thread{
		@Override
		public void run() {  //다른 stack 의 main 역활  run()
			BufferedReader br = null;
			PrintWriter pw = null;
			try {
				 //line 단위 read할려고 
				 br = new BufferedReader(new InputStreamReader(System.in));
				 //출력
				 pw = new PrintWriter(socket.getOutputStream(),true); //auto flush
				 
				 while(true) {
					 String data = br.readLine(); //sc.nextLine()
					 if(data.equals("exit"))break;
					 pw.println(data); //접속한 서버에 메시지 보내기 dos.writeUTF(data);
				 }
				 System.out.println("Client send 작업 종료");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
					try {
						pw.close();
						br.close();
						
					}catch(Exception e) {
						
					}
			}
		}
	}
	
	//Inner class 작업
	class CleintReceive extends Thread{
		@Override
		public void run() {
			BufferedReader br =null;
			try {
				  //InputStream in = socket.getInputStream();
				  //DataInputStream dis = new DataInputStream(in);
				 
				 //InputStreamReader 통해서 InputStream 을  > reader  변환
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String data = null;
				while((data = br.readLine()) != null) {
					System.out.println("Server 받은 메시지[" + data + "]");
				}
				System.out.println("ClientReceive 종료");
			}catch(Exception e) {
				
			}finally {
				try {
					br.close();
					
				} catch (Exception e2) {
					
				}
			}
		}
	}

}

