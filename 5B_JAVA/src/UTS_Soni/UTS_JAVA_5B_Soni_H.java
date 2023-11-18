
package UTS_Soni;
/*
*** Author: Soni H (PTI 5B)
*/

import java.util.ArrayList;
import java.util.List;

class Book_NOX {
    private String judulBukuNox;
    private String pengarangBukuNox;
    private int tahunTerbitNox;
    private double hargaBukuNox;

    public Book_NOX(String judulBK, String pengarangBK, int tahunBK, double hargaBK) {
        this.judulBukuNox = judulBK;
        this.pengarangBukuNox = pengarangBK;
        this.tahunTerbitNox = tahunBK;
        this.hargaBukuNox = hargaBK;
    }

    // berisi data buku
    public String getBookInfo() {
        return "\t"
                + "Judul: " + judulBukuNox + "\n\t"
                + "Pengarang: " + pengarangBukuNox + "\n\t"
                + "Tahun terbit: " + tahunTerbitNox + "\n\t"
                + "Harga (K): Rp " + hargaBukuNox + "\n";
    }

    public String getTitle() {
        return judulBukuNox;
    }

    public double getPrice() {
        return hargaBukuNox;
    }
}

class BookStore {
    private List<Book_NOX> bukuYangTersediaNox; // List adalah libari import java.util.List;

    public BookStore(List<Book_NOX> tersediaBK) {
        this.bukuYangTersediaNox = tersediaBK;
    }

    // menampilkan daftar buku
    public void displayAvailableBooks() {
        System.out.println("Daftar Buku yang tersedia: \n");
        for (Book_NOX buku_ku : bukuYangTersediaNox) {
            System.out.println(buku_ku.getBookInfo());
            System.out.println("\t------------------------");
        }
    }
}

class Customer {
    private String namaPembeliNox;
    private String alamatPembeliNox;
    private Keranjang ranjangBelanjaNox;
    private List<String> riwayatBelanjaNox;

    public Customer(String name, String address) {
        this.namaPembeliNox = name;
        this.alamatPembeliNox = address;
        this.ranjangBelanjaNox = new Keranjang();
        this.riwayatBelanjaNox = new ArrayList<>();
    }

    // berisi info data pembeli/pelanggan
    public String getCusInfo() {
        return "\t"
                + "Nama pembeli: " + namaPembeliNox + "\n\t"
                + "Alamat: " + alamatPembeliNox;
    }
    
    // menampilkan daftar pembeli
    public void displayCustomerInfo() {
        System.out.println("\n"
                + "Informasi Pelanggan: ");
        System.out.println(getCusInfo());
        System.out.println("\t------------------\n");
    }

    // memasukkan buku ke dalam item belanja
    public void placeOrder(Book_NOX bukuLAGI, int quantity) {
        ranjangBelanjaNox.addToCart(bukuLAGI, quantity);
        riwayatBelanjaNox.add("\t" + quantity + " copies of \"" + bukuLAGI.getTitle() + "\"");
    }
    
    //menampilkan harga hasil hitungan diskon
    public double checkout(Discount discount) {
        double totalHargaSebelumDiskon = 0;
        for (Book_NOX bukuJUGA : ranjangBelanjaNox.getCart()) { // ambil jumlah item dari Cart
            totalHargaSebelumDiskon += bukuJUGA.getPrice(); //menghitung harga totalBB sebelum diskon
        }

        // memasukkan hitungan diskon sesuai kondisi pada method 
        double hargaSesudahDiskon = discount.calculateDiscountedPrice(totalHargaSebelumDiskon);

        riwayatBelanjaNox.add("Total Pembelian (Sebelum DIskon): RP " + totalHargaSebelumDiskon); //menampilkan harga non diskon
        riwayatBelanjaNox.add("TOtal Setelah Diskon: Rp " + hargaSesudahDiskon); //menampilkan harga sesudah dikurangi diskon

        ranjangBelanjaNox.clearCart(); //membersihkan data pada cart
        return hargaSesudahDiskon;
    }

