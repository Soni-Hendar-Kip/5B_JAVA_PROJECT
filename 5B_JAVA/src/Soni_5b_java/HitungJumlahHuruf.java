
package Soni_5b_java;

import java.util.Scanner;

/**
 *
 * @author Soni H PTI 5B
 */
public class HitungJumlahHuruf {
    
    public static void main(String[] args){
        
        Scanner input = new Scanner (System.in);
        
        System.out.println("Program JAVA Sederhana");
        System.out.println("Menghitung Jumlah Karakter \n");
        
        String Mantra;
        
        System.out.print("Tuliskan Kalimat di sini = ");
        Mantra = input.nextLine();
        
        System.out.println("Jumlah Karakter = " + Mantra.length());
    }
    
}
