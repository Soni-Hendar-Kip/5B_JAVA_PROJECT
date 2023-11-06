package Bab_65_InheritanceOverriding;

/**
 *
 * @author Soni PTI 5B
 */
public class MainBangunNx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClassBangunNx NxPersegi = new NxPersegi(7);
        ClassBangunNx NxPersegiPJ = new NxPersegiPJ(9, 12);
        ClassBangunNx NxSegitaga = new NxSegitaga(5, 13);
        ClassBangunNx NxSgSamaKaki = new NxSegi3SamaKaki(11, 16);
        ClassBangunNx NxSgSamaSisi = new NxSegi3SamaSisi(8);

        System.out.println("Luas Persegi: " + NxPersegi.NxHitunganLuas());
        System.out.println("Keliling Persegi: " + NxPersegi.NxHitunganKeliling() + "\n");
        
        System.out.println("Luas Persegi Panjang: " + NxPersegiPJ.NxHitunganLuas());
        System.out.println("Keliling Persegi Panjang: " + NxPersegiPJ.NxHitunganKeliling() + "\n");
        
        System.out.println("Luas Segitiga Umum: " + NxSegitaga.NxHitunganLuas());
        System.out.println("Keliling Segitiga: " + NxSegitaga.NxHitunganKeliling() + "\n");
        
        System.out.println("Luas Segitiga Sama Kaki: " + NxSgSamaKaki.NxHitunganLuas());
        System.out.println("Keliling Segitiga Sama Kaki: " + NxSgSamaKaki.NxHitunganKeliling() + "\n");
        
        System.out.println("Luas Segitiga Sama Sisi: " + NxSgSamaSisi.NxHitunganLuas());
        System.out.println("Keliling Segitiga Sama Sisi: " + NxSgSamaSisi.NxHitunganKeliling() + "\n");

    }

}
