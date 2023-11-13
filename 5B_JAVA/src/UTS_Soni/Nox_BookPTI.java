
package UTS_Soni;

/**
 *
 * @author Soni H (PTI 5B)
 */

import java.util.ArrayList;
import java.util.List;

class Book_Nox {
    private String JudulBuku_Nox;
    private String pengarangBuku_Nox;
    private int tahunTerbitBuku_Nox;
    private double hargaBuku_Nox;

    // Constructor Ke 1: isinya parameter lengkap
    public Book_Nox(String judul_Nox, String pengarang_Nox, int tahun_Nox, double harga_Nox) {
        this.JudulBuku_Nox = judul_Nox;
        this.pengarangBuku_Nox = pengarang_Nox;
        this.tahunTerbitBuku_Nox = tahun_Nox;
        this.hargaBuku_Nox = harga_Nox;
    }

    // Constructor Ke 2: isinya hanya parameter judul dan pengarang saja
    public Book_Nox(String judul2_Buku, String pengarang2_Buku) {
        this.JudulBuku_Nox = judul2_Buku;
        this.pengarangBuku_Nox = pengarang2_Buku;
        this.tahunTerbitBuku_Nox = 0; // kita jadikan nilai default untuk tahun terbit = 0
        this.hargaBuku_Nox = 0.0; // nilai default untuk harga buku = 0
    }

    // method getBookInfo untuk mendapatkan informasi tentang buku
    public String getBookInfo() {
        return "\tJudul Buku: " + JudulBuku_Nox + 
                "\n\tPengarang: " + pengarangBuku_Nox + 
                "; Tahun Terbit: " + tahunTerbitBuku_Nox + 
                "; Harga: Rp " + hargaBuku_Nox + "\n";
    }

    // method calculateDiscountedPrice untuk menghitung harga buku setelah diberikan diskon tertentu
    public double calculateDiscountedPrice(double potongan_Diskon) {
        double HrgSetelahDiskon = hargaBuku_Nox - (hargaBuku_Nox * potongan_Diskon / 100);
        return HrgSetelahDiskon;
    }
}

class Customer {
    private String namaPelanggan;
    private String alamatPelanggan;
    private List<Book_Nox> daftarPembelian; //import java.util.List;

    // Constructor 1 = parameter lengkap
    public Customer(String nama2_Pel, String address) {
        this.namaPelanggan = nama2_Pel;
        this.alamatPelanggan = address;
        this.daftarPembelian = new ArrayList<>();
    }

    // Constructor 2
    public Customer(String nama3_Pel) {
        this(nama3_Pel,"alamat kosong");
        this.daftarPembelian = new ArrayList<>();
    }
    
    // Metode untuk mendapatkan informasi pelanggan
    public String getCustomerInfo() {
        return "\tNama: " + namaPelanggan + "\n\tAlamat rumah: " + alamatPelanggan;
    }

    // method placeOrder untuk menempatkan pesanan dengan jumlah buku yang diinginkan.
    public void placeOrder(Book_Nox book, int quantity) {
        for (int i = 0; i < quantity; i++) {
            daftarPembelian.add(book);
        }
        System.out.println(quantity + " pcs: " + book.getBookInfo() + 
                "--> telah dimasukkan ke daftar belanja untuk pelanggan: " + namaPelanggan + "\n");
    }

    // method viewOrderHistory yang menampilkan riwayat pesanan pelanggan
    public void viewOrderHistory() {
        System.out.println("\nRiwayat pembelian oleh: " + namaPelanggan);
        for (Book_Nox book : daftarPembelian) {
            System.out.println(book.getBookInfo());
        }
    }
}

class BookStore {
    private List<Book_Nox> bukuYangTersedia; //import java.util.List;

    // Constructor 1: constructor untuk menginisialisasi toko dengan daftar buku yang tersedia
    public BookStore(List<Book_Nox> daftarBukuTersedia) { //import java.util.List;
        this.bukuYangTersedia = daftarBukuTersedia;
    }

    // Constructor 2
    public BookStore() {
        this.bukuYangTersedia = new ArrayList<>();
    }

    // method displayAvailableBooks untuk menampilkan buku-buku yang tersedia di toko
    public void displayAvailableBooks() {
        System.out.println("Daftar buku yang tersedia di toko ini:");
        for (Book_Nox book : bukuYangTersedia) {
            System.out.println(book.getBookInfo());
        }
    }
}

// Mewakili keranjang belanja yang berisi buku-buku yang dipilih oleh pelanggan
class ShoppingCart {
    private List<Book_Nox> keranjang_Nox; //import java.util.List;

