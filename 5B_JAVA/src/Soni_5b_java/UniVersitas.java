
package Soni_5b_java;

import java.util.Date;

/**
 *
 * @author Soni H PTI 5B
 */
public class UniVersitas {
    
    String NmDos, NmKary, NmMhs, Pendidikan, AlmtKary, AlmtMhs, Jabatan, NIM;
    int NIK, Semester;
    Date TglLahir;
    Double Gaji;
    
    public void TampilkanNamaDos (String NamaDosen){
        NmDos = NamaDosen;
    }
    
    public void TampilkanTglLahirDos (Date TglLahirDosen){
        TglLahir = TglLahirDosen;
    }
    
    public void TampilkanNikDos (int NikDosen){
        NIK = NikDosen;
    }
    
    public void TampilkanNamaKary (String NamaKaryawan){
        NmKary = NamaKaryawan;
    }
    
    public void TampilkanJabantanKary (String JabatanKaryawan){
        Jabatan = JabatanKaryawan;
    }
    
    public void TampilkanAlamatKary (String AlamatKaryawan){
        AlmtKary = AlamatKaryawan;
    }
    
    public void TampilkanGajiKary (Double GajiKaryawan){
        Gaji = GajiKaryawan;
    }
    
    public void TampilkanNamaMhs (String NamaMhs){
        NmMhs = NamaMhs;
    }
    
    public void TampilkanNimMhs (String NimMhs){
        NIM = NimMhs;
    }
    
    public void TampilkanAlamatMhs (String AlamatMhs){
        AlmtMhs = AlamatMhs;
    }
    
    public void TampilkanSemesterMhs (int SemMhs){
        NIK = SemMhs;
    }
    
    public static void main(String[] args){
    }
    
}
