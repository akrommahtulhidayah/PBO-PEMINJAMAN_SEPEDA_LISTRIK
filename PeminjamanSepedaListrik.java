import java.util.ArrayList;
import java.util.Scanner;

public class PeminjamanSepedaListrik {

    private ArrayList<DaftarSepedaListrik> daftarSepeda;

    // Konstruktor menerima daftar sepeda dari Main
    public PeminjamanSepedaListrik(ArrayList<DaftarSepedaListrik> daftarSepeda) {
        this.daftarSepeda = daftarSepeda;
    }

    public void pinjamSepeda() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== Peminjaman Sepeda Listrik ===");
        System.out.print("Masukkan ID Sepeda Listrik yang disewakan : ");
        String id = sc.nextLine().trim();

        boolean ditemukan = false;

        for (DaftarSepedaListrik sepeda : daftarSepeda) {
            if (sepeda.getId().equalsIgnoreCase(id)) {
                ditemukan = true;

                System.out.println("Status : " + sepeda.getStatus());

                if (sepeda.getStatus().equalsIgnoreCase("Tersedia")) {
                    System.out.print("Waktu Pinjam (Jam) : ");
                    int waktu = Integer.parseInt(sc.nextLine());

                    sepeda.setStatus("Dipinjam"); // ubah status sepeda

                    System.out.println("\nPeminjaman Berhasil!");
                    System.out.println("ID Sepeda : " + sepeda.getId());
                    System.out.println("Nama      : " + sepeda.getNama());
                    System.out.println("Waktu     : " + waktu + " Jam");
                    
                } else {
                    System.out.println("Peminjaman Tidak Dapat Dilakukan, Sepeda Sedang Dipinjam.");
                }
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("ID Sepeda tidak ditemukan!");
        }
    }
}