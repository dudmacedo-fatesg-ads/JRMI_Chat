package br.com.eduardo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author eduardo
 */
public interface Servidor extends Remote {

    public void loginCliente(Cliente cliente) throws RemoteException;
    public void escrever(Cliente cliente, String msg) throws RemoteException;
    public String getChat() throws RemoteException;

}
