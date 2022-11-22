/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author nhu
 */
public class Client {
public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
    DatagramSocket client= new DatagramSocket();
    System.out.println("1. Tim kiem\n2.Danh sach trung tuyen\n3.Thong tin thi sinh");
    Scanner sc= new Scanner(System.in);
    String send_data="";
    int chon=Integer.parseInt(sc.nextLine());
            switch(chon){
                case 1:{
                    System.out.println("Nhap so chung minh thu:");
                    send_data=chon+"$"+sc.nextLine();   
                    break;
                }
                case 2:{
                    send_data=chon+"$";   
                    break;
                }
                case 3:{
                    send_data=chon+"$";   
                    break;
                }
            }
            InetAddress ip= InetAddress.getByName("localhost");
            DatagramPacket dp_client= new DatagramPacket(send_data.getBytes(), (send_data.getBytes()).length,ip, 7 );
            client.send(dp_client );
            byte[] receive_data= new byte[1024];
            DatagramPacket dp_receive= new DatagramPacket(receive_data, receive_data.length);
            client.receive(dp_receive);
            String s= new String(dp_receive.getData(),0,dp_receive.getLength());
            System.out.println(s);
}   
}
