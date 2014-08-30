package udp;

import org.nlogo.api.DefaultClassManager;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.ExtensionManager;
import org.nlogo.api.PrimitiveManager;

import udp.prims.CreateLocalSocket;
import udp.prims.GetGeoGebraPort;
import udp.prims.SendData;
import udp.sock.Socket;


public class UdpExtension extends DefaultClassManager {

	public static Socket socket;
	
	@Override
	public void load(PrimitiveManager pm) throws ExtensionException {
		pm.addPrimitive("create-local-socket", new CreateLocalSocket() );
		pm.addPrimitive("send", new SendData() );
		pm.addPrimitive("geogebra-port", new GetGeoGebraPort() );
	}
	
	
	
	@Override
	public void unload(ExtensionManager em) {
		if (socket != null) { socket.closePort(); }
	}

}
