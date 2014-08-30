package udp.prims;

import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultCommand;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;

import udp.UdpExtension;

public class SendData extends DefaultCommand {

	@Override
    public Syntax getSyntax() {
       int[] argType = {Syntax.StringType()};
       return  Syntax.commandSyntax(argType);
    }
	
	@Override
	public void perform(Argument[] args, Context arg1)
			throws ExtensionException, LogoException {
		
		String data = args[0].getString();
		
		if (UdpExtension.socket == null) {
			throw new ExtensionException("No Open Socket");
		} else {
			UdpExtension.socket.sendData(data.getBytes());
		}
	}

}
