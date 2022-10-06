
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Server {
     public static void main(String[] args) throws Exception{
         
         DatagramSocket ds = new DatagramSocket(3000);
         byte[] buffer = new byte[1024];
         
         DatagramPacket dp = new DatagramPacket(buffer, 1024);
         ds.receive(dp);
         
         String str = new String(dp.getData(), 0, dp.getLength());
         System.out.println(str);
         ds.close();
     }
}
