package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//远程接口实现类,在Server中保存
public class HelloImpl extends UnicastRemoteObject implements Hello {
	
	private static final long serialVersionUID = -271947229644133464L;

	public HelloImpl() throws RemoteException {
		super();
	}

	public String sayHello(String name) throws RemoteException {
		return "Hello," + name;
	}
}