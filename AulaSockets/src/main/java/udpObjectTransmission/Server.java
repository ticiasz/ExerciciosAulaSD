package udpObjectTransmission;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Server {
    
    public static void main(String[] args) throws Exception{
        
        /*criando socket*/
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] buffer = new byte[1024];
        
        /*criando um pacote a ser recebido*/
        /*pacote preenche o buffer criado anteriormente*/
        DatagramPacket dp = new DatagramPacket(buffer, 1024);
        ds.receive(dp);
        
        /*cria um array de bytes com o conteúdo do buffer*/
        final ByteArrayInputStream baos = new ByteArrayInputStream(buffer);
        /*cria um objeto baseado no array*/
        final ObjectInputStream oos = new ObjectInputStream(baos);
        /*lê o objeto e compreende usando a classe person*/
        Object returned = oos.readObject();
        Person person = (Person) returned;
        
        /*printar alguma coisa do objeto*/
        System.out.println(person.getName());
        System.out.println(person.getBirthDate());
               
        
        /*corta a conexão*/
        ds.close();
    }
}
