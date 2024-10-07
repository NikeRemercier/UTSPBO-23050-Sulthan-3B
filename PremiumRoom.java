package Tugas_Asdos.UTS_PBO;

// Kelas PremiumRoom yang merupakan subclass dari kelas Room
// Kelas ini digunakan untuk tipe kamar premium yang memiliki harga lebih tinggi dari tipe kamar biasa
public class PremiumRoom extends Room {
    
    // Konstruktor PremiumRoom yang menerima nomor kamar dan tipe kamar
    // Menggunakan keyword 'super' untuk memanggil konstruktor kelas induk (Room)
    public PremiumRoom(int nomorKamar, String tipeKamar) {
        super(nomorKamar, tipeKamar); // Memanggil konstruktor Room dengan parameter nomorKamar dan tipeKamar
        this.harga += 50000; // Menambahkan Rp. 50,000 ke harga dasar sebagai biaya tambahan untuk kamar premium
    }

    // Override (menimpa) method pesanKamar dari kelas induk
    @Override
    public void pesanKamar() {
        super.pesanKamar(); // Memanggil metode pesanKamar dari kelas induk (Room) untuk memesan kamar
        // Setelah memanggil metode induk, menampilkan pesan khusus untuk kamar premium
        System.out.println("Anda telah memesan kamar premium.");
    }
}
