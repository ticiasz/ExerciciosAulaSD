/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleRMI.calculator;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServiceImpl implements CalculatorService{
    
    @Override
    public float sendResult(float num1, float num2) throws RemoteException{
        Calculator calculator = new Calculator(num1, num2);
        float result = calculator.getResult();
        return result;
    }
    
    public void createStubAndBind() throws RemoteException{
        CalculatorService stub = (CalculatorService) UnicastRemoteObject.exportObject((CalculatorService) this, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("Resultado", stub);
    }
}
