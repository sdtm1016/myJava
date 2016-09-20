package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIQueryStatus extends Remote {

	// 远程接口中的函数必须讲java.rmi.remoteException声明与其throws字句内
	RMIQueryStatus getFIQueryStatus(String filename) throws RemoteException;
}
