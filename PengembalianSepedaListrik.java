import java.util.ArrayList;
import java.util.Scanner;

public class PengembalianSepedaListrik {

    private ArrayList<DaftarSepedaListrik> daftarSepeda;

    public PengembalianSepedaListrik(ArrayList<DaftarSepedaListrik> daftarSepeda) {
        this.daftarSepeda = daftarSepeda;
    }

    public void kembalikanSepeda() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== Pengembalian Sepeda Listrik ===");
        System.out.print("Masukkan ID Sepeda Listrik yang dikembalikan : ");
        String id = sc.nextLine().trim();

        boolean ditemukan = false;

        for (DaftarSepedaListrik sepeda : daftarSepeda) {
            if (sepeda.getId().equalsIgnoreCase(id)) {
                ditemukan = true;
                System.out.println("Status : " + sepeda.getStatus());

                if (sepeda.getStatus().equalsIgnoreCase("Dipinjam")) {

                    System.out.print("Waktu Pinjam (Jam) : ");
                    int waktu = Integer.parseInt(sc.nextLine());

                    double totalBayar = sepeda.getTarif() * waktu;

                    sepeda.setStatus("Tersedia"); // ubah status ke tersedia

                    System.out.println("\nPengembalian Berhasil!");
                    System.out.println("ID Sepeda : " + sepeda.getId());
                    System.out.println("Waktu Pinjam : " + waktu + " Jam");
                    System.out.println("Total Biaya  : Rp " + totalBayar);

                } else {
                    System.out.println("Sepeda ini tidak sedang dipinjam, tidak bisa dikembalikan.");
                }
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("ID Sepeda tidak ditemukan!");
        }
    }
}