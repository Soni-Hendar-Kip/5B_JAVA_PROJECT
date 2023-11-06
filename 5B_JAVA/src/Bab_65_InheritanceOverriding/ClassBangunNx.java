
package Bab_65_InheritanceOverriding;

import java.lang.Math;

/**
 *
 * @author Soni PTI 5B
 */
public class ClassBangunNx {

    public double NxHitunganLuas() {
        return 0.0; //ini untuk panggilan nanti
    }

    public double NxHitunganKeliling() {
        return 0.0; //ini untuk panggilan nanti
    }
}

class NxPersegi extends ClassBangunNx {

    private double NxSisi;

    public NxPersegi(double SisiKU) {
        this.NxSisi = SisiKU;
    }

    @Override
    public double NxHitunganLuas() {
        return NxSisi * NxSisi; //rumus Luas Persegi
    }
    
    @Override
    public double NxHitunganKeliling() {
        return 4 * NxSisi; //rumus Kelililing Persegi
    }
}

class NxPersegiPJ extends ClassBangunNx {

    private double NxPanjang;
    private double NxLebar;

    public NxPersegiPJ(double PanjangKU, double LebarKU) {
        this.NxPanjang = PanjangKU;
        this.NxLebar = LebarKU;
    }

    @Override
    public double NxHitunganLuas() {
        return NxPanjang * NxLebar; //rumus Luas Persegi Panjang
    }
    
    @Override
    public double NxHitunganKeliling(){
        return 2 * (NxPanjang + NxLebar); //rumus Keliling Persegi Panjang
    }
}

class NxSegitaga extends ClassBangunNx {

    double NxAlasSegitiga;
    double NxTinggiSegitiga;

    public NxSegitaga(double AlasSegitigaKU, double TinggiSegitigaKU) {
        this.NxAlasSegitiga = AlasSegitigaKU;
        this.NxTinggiSegitiga = TinggiSegitigaKU;
    }

    @Override
    public double NxHitunganLuas() {
        return 0.5 * NxAlasSegitiga * NxTinggiSegitiga; //rumus Luas Segitiga
    }
    
    @Override
    public double NxHitunganKeliling() {
        double NxSisiMiring = Math.sqrt(NxAlasSegitiga * NxAlasSegitiga + NxTinggiSegitiga * NxTinggiSegitiga);
        return NxAlasSegitiga + NxTinggiSegitiga + NxSisiMiring;
    }
}

class NxSegi3SamaKaki extends NxSegitaga {

    public NxSegi3SamaKaki(double AlasSamaKaki, double TinggiSamaKaki) {
        //super untuk memanggil nilai konstruktor dari superclass diatasnya
        super(AlasSamaKaki, TinggiSamaKaki);
    }
    
    @Override
    public double NxHitunganKeliling(){
        //Mencari sisi miring segitiga, berdasarkan nilai Alas dan Tinggi
        double NxSisiMiring = Math.sqrt(NxAlasSegitiga * NxAlasSegitiga + NxTinggiSegitiga * NxTinggiSegitiga);
        return NxAlasSegitiga + NxSisiMiring + NxSisiMiring;
    }
}

class NxSegi3SamaSisi extends NxSegitaga {

    private double NxSisiSegi3SamaSisi;

    public NxSegi3SamaSisi(double sisiKUM) {
        //super untuk memanggil nilai konstruktor dari superclass diatasnya
        super(sisiKUM, (Math.sqrt(3) / 2) * sisiKUM);
        this.NxSisiSegi3SamaSisi = sisiKUM;
    }
    
    @Override
    public double NxHitunganKeliling(){
        return 3 * NxSisiSegi3SamaSisi;
    }
}
