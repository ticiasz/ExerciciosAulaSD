/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exTcpObjectTransmission;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;

public class Client {
    static Socket socket;
    
    //faz a conexão com o socket
    public Client(){
        try {
            socket = new Socket("localhost", 9600);
        } catch (Exception e) {
            System.err.println("Nao consegui resolver o host...");
        }
    }
    
    public static void main(String args[]) throws IOException{
        Calendar c = Calendar.getInstance();
        c.set(2002, Calendar.JUNE, 19);
        Date date = c.getTime();
        
        //instancia o objeto e chama o método
        Person person = new Person(123L, "Letícia", "Matheus", "52305267851", date);
        new Client();
        
        //transforma o objeto em bytes para mandar para o servidor
        final ByteArrayOutputStream baos = new ByteArrayOutputStream(6400);
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(person);
        final byte[] data = baos.toByteArray();
        
        //envia os dados
        OutputStream out;
        try {
            out = socket.getOutputStream();
            out.write(data);
        } catch (Exception e) {
            System.err.println("Excecao no OutputStream");
        }
        
        //fase de desconexão
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Nao encerrou a conexao corretamente" + e.getMessage());
        }
    } 
}
