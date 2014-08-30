package udp.sock;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Socket {
	
	DatagramSocket clientSocket;
	InetAddress address;
	int port;
	byte[] sendData;
	
	public Socket( InetAddress ip,  int comport ) {
		try {
			clientSocket = new DatagramSocket();
			address = ip;
			port = comport;
			sendData = new byte[1024];
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void sendData( byte[] tosend ) {
		sendData = tosend;
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
	    try {
			clientSocket.send(sendPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closePort() {
		clientSocket.close();
	}
}
