import java.util.Scanner;

public class InputDataPeminjam {
    private String nama;
    private String alamat;
    private String noHp;

    // Method untuk input data peminjam
    public void inputData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Input Data Peminjam ===");

        System.out.print("Nama Peminjam      : ");
        nama = sc.nextLine().trim();

        System.out.print("Alamat Peminjam    : ");
        alamat = sc.nextLine().trim();

        System.out.print("No HP Peminjam     : ");
        noHp = sc.nextLine().trim();

        System.out.println("\nData peminjam berhasil dicatat!");
        System.out.println("Nama   : " + nama);
        System.out.println("Alamat : " + alamat);
        System.out.println("No HP  : " + noHp);
    }

    // Getter jika ingin dipakai di menu lain nantinya
    public String getNama()   { return nama; }
    public String getAlamat() { return alamat; }
    public String getNoHp()   { return noHp; }
}