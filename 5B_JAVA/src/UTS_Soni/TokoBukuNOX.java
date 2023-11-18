
package UTS_Soni;

/**
 *
 * @author Soni H (PTI 5B)
 */
import java.util.ArrayList;

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
        this.tahunTerbitBuku_Nox = 0;
        this.hargaBuku_Nox = 0.0;
    }

    // method getBookInfo untuk mendapatkan informasi tentang buku
    public String getBookInfo() {
        return "\t"
                + "Judul Buku: " + JudulBuku_Nox + "\n\t"
                + "Pengarang: " + pengarangBuku_Nox + "\n\t"
                + "Tahun terbit: " + tahunTerbitBuku_Nox + "\n\t"
                + "Harga: Rp. " + hargaBuku_Nox + "\n";
    }

    // method calculateDiscountedPrice untuk menghitung harga buku setelah diberikan diskon tertentu
    public double calculateDiscountedPrice(DiskonKU jmlDiskon) {
        return jmlDiskon.applyDiscount(hargaBuku_Nox);
    }
}

class Customer {
    private String namaPelanggan;
    private String alamatPelanggan;
    private ArrayList<Book_Nox> daftarPelanggan;

    // Constructor 1 = parameter lengkap
    public Customer(String namaPel, String almtPel) {
        this.namaPelanggan = namaPel;
        this.alamatPelanggan = almtPel;
        this.daftarPelanggan = new ArrayList<>();
    }
    
    // Method untuk menambahkan pelanggan ke dalam database
    public void addCustomer(Customer pembeli) {
        daftarPelanggan.add(pembeli);
    }

    // Constructor 2
    public Customer(String namaPel2, ArrayList<Book_Nox> daftarBeli) {
        this.namaPelanggan = namaPel2;
        this.daftarPelanggan = daftarBeli;
    }
    
    // Metode untuk mendapatkan informasi pelanggan
    public String getCustomerInfo() {
        return "\t"
                + "Nama: " + namaPelanggan + "\n\t"
                + "Alamat rumah: " + alamatPelanggan;
    }
    
    // method displayAvailableBooks untuk menampilkan buku-buku yang tersedia di toko
    public ArrayList<Book_Nox> TampilDaftarPelanggan() {
        System.out.println("Daftar Nama Pelanggan:");
        for (Book_Nox book : daftarPelanggan) {
            System.out.println(book.getBookInfo());
        }
        return daftarPelanggan;
    }

    // method placeOrder untuk menempatkan pesanan dengan jumlah buku yang diinginkan.
    public void placeOrder(BookStore buku, ShoppingCart keranjangg, int jumlahBuku) {
        Book_Nox pilihBuku = buku.displayAvailableBooks().get(0); // For simplicity, select the first available book
        keranjangg.addToCart(pilihBuku, jumlahBuku);
    }

    // method viewOrderHistory yang menampilkan riwayat pesanan pelanggan
    public void viewOrderHistory() {
        System.out.println("\n"
                + "Riwayat pembelian oleh: " + namaPelanggan + ":");
        for (Book_Nox book : daftarPelanggan) {
            System.out.println(book.getBookInfo());
        }
    }
}

class BookStore {
    private ArrayList<Book_Nox> bukuYangTersedia;

    // Constructor 1: constructor untuk menginisialisasi toko dengan daftar buku yang tersedia
    public BookStore(ArrayList<Book_Nox> bukuTersedia) { //import java.util.List;
        this.bukuYangTersedia = bukuTersedia;
    }

    // Constructor 2
    public BookStore() {
        this.bukuYangTersedia = new ArrayList<>();
    }

    // method displayAvailableBooks untuk menampilkan buku-buku yang tersedia di toko
    public ArrayList<Book_Nox> displayAvailableBooks() {
        System.out.println("Buku Tersedia:");
        for (Book_Nox book : bukuYangTersedia) {
            System.out.println(book.getBookInfo());
        }
        return bukuYangTersedia;
    }
}

