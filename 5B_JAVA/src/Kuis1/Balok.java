package Kuis1;

/**
 *
 * @author Soni H
 */
public class Balok {

    double panjang, lebar, tinggi, volBalok, luasBalok, BeratBalok;

    /*double SetPanjang(double panjangBalok) {
        this.panjang = panjangBalok;
        return panjangBalok;
    }

    double SetLebar(double lebarBalok) {
        this.lebar = lebarBalok;
        return lebarBalok;
    }

    double SetTinggi(double tinggiBalok) {
        this.tinggi = tinggiBalok;
        return tinggiBalok;
    }*/

    void GetPanjang(double Gpanjang) {
        this.panjang = Gpanjang;
    }

    void GetLebar(double GLebar) {
        this.lebar = GLebar;
    }

    void GetTinggi(double GTinggi) {
        this.tinggi = GTinggi;
    }

    void GetHitungVolume() {
        this.volBalok = panjang * lebar * tinggi;
        //System.out.println("" + Vol);
    }

    void GetHitungLuasPermukaan() {
        this.luasBalok = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    }

    void GetSepuluhBeratBalok() {
        this.BeratBalok = panjang + lebar;
    }

    void GetInformasiBalok() {
        System.out.println("""
                           Informasi Balok: 
                           Panjang balok = """ + panjang + "\n"
                + "Lebar balok = " + lebar + "\n"
                + "Tinggi balok = " + tinggi + "\n"
                + "Volume balok = " + volBalok + "\n"
                + "Luas Permukaan = " + luasBalok + "\n"
                + "Berat Balok = " + BeratBalok + "\n");
    }

}
