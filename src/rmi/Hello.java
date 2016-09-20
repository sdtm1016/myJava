package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
//远程对象接口:在Client中调用
public interface Hello extends Remote {
	
	public String sayHello(String name) throws RemoteException;
}