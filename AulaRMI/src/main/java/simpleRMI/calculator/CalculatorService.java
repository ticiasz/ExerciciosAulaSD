/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleRMI.calculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorService extends Remote{
    
    public float sendResult(float num1, float num2) throws RemoteException;
}
