package Tugas_Asdos.UTS_PBO;

// Interface untuk reservasi kamar
// Interface ini mendefinisikan dua metode yang harus diimplementasikan oleh kelas-kelas yang melakukan reservasi kamar
public interface Reservasi {

    // Metode untuk memesan kamar
    // Setiap kelas yang mengimplementasikan interface ini harus menyediakan implementasi untuk metode ini
    // Metode ini akan berfungsi untuk melakukan tindakan pemesanan kamar
    void pesanKamar();

    // Metode untuk mengecek ketersediaan kamar
    // Kelas yang mengimplementasikan interface ini harus menyediakan logika untuk memeriksa apakah kamar tersedia atau tidak
    boolean cekKetersediaan();
}
