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

public class CreateLocalSocket extends DefaultCommand {

	@Override
	public String getAgentClassString() {
		return "O";
	}
	
	@Override
    public Syntax getSyntax() {
       int[] argType = {Syntax.NumberType()};
       return  Syntax.commandSyntax(argType);
    }
	
	@Override
	public void perform(Argument[] arg, Context arg1)
			throws ExtensionException, LogoException {
		
		if ( UdpExtension.socket != null ) { UdpExtension.socket.closePort(); }
		
		int port = arg[0].getIntValue();
		try {
			InetAddress IPAddress = InetAddress.getByName("localhost");
			UdpExtension.socket = new Socket(IPAddress, port);
		} catch (UnknownHostException e) {
			throw new ExtensionException("ERROR in opening local socket. " + e);
		}
	}

}
