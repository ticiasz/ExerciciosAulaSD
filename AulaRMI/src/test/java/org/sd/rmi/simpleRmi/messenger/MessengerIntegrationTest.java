package org.sd.rmi.simpleRmi.messenger;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.Before;
import org.junit.Test;

//test vai substituir o nosso public static void main
public class MessengerIntegrationTest {
    
    public int x = 1;
    
    private MessengerServiceImpl messengerService;
    
    //before roda antes do test
    @Before
    public void init(){
        try{
            messengerService = new MessengerServiceImpl();
            messengerService.createStubAndBind();;
        } catch(RemoteException e){
            fail("Exception occurred: " + e);
        }
    }

    
    @Test
    public void whenClientSendMessageToServer_thenServerSendsResponseMessage(){
        try{
            Registry registry = LocateRegistry.getRegistry();
            //procura o objeto no registry
            MessengerService server = (MessengerService) registry.lookup("MessengerService");
            //"chama" o server remotamente
            String responseMessage = server.sendMessage("Client Message");
            
            String expectedMessage = "Server Message";
            //confere se o retorno recebido é igual ao esperado
            //para fins do teste dar "verdinho"
            assertEquals(responseMessage, expectedMessage);
        } catch(RemoteException | NotBoundException e){
            fail("Exception Occurred: " + e);
        }
    }
}
