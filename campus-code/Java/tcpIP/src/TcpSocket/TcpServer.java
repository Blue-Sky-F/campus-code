package TcpSocket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//import org.omg.CORBA.portable.InputStream;
public class TcpServer {
	public static void main(String args[]) throws Exception{
		String sentence;
		String responce;
		//Create a socket object
		ServerSocket ss = new ServerSocket(6789);
		Socket socket = ss.accept();
		while(true){
			//listening the connecting of the socket
			 // ���տͻ��˵�����
            try{DataInputStream in = new DataInputStream(socket.getInputStream());
            sentence = in.readUTF();}
            catch(Exception e){
            	socket.close();
            	break;
            }
            if (sentence.endsWith("close")){
            	socket.close();
            	break;
            }
            System.out.println("Received from Client:" + sentence);
            // ���͸��ͻ�������
            System.out.println("Send message to Client:");
            Scanner s = new Scanner(System.in);
            responce = s.nextLine();
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(responce);
            out.flush();
            

			
			
		}
		
		
		
	}


}
