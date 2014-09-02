package udp.prims;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultCommand;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;

import udp.UdpExtension;
import udp.sock.Socket;

public class CreateSocket extends DefaultCommand {

	@Override
	public String getAgentClassString() {
		return "O";
	}
	
	@Override
    public Syntax getSyntax() {
       int[] argType = {Syntax.StringType(), Syntax.NumberType()};
       return  Syntax.commandSyntax(argType);
    }
	
	@Override
	public void perform(Argument[] arg, Context arg1)
			throws ExtensionException, LogoException {
		
		if ( UdpExtension.socket != null ) { UdpExtension.socket.closePort(); }
		
		String host = arg[0].getString();
		InetAddress IPAddress;
		try {
			IPAddress = InetAddress.getByName(host);
			int port = arg[1].getIntValue();
			UdpExtension.socket = new Socket(IPAddress, port);
		} catch (UnknownHostException e) {
			throw new ExtensionException("ERROR in opening local socket. " + e);
		} 
	}

}