    // menampilkan buku yang telah dibeli
    public void viewOrderHistory() {
        System.out.println("\n"
                + "Riwayat belanja:");
        for (String order : riwayatBelanjaNox) {
            System.out.println(order);
            System.out.println("\t------------------------");
        }
    }
}

class Keranjang {
    private List<Book_NOX> cart;

    public Keranjang() {
        this.cart = new ArrayList<>();
    }

    // method untuk memasukkan ke cart
    public void addToCart(Book_NOX bukuBB, int jmlBarang) {
        for (int i = 0; i < jmlBarang; i++) {
            cart.add(bukuBB);
        }
        System.out.println(jmlBarang + " pcs buku \"" + bukuBB.getTitle() + "\" dimasukkan keranjang.");
    }
    
    public List<Book_NOX> getCart() { //mengambil data dari cart
        return cart;
    }
    
    public void clearCart() { //mebersihkan data di cart
        cart.clear();
    }

    public double checkout(Discount diskon_Nox) {
        double totalBB = 0;
        for (Book_NOX bookTT : cart) {
            totalBB += bookTT.getPrice();
        }
        double hargaDiskonJUGA = diskon_Nox.calculateDiscountedPrice(totalBB);
        cart.clear();
        return hargaDiskonJUGA;
    }
}

class Discount {
    private double nilaiPersenDiskon;

    public Discount() {
        this.nilaiPersenDiskon = 0; //menentukan nilai presentase besaran diskon, misal 5% 10%
    }

    public Discount(double diskonPersen) {
        this.nilaiPersenDiskon = diskonPersen;
    }

    public Discount(int nilaiDiskonPersenTT) {
        // Assume nilaiDiskonPersenTT is a fixed diskonGG amount
        this.nilaiPersenDiskon = (double) nilaiDiskonPersenTT / 100;
    }

    //menentukan besaran diskon dengan kondisi tertentu sesuai jumlah pembelian
    public double calculateDiscountedPrice(double totalPrice) {
        if (totalPrice < 50) {
            return totalPrice; // No diskonGG
        } else if (totalPrice >= 51 && totalPrice < 100) {
            return totalPrice * (1 - 0.05); // 5% diskonGG
        } else if (totalPrice >= 101 && totalPrice < 1000) {
            return totalPrice * (1 - 0.08); // 8% diskonGG
        } else {
            return totalPrice * (1 - nilaiPersenDiskon);
        }
    }
}

public class UTS_JAVA_5B_Soni_H {
    public static void main(String[] args) {
        // Sample usage of the classes
        Book_NOX book1 = new Book_NOX("One Piece", "Eichiro Oda", 1995, 30);
        Book_NOX book2 = new Book_NOX("Naruto", "Masashi Kishimoto", 1996, 55);
        Book_NOX book3 = new Book_NOX("Bleach", "Kubo Tite", 1997, 70);
        Book_NOX book4 = new Book_NOX("Kimetsu No Yaiba", "Koyoharu Gotouge", 1998, 95);
        Book_NOX book5 = new Book_NOX("Battle Through Heavens", "Tiancan Tudou", 1999, 105);

        List<Book_NOX> bukuTersediaMM = new ArrayList<>();
        bukuTersediaMM.add(book1);
        bukuTersediaMM.add(book2);
        bukuTersediaMM.add(book3);
        bukuTersediaMM.add(book4);
        bukuTersediaMM.add(book5);

        BookStore tokoKU = new BookStore(bukuTersediaMM);

        Customer customer = new Customer("Yaning", "Jln. Raya besar sekali");
        Customer customer2 = new Customer("Meru", "Jln. Raya gitar spanyol");
        Customer customer3 = new Customer("Linda", "Jln. Raya tinggi langsing");

        tokoKU.displayAvailableBooks();
        
        customer.displayCustomerInfo();
        //customer2.displayCustomerInfo();
        //customer3.displayCustomerInfo();

        customer.placeOrder(book1, 2);
        customer.placeOrder(book2, 1);

        Discount diskonGG = new Discount();
        double hargaDiskonPP = customer.checkout(diskonGG);

        customer.viewOrderHistory();
    }
}
