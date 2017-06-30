import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

final class HttpRequest implements Runnable{
	final static String CRLF = "\r\n";
	Socket socket = new Socket();
	
	public HttpRequest(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run(){
		try{
			processRequest();
		}catch(Exception e){
			System.out.println("Request not processed.");
		}
	}
	
	private void processRequest() throws Exception{
		InputStream inStream = this.socket.getInputStream();
		DataOutputStream outStream = new DataOutputStream(this.socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
		String requestLine = br.readLine();
		String headerLine = "";
		
		System.out.println();
		System.out.println(requestLine);
		
		while((headerLine = br.readLine()).length() != 0){
			System.out.println(headerLine);
		}
		
		StringTokenizer tokens = new StringTokenizer(requestLine);
		tokens.nextToken();
		String fileName = tokens.nextToken();
		fileName = "." + fileName;
		FileInputStream fin = null;
		boolean fileExists = true;
		
		try{
			fin = new FileInputStream(fileName);
		}catch(FileNotFoundException e){
			fileExists = false;
		}
		
		String statusLine = null;
		String contentTypeLine = null;
		String entityBody = null;
		
		if(fileExists){
			statusLine = "HTTP/1.1 200 OK" + CRLF;
			contentTypeLine = "Content-type: " + contentType(fileName) + CRLF;
		}
		else{
			statusLine = "HTTP/1.1 404 Not Found";
			contentTypeLine = "text/html";
			entityBody = "<HTML>" + 
				"<HEAD><TITLE>Not Found</TITLE></HEAD>" +
				"<BODY>Not Found</BODY></HTML>";
		}
		
		outStream.writeBytes(statusLine);
		outStream.writeBytes(contentTypeLine);
		outStream.writeBytes(CRLF);
		
		if(fileExists){
			sendBytes(fin, outStream);
			fin.close();
		}
		else{
			outStream.writeBytes(entityBody);
		}
		
		br.close();
		outStream.close();
		this.socket.close();
	}
	
	private static void sendBytes(FileInputStream fin, OutputStream outStream)throws Exception{
		byte[] buffer = new byte[1024];
		int bytes = 0;
		
		while((bytes = fin.read(buffer)) != -1){
			outStream.write(buffer, 0, bytes);
		}
	}
	
	private static String contentType(String fileName){
		if(fileName.endsWith(".htm") || fileName.endsWith(".html")){
			return "text/html";
		}
		if(fileName.endsWith(".jpeg") || fileName.endsWith(".jpg")){
			return "image/jpeg";
		}
		if(fileName.endsWith(".gif")){
			return "image/gif";
		}
		if(fileName.endsWith(".css")){
			return "text/css";
		}
		return "application/octet-stream";
	}
}