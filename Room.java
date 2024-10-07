package Tugas_Asdos.UTS_PBO;

// Kelas Room untuk merepresentasikan objek kamar di hotel
public class Room implements Reservasi {
    int nomorKamar;          // Menyimpan nomor kamar
    String tipeKamar;        // Menyimpan tipe kamar (Single, Double, Deluxe)
    boolean tersedia;        // Menyimpan status ketersediaan kamar (true = tersedia, false = sudah dipesan)
    double harga;            // Menyimpan harga kamar

    // Konstruktor untuk menginisialisasi objek Room berdasarkan nomor dan tipe kamar
    public Room(int nomorKamar, String tipeKamar) {
        this.nomorKamar = nomorKamar;   // Menginisialisasi nomor kamar
        this.tipeKamar = tipeKamar;     // Menginisialisasi tipe kamar
        this.tersedia = true;           // Awalnya kamar selalu tersedia

        // Menentukan harga berdasarkan tipe kamar
        switch (tipeKamar.toLowerCase()) {
            case "single":
                this.harga = 100_000.0;  // Harga kamar Single adalah 100 ribu rupiah
                break;
            case "double":
                this.harga = 200_000.0;  // Harga kamar Double adalah 200 ribu rupiah
                break;
            case "deluxe":
                this.harga = 300_000.0;  // Harga kamar Deluxe adalah 300 ribu rupiah
                break;
            default:
                this.harga = 0.0;        // Jika tipe tidak valid, harga akan diset ke 0
        }
    }

    // Implementasi metode dari interface Reservasi untuk mengecek ketersediaan kamar
    @Override
    public boolean cekKetersediaan() {
        return tersedia;  // Mengembalikan status ketersediaan kamar (true/false)
    }

    // Implementasi metode dari interface Reservasi untuk memesan kamar
    @Override
    public void pesanKamar() {
        // Jika kamar tersedia, pesanan berhasil dan status kamar diubah menjadi tidak tersedia
        if (tersedia) {
            tersedia = false;  // Mengubah status ketersediaan kamar menjadi tidak tersedia
            System.out.println("Kamar " + nomorKamar + " berhasil dipesan!");
        } else {
            // Jika kamar sudah dipesan, tampilkan pesan bahwa kamar tidak tersedia
            System.out.println("Kamar " + nomorKamar + " tidak tersedia.");
        }
    }

    // Method untuk menampilkan detail kamar (nomor, tipe, harga, dan ketersediaan)
    public void tampilkanDetailKamar() {
        System.out.println("========================================");
        System.out.println("Nomor Kamar: " + nomorKamar);   // Menampilkan nomor kamar
        System.out.println("Tipe Kamar: " + tipeKamar);     // Menampilkan tipe kamar
        System.out.printf("Harga: Rp. %, .0f\n", harga);    // Menampilkan harga dalam format Rupiah
        System.out.println("Ketersediaan: " + (tersedia ? "Tersedia" : "Tidak Tersedia"));  // Menampilkan status ketersediaan
        System.out.println("========================================\n");
    }
}
