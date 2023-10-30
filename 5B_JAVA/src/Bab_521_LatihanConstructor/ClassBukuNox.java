/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab_521_LatihanConstructor;

/**
 *
 * @author Soni H (PTI 5B)
 */
public class ClassBukuNox {

    String namaPengarang, judulBuku;
    int tahunTerbit, cetakanKe;
    double hargaJual;

    public ClassBukuNox(
            String nmPengarangKU, String nmJudulBukuKU,
            int thnTerbitKU, int cetakKU,
            double hgrJualKU) {
        this.namaPengarang = nmPengarangKU;
        this.judulBuku = nmJudulBukuKU;
        this.tahunTerbit = thnTerbitKU;
        this.cetakanKe = cetakKU;
        this.hargaJual = hgrJualKU;
    }

    public void infoBukuKu() {
        System.out.println("Nama Pengarang: " + namaPengarang
                + "\nJudul Buku: " + judulBuku
                + "\nTahun Terbir: " + tahunTerbit
                + "\nCetakan ke: " + cetakanKe
                + "\nHarga Jual: \n\n" + hargaJual);
    }
}