    // Constructor 1
    public ShoppingCart() {
        this.keranjang_Nox = new ArrayList<>();
    }

    // Constructor 2
    public ShoppingCart(List<Book_Nox> keranjangBuku) { //import java.util.List;
        this.keranjang_Nox = keranjangBuku;
    }

    // method addToCart untuk menambahkan buku ke dalam keranjang
    public void addToCart(Book_Nox bukuNox) {
        keranjang_Nox.add(bukuNox);
        System.out.println(bukuNox.getBookInfo() + "-->dimasukkan ke daftar belanjaan");
    }

    // method bayarNox untuk menyelesaikan pembelian dan menghitung totalBayar harga
    public double bayarNox() {
        double totalBayar = 0.0;
        for (Book_Nox bukuJuga : keranjang_Nox) {
            totalBayar += bukuJuga.calculateDiscountedPrice(10); // Assume a 10% discount for all books
        }
        System.out.println("\nTotal price after discount: Rp" + totalBayar);
        return totalBayar;
    }
}

// class utilitas yang menangani penerapan diskon pada totalBayar pembelian
class Discount {
    private double persenDiskon;
    private double nilaiDiskon;

    // Constructor 1: overloading constructor untuk mendukung diskon dengan persentase
    public Discount(double percentage) {
        this.persenDiskon = percentage;
        this.nilaiDiskon = 0.0; // Nilai diskon diatur ke 0 karena diskon berdasarkan persentase
    }

    // Constructor 2: Diskon berdasarkan nilai tertentu
    public Discount(double persenJUGA, double nilaiJUGA) {
        this.persenDiskon = persenJUGA;
        this.nilaiDiskon = nilaiJUGA;
    }
}

public class Nox_BookPTI {

    public static void main(String[] args) {
        Book_Nox Komik_1 = new Book_Nox("One Piece", "Eichiro Oda", 1995, 30000);
        Book_Nox Komik_2 = new Book_Nox("Naruto", "Masashi Kishimoto", 1996, 35000);
        Book_Nox Komik_3 = new Book_Nox("Bleach", "Kubo Tite", 1997, 40000);
        Book_Nox Komik_4 = new Book_Nox("Jujutsu Kaisen", "Gege Akutami", 1998, 45000);
        Book_Nox Komik_5 = new Book_Nox("Kimetsu No Yaiba", "Koyoharu Gotouge", 1999, 50000);
        Book_Nox Komik_6 = new Book_Nox("Black Clover", "Yuki Tabata", 2000, 55000);
        Book_Nox Komik_7 = new Book_Nox("Fairy Tail", "Hiro Mashima", 2001, 60000);
        Book_Nox Komik_8 = new Book_Nox("Witch Hunter", "Cho Jung-man", 2002, 65000);
        Book_Nox Komik_9 = new Book_Nox("Battle Through Heavens", "Tiancan Tudou", 2003, 70000);
        Book_Nox Komik_10 = new Book_Nox("Soul Land", "Tang Jia San Shao", 2004, 75000);

        // Create a bukuJuga store with available books
        List<Book_Nox> bukuTersedia = new ArrayList<>();
        bukuTersedia.add(Komik_1);
        bukuTersedia.add(Komik_2);
        bukuTersedia.add(Komik_3);
        bukuTersedia.add(Komik_4);
        bukuTersedia.add(Komik_5);
        bukuTersedia.add(Komik_6);
        bukuTersedia.add(Komik_7);
        bukuTersedia.add(Komik_8);
        bukuTersedia.add(Komik_9);
        bukuTersedia.add(Komik_10);
        BookStore tokoBuku = new BookStore(bukuTersedia);

        // Display available books in the store
        tokoBuku.displayAvailableBooks();

        // Create a pelanggan
        Customer pelanggan = new Customer("Alice","Jln. Raya Besar Sekali");
        
        // Menampilkan informasi pelanggan
        System.out.println("Info Pelanggan 1:\n" + pelanggan.getCustomerInfo() + "\n");

        // Place orders for books
        pelanggan.placeOrder(Komik_1, 2);
        pelanggan.placeOrder(Komik_2, 1);

        // View order history
        pelanggan.viewOrderHistory();

        // Create a shopping keranjang_Nox
        ShoppingCart keranjangKuning = new ShoppingCart();

        // Add books to the shopping keranjang_Nox
        keranjangKuning.addToCart(Komik_1);
        keranjangKuning.addToCart(Komik_2);

        // Checkout and calculate the totalBayar hargaBuku_Nox
        keranjangKuning.bayarNox();
    }
}
