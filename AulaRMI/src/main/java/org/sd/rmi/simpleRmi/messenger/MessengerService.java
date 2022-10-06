package org.sd.rmi.simpleRmi.messenger;

import java.rmi.Remote;
import java.rmi.RemoteException;

/* interface é um contrato entre duas classes
 * o "contrato" do Remote implica que o objeto estará remoto (interface de marcação, n tem nada)
 */
public interface MessengerService extends Remote{
    
    public String sendMessage(String clientMessage) throws RemoteException;
    
    public Message sendMessage(Message clientMessage) throws RemoteException;
}
