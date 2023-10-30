
package Soni_5b_java;

/**
 *
 * @author Soni H PTI 5B
 */
public class HewanNgantuk {
    
    String Nana, Makaman, Yipe;
    int Kali;
    
    public void KasihNama (String NamaHewan) {
        Nana = NamaHewan ;
    }
    
    public void KasihMakan (String MakananHewan) {
        Makaman = MakananHewan ;
    }
    
    public void JenisTipe (String TipeHewan) {
        Yipe = TipeHewan ;
    }
    
    public void JumlahKaki (int JmlKaki) {
        Kali = JmlKaki ;
    }
    
    public void InfoHewan () {
        System.out.println(
                "Nama Hewan = "+Nana+"\n"
                +"Jumlah Kaki = "+Kali+"\n"
                +"Makanan = "+Makaman+"\n"
                +"Tipe Hewan ="+Yipe+"\n"
        );
    }
    
    public static void main(String[] args){
        
        HewanNgantuk macan = new HewanNgantuk();
        HewanNgantuk kebo = new HewanNgantuk();
        HewanNgantuk burung = new HewanNgantuk();
        
        macan.KasihNama("Harimau");
        macan.JumlahKaki(4);
        macan.KasihMakan("Daging mentah");
        macan.JenisTipe("Karnivoro");
        macan.InfoHewan();
        
        kebo.KasihNama("Kerbau");
        kebo.JumlahKaki(4);
        kebo.KasihMakan("Daun dan suket");
        kebo.JenisTipe("Herbivora");
        kebo.InfoHewan();
        
        burung.KasihNama("Burung Gereja");
        burung.JumlahKaki(2);
        burung.KasihMakan("Bijian");
        burung.JenisTipe("Omnivora kan ya?");
        burung.InfoHewan();
    }
    
}
