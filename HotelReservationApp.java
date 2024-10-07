package Tugas_Asdos.UTS_PBO;

import java.util.Scanner;

// Kelas utama untuk menjalankan aplikasi reservasi hotel
public class HotelReservationApp {
    private static Room[] daftarKamar = new Room[15]; // Array untuk menyimpan 15 kamar hotel

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi 15 kamar hotel dengan tipe Single, Double, dan Deluxe
        // 5 kamar pertama adalah Single, 5 kamar berikutnya adalah Double, dan 5 kamar terakhir adalah Deluxe
        for (int i = 0; i < 5; i++) {
            daftarKamar[i] = new Room(i + 1, "Single");
            daftarKamar[i + 5] = new Room(i + 1, "Double");
            daftarKamar[i + 10] = new PremiumRoom(i + 1, "Deluxe"); // Kamar deluxe menggunakan subclass PremiumRoom
        }

        // Input untuk nama pengguna
        System.out.print("Masukkan nama Anda: ");
        String namaPengguna = scanner.nextLine(); // Menyimpan nama pengguna

        // Menampilkan pesan sambutan untuk pengguna
        System.out.println("\nSelamat datang di Hotel Reservation System, " + namaPengguna + "!");

        boolean keluarAplikasi = false; // Flag untuk keluar dari aplikasi
        while (!keluarAplikasi) { // Loop utama untuk menampilkan menu
            int aksesLevel = 0;
            boolean loginSukses = false; // Variabel untuk memastikan input yang valid

            // Looping sampai user memilih level akses yang benar
            while (!loginSukses) {
                // Menu login sebagai admin atau customer
                System.out.println("\nLogin sebagai: ");
                System.out.println("1. Admin");
                System.out.println("2. Customer");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan Anda (1 atau 2 atau 3 untuk keluar): ");
                aksesLevel = scanner.nextInt(); // Meminta input pengguna

                // Mengecek apakah input valid (1, 2, atau 3)
                if (aksesLevel == 1 || aksesLevel == 2 || aksesLevel == 3) {
                    loginSukses = true; // Input valid
                } else {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.\n");
                }
            }

            // Jika pengguna memilih Admin
            if (aksesLevel == 1) {
                adminMenu(scanner); // Masuk ke menu admin
            }
            // Jika pengguna memilih Customer
            else if (aksesLevel == 2) {
                customerMenu(scanner, namaPengguna); // Masuk ke menu customer
            }
            // Jika pengguna memilih Keluar
            else if (aksesLevel == 3) {
                keluarAplikasi = true; // Mengakhiri loop dan keluar aplikasi
            }
        }

