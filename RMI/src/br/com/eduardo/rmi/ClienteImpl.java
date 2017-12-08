package br.com.eduardo.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JTextArea;

/**
 *
 * @author eduardo
 */
public class ClienteImpl extends UnicastRemoteObject implements Cliente {

    private String nome;
    private JTextArea chat;
    private String ip;
    private int porta;

    public ClienteImpl(String nome, JTextArea chat, String ip, int porta) throws RemoteException {
        this.nome = nome;
        this.chat = chat;
        this.ip = ip;
        this.porta = porta;
    }

    @Override
    public String getNome() throws RemoteException {
        return nome;
    }

    @Override
    public String getIp() throws RemoteException {
        return ip;
    }

    @Override
    public int getPorta() throws RemoteException {
        return porta;
    }

    @Override
    public void append(String msg) throws RemoteException {
        chat.setText(chat.getText() + "\n" + msg);
        chat.setCaretPosition(chat.getText().length() - 1);
//        System.out.println(msg);
    }
}
