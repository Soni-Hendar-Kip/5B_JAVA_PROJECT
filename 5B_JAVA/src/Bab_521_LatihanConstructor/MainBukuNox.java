
package Bab_521_LatihanConstructor;

/**
 *
 * @author Soni H (PTI 5B)
 */
public class MainBukuNox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClassBukuNox playBuku1 = new ClassBukuNox("Eichiro Oda", "One Piece", 1998, 1, 40000);
        ClassBukuNox playBuku2 = new ClassBukuNox("Masashi Kishimoto", "Naruto", 2000, 1, 42000);
        ClassBukuNox playBuku3 = new ClassBukuNox("Kubo Tite", "Bleach", 2001, 1, 43000);
        ClassBukuNox playBuku4 = new ClassBukuNox("Gege Akutami", "Jujutsu Kaisen", 2021, 1, 45000);
        ClassBukuNox playBuku5 = new ClassBukuNox("Masashi Kishimoto", "Boruto", 2020, 1, 44000);
        ClassBukuNox playBuku6 = new ClassBukuNox("Koyoharu Gotouge", "Demon Slayer: Kimetsu no yaiba", 2020, 1, 46000);
        ClassBukuNox playBuku7 = new ClassBukuNox("Yuki Tabata", "Black Clover", 2004, 1, 48000);
        ClassBukuNox playBuku8 = new ClassBukuNox("Kubo Tite", "Burn The Witch", 2005, 1, 47000);
        ClassBukuNox playBuku9 = new ClassBukuNox("Hiro Mashima", "Fairy Tail", 2006, 1, 49000);
        ClassBukuNox playBuku10 = new ClassBukuNox("Cho Jung-man", "Witch Hunter", 2007, 1, 5000);

        playBuku1.infoBukuKu();
        playBuku2.infoBukuKu();
        playBuku3.infoBukuKu();
        playBuku4.infoBukuKu();
        playBuku5.infoBukuKu();
        playBuku6.infoBukuKu();
        playBuku7.infoBukuKu();
        playBuku8.infoBukuKu();
        playBuku9.infoBukuKu();
    }
}