        // Menutup scanner setelah aplikasi selesai digunakan
        scanner.close();
    }

    // Menu untuk admin, berisi opsi melihat semua kamar atau hanya yang tersedia
    public static void adminMenu(Scanner scanner) {
        while (true) { // Looping untuk menu admin
            System.out.println("\nMenu Admin:");
            System.out.println("1. Lihat semua kamar");
            System.out.println("2. Lihat kamar yang tersedia");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt(); // Mengambil input admin

            // Menampilkan semua kamar
            if (pilihan == 1) {
                tampilkanSemuaKamar();
            }
            // Menampilkan hanya kamar yang masih tersedia
            else if (pilihan == 2) {
                tampilkanKamarTersedia();
            }
            // Keluar dari menu admin
            else if (pilihan == 3) {
                break;
            }
            // Jika input tidak valid
            else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    // Menu untuk customer, berisi opsi untuk memesan kamar atau cek ketersediaan kamar
    public static void customerMenu(Scanner scanner, String namaPengguna) {
        boolean selesai = false; // Flag untuk mengecek apakah customer selesai memesan
        while (!selesai) { // Looping sampai customer memilih untuk keluar
            System.out.println("\nMenu Customer:");
            System.out.println("1. Pesan kamar");
            System.out.println("2. Cek ketersediaan kamar");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt(); // Mengambil input customer

            // Customer ingin memesan kamar
            if (pilihan == 1) {
                pesanKamar(scanner); // Memanggil fungsi pemesanan kamar
            }
            // Customer ingin mengecek ketersediaan kamar
            else if (pilihan == 2) {
                tampilkanKamarTersedia(); // Menampilkan kamar yang masih tersedia
            }
            // Customer ingin keluar
            else if (pilihan == 3) {
                selesai = true; // Keluar dari loop dan menu customer
            }
            // Jika input tidak valid
            else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    // Menampilkan semua kamar, baik yang tersedia maupun yang sudah dipesan
    public static void tampilkanSemuaKamar() {
        for (Room room : daftarKamar) {
            room.tampilkanDetailKamar(); // Memanggil method di setiap objek Room untuk menampilkan detail kamar
        }
    }

    // Menampilkan hanya kamar yang tersedia (belum dipesan)
    public static void tampilkanKamarTersedia() {
        for (Room room : daftarKamar) {
            if (room.cekKetersediaan()) { // Mengecek apakah kamar masih tersedia
                room.tampilkanDetailKamar(); // Menampilkan detail kamar yang tersedia
            }
        }
    }

    // Proses pemesanan kamar oleh customer
    public static void pesanKamar(Scanner scanner) {
        System.out.println("\nPilih tipe kamar:");
        System.out.println("1. Single");
        System.out.println("2. Double");
        System.out.println("3. Deluxe");
        System.out.print("Masukkan pilihan tipe kamar: ");
        int tipeKamar = scanner.nextInt(); // Mengambil input tipe kamar dari customer

        // Menampilkan kamar yang tersedia sesuai dengan tipe yang dipilih
        boolean adaKamarTersedia = false; // Flag untuk mengecek apakah ada kamar yang sesuai dengan tipe
        for (Room room : daftarKamar) {
            // Mengecek ketersediaan kamar sesuai tipe yang dipilih
            if (room.cekKetersediaan() && ((tipeKamar == 1 && room.tipeKamar.equals("Single"))
                    || (tipeKamar == 2 && room.tipeKamar.equals("Double"))
                    || (tipeKamar == 3 && room.tipeKamar.equals("Deluxe")))) {
                room.tampilkanDetailKamar(); // Menampilkan detail kamar yang tersedia
                adaKamarTersedia = true; // Menandakan ada kamar yang tersedia
            }
        }

        // Jika tidak ada kamar tersedia untuk tipe yang dipilih
        if (!adaKamarTersedia) {
            System.out.println("Tidak ada kamar tersedia untuk tipe yang dipilih.");
            return; // Keluar dari method jika tidak ada kamar
        }

        // Customer memilih nomor kamar yang ingin dipesan
        System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
        int nomorKamar = scanner.nextInt(); // Mengambil input nomor kamar dari customer

        // Mengecek apakah kamar yang dipilih sesuai dengan tipe dan tersedia
        boolean kamarDipesan = false; // Flag untuk mengecek apakah kamar berhasil dipesan
        for (Room room : daftarKamar) {
            // Mengecek nomor kamar dan ketersediaan sesuai tipe yang dipilih
            if (room.nomorKamar == nomorKamar && room.cekKetersediaan() &&
                    ((tipeKamar == 1 && room.tipeKamar.equals("Single")) ||
                            (tipeKamar == 2 && room.tipeKamar.equals("Double")) ||
                            (tipeKamar == 3 && room.tipeKamar.equals("Deluxe")))) {
                room.pesanKamar(); // Memesan kamar jika valid
                kamarDipesan = true; // Menandakan kamar berhasil dipesan
                break; // Keluar dari loop setelah kamar dipesan
            }
        }

        // Jika kamar tidak berhasil dipesan (sudah dipesan atau tidak sesuai)
        if (!kamarDipesan) {
            System.out.println("Kamar tidak ditemukan atau sudah dipesan.");
        }
    }
}
