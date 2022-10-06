package org.sd.rmi.simpleRmi.messenger;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author profslpa
 */
public class MessengerServiceImpl implements MessengerService{

    @Override
    public String sendMessage(String clientMessage){
        String serverMessage = null;
        if(clientMessage.equals("Client Message")){
            serverMessage = "Server Message";
        }
        return serverMessage;
    }
    
    @Override
    public Message sendMessage(Message clientMessage) throws RemoteException{
        
        Message serverMessage = null;
        if(clientMessage.getMessageText().equals("Client Message")){
            serverMessage = new Message("Server Message", "text/plain");
        }
        return serverMessage;
    }
    
    public void createStubAndBind() throws RemoteException{
        
        //criar um proxy para exportar um objeto
        //criar um registro local
        //rebind é para colocar o stub(resultado de um proxy) no registro e nomeá-lo
        MessengerService stub = (MessengerService) UnicastRemoteObject.exportObject((MessengerService) this, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("MessengerService", stub);
            
    }
}
