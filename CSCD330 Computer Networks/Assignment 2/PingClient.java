import java.io.*;
import java.net.*;
import java.util.*;

public class PingClient
{
	private static final int MAX_TIMEOUT = 1000;

	public static void main(String[] args) throws Exception {
		
		if (args.length != 2) {
			System.out.println("Required arguments: Server port");
			return;
		}

		int port = Integer.parseInt(args[1]);
		InetAddress server;
		server = InetAddress.getByName(args[0]);
		
		DatagramSocket socket = new DatagramSocket(port);

		int sequence_number = 0;
		while (sequence_number < 10) {
			Date now = new Date();
			long msSend = now.getTime();
			String str = "PING " + sequence_number + " " + msSend + " \n";
			byte[] buf = new byte[1024];
			buf = str.getBytes();
			DatagramPacket ping = new DatagramPacket(buf, buf.length, server, port);

			socket.send(ping);
			try {
				socket.setSoTimeout(MAX_TIMEOUT);
				DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
				socket.receive(response);

				now = new Date();
				long msReceived = now.getTime();
				
				printData(response, msReceived - msSend);
			} catch (IOException e) {
				System.out.println("Timeout for packet " + sequence_number);
			}
			sequence_number ++;
		}
	}
	
	private static void printData(DatagramPacket request, long delayTime) throws Exception {
		byte[] buf = request.getData();
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);
		InputStreamReader isr = new InputStreamReader(bais);
		BufferedReader br = new BufferedReader(isr);
		
		String line = br.readLine();
		
		System.out.println("Received from " + request.getAddress().getHostAddress() + ": " + new String(line) + " Delay: " + delayTime );
	}
}