
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

    // Constructor Ke 1
    public Book_Nox(String judul_Nox, String pengarang_Nox, int tahun_Nox, double harga_Nox) {
        this.JudulBuku_Nox = judul_Nox;
        this.pengarangBuku_Nox = pengarang_Nox;
        this.tahunTerbitBuku_Nox = tahun_Nox;
        this.hargaBuku_Nox = harga_Nox;
    }

    // Constructor Ke 2
    public Book_Nox(String judul2_Buku, String pengarang2_Buku) {
        this.JudulBuku_Nox = judul2_Buku;
        this.pengarangBuku_Nox = pengarang2_Buku;
        this.tahunTerbitBuku_Nox = 0;
        this.hargaBuku_Nox = 0.0;
    }

    // method getBookInfo untuk mendapatkan informasi tentang buku
    public String getBookInfo() {
        return "Judul Buku: " + JudulBuku_Nox + "\nPengarang: " + pengarangBuku_Nox + "\nTahun Terbit: " + tahunTerbitBuku_Nox + "\nHarga: $" + hargaBuku_Nox;
    }

    // method calculateDiscountedPrice untuk menghitung harga buku setelah diberikan diskon tertentu
    public double calculateDiscountedPrice(double potongan_Diskon) {
        double HrgSetelahDiskon = hargaBuku_Nox - (hargaBuku_Nox * potongan_Diskon / 100);
        return HrgSetelahDiskon;
    }
}

class Customer {
    private String namaPelanggan;
    private List<Book_Nox> daftarPembelian; //import java.util.List;

    // Constructor 1
    public Customer(String nama2_Pel) {
        this.namaPelanggan = nama2_Pel;
        this.daftarPembelian = new ArrayList<>();
    }

    // Constructor 2
    public Customer() {
        this.namaPelanggan = "Guest";
        this.daftarPembelian = new ArrayList<>();
    }

    // method placeOrder untuk menempatkan pesanan dengan jumlah buku yang diinginkan.
    public void placeOrder(Book_Nox book, int quantity) {
        for (int i = 0; i < quantity; i++) {
            daftarPembelian.add(book);
        }
        System.out.println(quantity + " copies of '" + book.getBookInfo() + "' added to the order history for customer: " + namaPelanggan);
    }

    // method viewOrderHistory yang menampilkan riwayat pesanan pelanggan
    public void viewOrderHistory() {
        System.out.println("Order History for Customer: " + namaPelanggan);
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
        System.out.println("Available Books in the Bookstore:");
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
        System.out.println("'" + bukuNox.getBookInfo() + "' added to the shopping cart.");
    }

    // method bayarNox untuk menyelesaikan pembelian dan menghitung totalBayar harga
    public double bayarNox() {
        double totalBayar = 0.0;
        for (Book_Nox bukuJuga : keranjang_Nox) {
            totalBayar += bukuJuga.calculateDiscountedPrice(10); // Assume a 10% discount for all books
        }
        System.out.println("Total price after discount: $" + totalBayar);
        return totalBayar;
    }
}

// class utilitas yang menangani penerapan diskon pada totalBayar pembelian
class Discount {
    private double persenDiskon;
    private double nilaiDiskon;

    // Constructor 1: overloading constructor untuk mendukung diskon dengan persentase atau nilai tertentu
    public Discount(double percentage) {
        this.persenDiskon = percentage;
        this.nilaiDiskon = 0.0;
    }

    // Constructor 2
    public Discount(double persenJUGA, double nilaiJUGA) {
        this.persenDiskon = persenJUGA;
        this.nilaiDiskon = nilaiJUGA;
    }
}

public class Nox_BookPTI {

    public static void main(String[] args) {
        Book_Nox book1 = new Book_Nox("Java Programming", "John Doe", 2020, 39.99);
        Book_Nox book2 = new Book_Nox("Data Structures", "Jane Smith", 2018, 29.99);

        // Create a bukuJuga store with available books
        List<Book_Nox> availableBooks = new ArrayList<>();
        availableBooks.add(book1);
        availableBooks.add(book2);
        BookStore bookStore = new BookStore(availableBooks);

        // Display available books in the store
        bookStore.displayAvailableBooks();

        // Create a customer
        Customer customer = new Customer("Alice");

        // Place orders for books
        customer.placeOrder(book1, 2);
        customer.placeOrder(book2, 1);

        // View order history
        customer.viewOrderHistory();

        // Create a shopping keranjang_Nox
        ShoppingCart shoppingCart = new ShoppingCart();

        // Add books to the shopping keranjang_Nox
        shoppingCart.addToCart(book1);
        shoppingCart.addToCart(book2);

        // Checkout and calculate the totalBayar hargaBuku_Nox
        shoppingCart.bayarNox();
    }
}
