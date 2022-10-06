package udpObjectTransmission;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Client {
    
    public static void main(String[] args) throws Exception{
    
        Calendar c = Calendar.getInstance();
        c.set(2002, Calendar.JUNE, 19);
        Date date = c.getTime();
        
        
        //criando um objeto person
        Person person = new Person(123L, "Leticia", "Matheus", "456", date);
        
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        
        
        final ByteArrayOutputStream baos = new ByteArrayOutputStream(6400);
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(person);
        final byte[] data = baos.toByteArray();
        
        DatagramPacket dp = new DatagramPacket(data, data.length, ip, 3000);
        ds.send(dp);
        ds.close();
        
    }
}
