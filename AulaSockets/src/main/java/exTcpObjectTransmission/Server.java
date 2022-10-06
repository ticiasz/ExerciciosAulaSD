/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exTcpObjectTransmission;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static ServerSocket server;
    
    public Server(){
        //criacao do server socket
        try {
            server = new ServerSocket(9600);
            System.out.println("Criado o Server Socket");
        } catch (Exception e) {
            System.err.println("Nao criei o Server Socket...");
        }
    }
    
    
    public static Person receive(Socket socket) throws Exception {
        InputStream in;
        byte[] buf = new byte[1024];
        Person person;
     
        try {
            //pegar oq o socket mandou e transforma em objeto
            in = socket.getInputStream();
            in.read(buf);
            final ByteArrayInputStream baos = new ByteArrayInputStream(buf);
            final ObjectInputStream oos = new ObjectInputStream(baos);
            Object returned = oos.readObject();
            person = (Person) returned;
            return person;
        } catch (IOException e) {
            System.err.println("Excecao no InputStream: " + e);
        }
        
        return null;
    }
    
    public static void main(String args[]) throws Exception{
        new Server(); 
        Socket client = null;
        
        //aceitar a conexão
        try {
            client = server.accept();
        } catch (Exception e) {
            System.err.println("Nao fez conexao" + e.getMessage());
        }

        //recebe os dados
        Person person = Server.receive(client);
        
        System.out.println(person);     
    }
}
