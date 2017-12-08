package br.com.eduardo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author eduardo
 */
public interface Cliente extends Remote {

    public String getNome() throws RemoteException;
    public String getIp() throws RemoteException;
    public int getPorta() throws RemoteException;
    
    public void append(String msg) throws RemoteException;

}
