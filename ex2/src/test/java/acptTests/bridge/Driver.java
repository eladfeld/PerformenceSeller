package acptTests.bridge;

import hw2.bridge.Bridge;

public abstract class Driver {

	public static Bridge getBridge() {
		ProxyBridge bridge = new ProxyBridge();

		bridge.setRealBridge(new hw2.data.Bridge());
		return bridge;
	}
}
