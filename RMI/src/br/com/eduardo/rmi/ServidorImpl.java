package br.com.eduardo.rmi;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class ServidorImpl extends UnicastRemoteObject implements Servidor {
    
    private List<Cliente> conectados;
    private String chat;
    
    public ServidorImpl() throws RemoteException {
        conectados = new ArrayList<>();
        chat = "";
    }
    
    @Override
    public String getChat() throws RemoteException {
        return chat;
    }
    
    @Override
    public void loginCliente(Cliente cliente) throws RemoteException {
        conectados.add(cliente);
        System.out.println(cliente.getNome() + " se conectou.");
        append("Servidor: " + cliente.getNome() + " se conectou.");
    }
    
    private void append(String msg) throws RemoteException {
        
        for (Cliente cli : conectados) {
            Registry reg = LocateRegistry.getRegistry(cli.getIp(), cli.getPorta());
            try {
                ((Cliente) reg.lookup(cli.getNome())).append(msg);
            } catch (NotBoundException ex) {
                Logger.getLogger(ServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AccessException ex) {
                Logger.getLogger(ServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void escrever(Cliente cliente, String msg) throws RemoteException {
//        System.out.println(cliente.getNome() + ": " + msg);
        append(cliente.getNome() + ": " + msg);
    }
    
//    public static void main(String[] args) throws RemoteException, AccessException, AlreadyBoundException {
//        System.setProperty("java.rmi.server.hostname", "172.16.100.118");
//        Registry reg = LocateRegistry.createRegistry(55555);
//        
//        Servidor server = new ServidorImpl();
//        
//        reg.rebind("servidor", server);
//        
//        System.out.println("Pronto.");
//    }
}
