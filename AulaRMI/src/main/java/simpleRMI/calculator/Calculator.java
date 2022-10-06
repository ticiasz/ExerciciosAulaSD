/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleRMI.calculator;

import java.io.Serializable;

public class Calculator implements Serializable{
    private float num1;
    private float num2;
    private float result;
    
    public Calculator(float num1, float num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = num1 + num2;
    }

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }
    
    public float getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(float result) {
        this.result = result;
    }
    
}
