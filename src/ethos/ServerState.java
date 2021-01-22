package ethos;
import ethos.ServerProperties;

public enum ServerState {
	PUBLIC_PRIMARY(43594), PUBLIC_SECONDARY(43594), PRIVATE(43594);

    ServerProperties ServerProperties = new ServerProperties();

	private int port;
    private int serverPort = ServerProperties.getPropertyInt("serverPort");

	ServerState(int port) {
        if (serverPort != 0) {
            port = serverPort;
        }
		this.port = port;
	}

	public int getPort() {
		return port;
	}

}
