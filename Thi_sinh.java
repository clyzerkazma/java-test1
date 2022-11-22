/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package udp1;

import java.util.Scanner;

/**
 *
 * @author nhu
 */
public class Thi_sinh {
    String hoten, cmt, diachi, namsinh;
    int diem1, diem2, diem3;
    public void nhap_ds_ts(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap ho ten:");
        hoten= sc.nextLine();
        System.out.println("Nhap so chung minh thu:");
        cmt= sc.nextLine();
        System.out.println("Nhap dia chi:");
        diachi= sc.nextLine();
        System.out.println("Nhap nam sinh:");
        namsinh= sc.nextLine();
        System.out.println("Nhap diem mon 1:");
        diem1= Integer.parseInt(sc.nextLine());
        System.out.println("Nhap diem mon 2:");
        diem2= Integer.parseInt(sc.nextLine());
        System.out.println("Nhap diem mon 3:");
        diem3= Integer.parseInt(sc.nextLine());
    }
    public void hien_thi(){
        System.out.println("Ho ten:"+hoten);
        System.out.println("so chung minh thu:"+cmt);
        System.out.println("Dia chi::"+diachi);
        System.out.println("nam sinh:"+namsinh);
        System.out.println("Diem mon 1:"+diem1);
        System.out.println("Diem mon 2:"+diem2);
        System.out.println("Diem mon 3:"+diem3);
    }
}
