package TcpSocket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
 
public class TcpClient {
	public static void main(String args[]) throws UnknownHostException, IOException{
		String sentence=null;
		String responce=null;
		Socket clientSocket = new Socket("localhost",6789);
		// 发送给服务器的数据
		do{
			System.out.println("Send the message to Server:");
			Scanner s = new Scanner(System.in);
			sentence = s.nextLine();
			if(sentence.endsWith("close")){
				clientSocket.close();
				break;
			}
	        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
	        out.writeUTF(sentence);
	        out.flush();
	        // 接收服务器的返回数据
	        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
	        responce = in.readUTF();
	        System.out.println("Reseived from Server:"+responce);
		}
		while(!sentence.endsWith("close"));
        


	}
}
