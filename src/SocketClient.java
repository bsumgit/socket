import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class SocketClient {
	
	public void processSocket(String serverName, int portNumber) {
		
		try{
			
			System.out.println("Connecting to " + serverName + " : " +  portNumber);
			Socket client = new Socket(serverName, portNumber);
			
			System.out.println("Connected to " + client.getRemoteSocketAddress());
			
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			
			out.writeUTF("Hello From " + client.getLocalSocketAddress());
			
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			
			System.out.println("Server says " + in.readUTF() );
			
			client.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
		SocketClient socketClient1 = new SocketClient();		
		socketClient1.processSocket("localhost", 7777);
		
		SocketClient socketClient2 = new SocketClient();		
		socketClient2.processSocket("localhost", 8888);
		
	}
}
