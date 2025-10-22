import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ====== LIST SEPEDA (WAJIB ADA) ======
        ArrayList<DaftarSepedaListrik> daftarSepeda = new ArrayList<>();
        ArrayList<RiwayatPeminjaman> riwayat = new ArrayList<>();

        // Membuat akun awal
        System.out.println("=== Membuat Akun Pemilik ===");
        System.out.print("Username Pemilik : ");
        String initialUser = sc.nextLine().trim();
        System.out.print("Password Pemilik : ");
        String initialPass = sc.nextLine();

        Login login = new Login(initialUser, initialPass);

        // Percobaan login (maks 3 kali)
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;
        while (attempts < MAX_ATTEMPTS && !login.isAuthenticated()) {
            System.out.println("\n--- Login Aplikasi ---");
            System.out.print("Username: ");
            String u = sc.nextLine().trim();
            System.out.print("Password: ");
            String p = sc.nextLine();

            if (login.authenticate(u, p)) {
                System.out.println("Login berhasil");
                break;
            } else {
                attempts++;
                System.out.println("Username atau Password salah. Coba lagi.");
            }
        }

        if (!login.isAuthenticated()) {
            System.out.println("Login gagal. Program selesai.");
            sc.close();
            return;
        }

        // Menu aplikasi
        boolean running = true;
        while (running) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Daftar Sepeda Listrik"); 
            System.out.println("2. Input Data Peminjam");
            System.out.println("3. Peminjaman Sepeda Listrik"); 
            System.out.println("4. Pengembalian Sepeda Listrik");
            System.out.println("5. Riwayat Peminjaman"); 
            System.out.println("6. Logout"); 
            System.out.println("7. Keluar Aplikasi");
            System.out.print("Pilih (1-7): ");
            String pilih = sc.nextLine().trim();

            switch (pilih) {
                case "1":
                    // Menambahkan beberapa sepeda listrik (hindari double add → kosongkan dulu)
                    daftarSepeda.clear();
                    daftarSepeda.add(new DaftarSepedaListrik("S001", "Sepeda A", "Tersedia", 5000));
                    daftarSepeda.add(new DaftarSepedaListrik("S002", "Sepeda B", "Dipinjam", 7000));
                    daftarSepeda.add(new DaftarSepedaListrik("S003", "Sepeda C", "Tersedia", 6000));

                    System.out.println("\n=== Daftar Sepeda Listrik ===");
                    for (DaftarSepedaListrik sepeda : daftarSepeda) {
                        sepeda.tampilkanInfo();
                    }
                    break;

                case "2":
                    InputDataPeminjam peminjam = new InputDataPeminjam();
                    peminjam.inputData();
                    break;

                case "3":
                    PeminjamanSepedaListrik pinjam = new PeminjamanSepedaListrik(daftarSepeda);
                    pinjam.pinjamSepeda();
                    break;

                case "4":
                    PengembalianSepedaListrik kembali = new PengembalianSepedaListrik(daftarSepeda);
                    kembali.kembalikanSepeda(); 
                    break;

                case "5":
                    System.out.println("\n=== Riwayat Peminjaman Sepeda Listrik ===");
                    if (riwayat.isEmpty()) {
                        System.out.println("Belum ada riwayat peminjaman.");
                    } else {
                        for (RiwayatPeminjaman r : riwayat) {
                            r.tampilkanRiwayat();
                        }
                    }
                    break;


                case "6":
                    login.logout();
                    System.out.println("Anda telah logout.");
                    System.out.print("Username: ");
                    String u = sc.nextLine().trim();
                    System.out.print("Password: ");
                    String p = sc.nextLine();
                    if (login.authenticate(u, p)) {
                        System.out.println("Login berhasil kembali.");
                    } else {
                        System.out.println("Login ulang gagal. Program selesai.");
                        running = false;
                    }
                    break;

                case "7":
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        sc.close();
        System.out.println("Program selesai. Sampai jumpa!");
    }
}