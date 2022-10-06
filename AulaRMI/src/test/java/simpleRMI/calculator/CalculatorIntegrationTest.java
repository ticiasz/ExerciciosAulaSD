package simpleRMI.calculator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.Before;
import org.junit.Test;


public class CalculatorIntegrationTest {
    
    private CalculatorServiceImpl calculatorService;
    
    
    @Before
    public void init(){
        try{
            calculatorService = new CalculatorServiceImpl();
            calculatorService.createStubAndBind();
        } catch(RemoteException e){
            fail("Exception occurred: " + e);
        }
    }
    
    
    @Test
    public void whenClientSendNumbersToServer_thenServerSendsResult(){
        try{
            Registry registry = LocateRegistry.getRegistry();
            CalculatorService server = (CalculatorService) registry.lookup("Resultado");
            float result = server.sendResult(3, 5);
            
            float expectedResult = 8;
            assertEquals(result, expectedResult);
        } catch(RemoteException | NotBoundException e){
            fail("Exception Occurred: " + e);
        }
    }
}
