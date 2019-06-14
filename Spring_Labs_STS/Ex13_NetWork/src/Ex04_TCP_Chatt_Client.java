import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//Inner Class ����ؼ� ����
//Clientsend 
//ClientReceive

public class Ex04_TCP_Chatt_Client {

	public static void main(String[] args) {
		//Socket socket = new Socket("192.168.0.24", 9999);
		//System.out.println("������ ���� �Ǿ����ϴ�");
		Ex04_TCP_Chatt_Client client = new Ex04_TCP_Chatt_Client();
		

	}
	
	Socket socket; //member field  //Ex04_TCP_Chatt_Client >> outer �ڿ�
	Ex04_TCP_Chatt_Client(){
		try {
			socket = new Socket("192.168.0.51",9999);
			System.out.println("Chatt ������ ���� �Ǿ����ϴ�");
			new ClientSend().start();
			new CleintReceive().start();
		}catch (Exception e) {
		
		}
	}
	
	//Inner Class �۾�
	class ClientSend extends Thread{
		@Override
		public void run() {  //�ٸ� stack �� main ��Ȱ  run()
			BufferedReader br = null;
			PrintWriter pw = null;
			try {
				 //line ���� read�ҷ��� 
				 br = new BufferedReader(new InputStreamReader(System.in));
				 //���
				 pw = new PrintWriter(socket.getOutputStream(),true); //auto flush
				 
				 while(true) {
					 String data = br.readLine(); //sc.nextLine()
					 if(data.equals("exit"))break;
					 pw.println(data); //������ ������ �޽��� ������ dos.writeUTF(data);
				 }
				 System.out.println("Client send �۾� ����");
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
	
	//Inner class �۾�
	class CleintReceive extends Thread{
		@Override
		public void run() {
			BufferedReader br =null;
			try {
				  //InputStream in = socket.getInputStream();
				  //DataInputStream dis = new DataInputStream(in);
				 
				 //InputStreamReader ���ؼ� InputStream ��  > reader  ��ȯ
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String data = null;
				while((data = br.readLine()) != null) {
					System.out.println("Server ���� �޽���[" + data + "]");
				}
				System.out.println("ClientReceive ����");
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

