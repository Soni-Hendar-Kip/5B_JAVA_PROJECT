
package Kuis1;

/**
 *
 * @author montox
 */
public class SoniBalokMainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Balok Balok1 = new Balok();
        Balok Balok2 = new Balok();

        Balok1.GetPanjang(31);
        Balok1.GetLebar(12);
        Balok1.GetTinggi(9);
        Balok1.GetHitungLuasPermukaan();
        Balok1.GetHitungVolume();
        Balok1.GetSepuluhBeratBalok();
        Balok1.GetInformasiBalok();

        Balok2.GetPanjang(23);
        Balok2.GetLebar(15);
        Balok2.GetTinggi(9);
        Balok2.GetHitungLuasPermukaan();
        Balok2.GetHitungVolume();
        Balok2.GetSepuluhBeratBalok();
        Balok2.GetInformasiBalok();

    }

}
