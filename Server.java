/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author nhu
 */
public class Server {
    static  ArrayList<Thi_sinh> arr_ts;
    static  Thi_sinh s;
    public Server(){
        
    }
public static void main(String[] args) throws SocketException, IOException{
    DatagramSocket server= new DatagramSocket(7);
    arr_ts =  new ArrayList<Thi_sinh>();
        System.out.println("Nhap ds thi sinh");
        for(int i=0; i<3; i++){
            s= new Thi_sinh();
            s.nhap_ds_ts();
            arr_ts.add(s);
        }
    byte[] receive_data= new byte[1024];
    DatagramPacket dp_receive= new DatagramPacket(receive_data, receive_data.length);
    server.receive(dp_receive);
    String s= new String(dp_receive.getData(),0, dp_receive.getLength()).trim();
    System.out.println("server nhan:"+s);
    String[] a= s.split("\\$");
    
    String send_data="";
    int chon= Integer.parseInt(a[0]);
    switch(chon){
        case 1:{
            for(Thi_sinh ts: arr_ts){
                if(ts.cmt.equals(a[1])){
                    send_data+=ts.hoten+" "+ ts.diachi+" "+ ts.diem1+ ts.diem2+" "+ ts.diem3;
                }
            }break;
        }
        case 2:{
            for(Thi_sinh ts: arr_ts){
                if((ts.diem1+ts.diem2+ts.diem3)>15){
                    send_data+=ts.hoten+" "+ ts.diachi+" "+ ts.diem1+ ts.diem2+" "+ ts.diem3;
                }
                send_data+="\n";
        }
            break;
    }
        case 3: {
            for(Thi_sinh ts: arr_ts){
                    send_data+=ts.hoten+" "+ ts.diachi+" "+ ts.diem1+ ts.diem2+" "+ ts.diem3;
                send_data+="\n";
        }
            break;
        }
}
    DatagramPacket dp_send= new DatagramPacket(send_data.getBytes(), (send_data.getBytes()).length,dp_receive.getAddress(), dp_receive.getPort());
    server.send(dp_send);
    server.close();
}
}