class ShoppingCart {
    private ArrayList<Book_Nox> ItemBuku; //import java.util.List;

    // Constructor 1
    public ShoppingCart() {
        this.ItemBuku = new ArrayList<>();
    }

    // Constructor 2
    public ShoppingCart(ArrayList<Book_Nox> ItemBukuJuga) {
        this.ItemBuku = ItemBukuJuga;
    }

    // method addToCart untuk menambahkan buku ke dalam keranjang
    public void addToCart(Book_Nox BukuJuga, int JumlahItemKeranjang) {
        for (int i = 0; i < JumlahItemKeranjang; i++) {
            ItemBuku.add(BukuJuga);
        }
        System.out.println("Buku telah dimaksukkan keranjang: " + BukuJuga.getBookInfo());
    }

    // Method untuk checkout dan menghitung jumlah yang harus di bayar
    public double checkout(DiskonKU diskonBUKU) {
        double totalHARGA = 0.0;
        for (Book_Nox BukuLagi : ItemBuku) {
            totalHARGA += BukuLagi.calculateDiscountedPrice(diskonBUKU);
        }
        ItemBuku.clear(); // Membersihkan kerjangg setelah chekout
        System.out.println("Total Price after Discount: $" + totalHARGA);
        return totalHARGA;
    }
}

class DiskonKU {
    private double persenDiskonNX;
    private double nilaiDiskon;

    // Constructor 1: DiskonKU berdasarkan persentase
    public DiskonKU(double PersenDis) {
        this.persenDiskonNX = PersenDis;
        this.nilaiDiskon = 0.0;
    }

    // Constructor 2: DiskonKU berdasarkan nilai diskon tertentu
    public DiskonKU(double persenDiskonJuga, double NilaiLagi) {
        this.persenDiskonNX = persenDiskonJuga;
        this.nilaiDiskon = NilaiLagi;
    }

    // Method untuk menghitung diskon
    public double applyDiscount(double HargaAsli) {
        double NilaiDiskon = HargaAsli;
        if (HargaAsli > 100000) {
            NilaiDiskon -= HargaAsli * (persenDiskonNX / 100.0);
        } else if (HargaAsli > 50000) {
            NilaiDiskon -= HargaAsli * (5.0 / 100.0);
        }
        return NilaiDiskon > 0 ? NilaiDiskon : 0;
    }
}

public class TokoBukuNOX {
    public static void main(String[] args) {
        // Daftar Buku
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

        // List Menampilkan Daftar Buku
        ArrayList<Book_Nox> bukuTersedia = new ArrayList<>();
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
        BookStore tokoBukuNox = new BookStore(bukuTersedia);

        // Pembeli
        Customer pelangganTetap1 = new Customer("Yaning","Jln. Raya Besar Sekali");
        Customer pelangganTetap2 = new Customer("Meru","Jln. Raya Gitar Spanyol");
        Customer pelangganTetap3 = new Customer("Linda","Jln. Raya Tinggi Langsing");
        
        // List Menampilkan Daftar Pelanggan
        ArrayList<Book_Nox> daftarPelanggan = new ArrayList<>();
        daftarPelanggan.add(pelangganTetap1);
        daftarPelanggan.add(pelangganTetap2);
        daftarPelanggan.add(pelangganTetap3);
        BookStore DaftarPembeliKu = new BookStore(daftarPelanggan);

        // Kernajnag Belanja
        ShoppingCart keranjangBelanja = new ShoppingCart();

        // Pembeli memilih buku
        pelangganTetap1.placeOrder(tokoBukuNox, keranjangBelanja, 2);

        // Display the shopping cart
        keranjangBelanja.checkout(new DiskonKU(10)); // Apply a 10% discount

        // View the order history of the customer
        pelangganTetap1.viewOrderHistory();
        
        // Display available books in the store
        // tokoBukuNox.displayAvailableBooks();
    }
}

