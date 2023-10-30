package Soni_5b_java;

/**
 *
 * @author montox
 */

public class RotikuJoss {

    String namaku, warna, rasa;
    int berat;
    double harga;
    
    void beriNama(String namaRoti) {
        namaku = namaRoti;
    }

    void beriWarna(String warnaRoti) {
        warna = warnaRoti;
    }

    void beriRasa(String rasaRoti) {
        rasa = rasaRoti;
    }

    void timbangBerat(int beratRoti) {
        berat = beratRoti;
    }

    void hargaJual(double hargaRoti) {
        harga = hargaRoti;
    }
    
    void infoRoti() {
        System.out.println(
                "Nama Roti : " + namaku + "\n"
                +"Warna Roti : " + warna + "\n"
                + "Rasa Roti : " + rasa + "\n"
                + "Berat Roti : " + berat + " gr \n"
                + "Harga Roti : Rp." + harga + "\n");
    }
    
    public static void main(String[] args) {
        
        RotikuJoss Donat = new RotikuJoss();
        
        Donat.beriNama("Donat Jumbo");
        Donat.beriWarna("Cokelat");
        Donat.beriRasa("Pisang Coklat");
        Donat.timbangBerat(50);
        Donat.hargaJual(5000);
        Donat.infoRoti();
    }
}
