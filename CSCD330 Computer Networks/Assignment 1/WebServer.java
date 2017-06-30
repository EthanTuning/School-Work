import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

final class WebServer{
	@SuppressWarnings("resource")
	public static void main(String[] args)throws Exception{
		int port = 6789;
		ServerSocket listenSocket = null;
		
		try{
			listenSocket = new ServerSocket(port);
		}catch (IOException e){
			System.out.println("Could not establish connection.\nExiting program...");
		}
		
		while(true){
			Socket connectionSocket = listenSocket.accept();
			HttpRequest request = new HttpRequest(connectionSocket);
			Thread thread = new Thread(request);
			thread.start();
		}
	}
}