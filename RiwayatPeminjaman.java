public class RiwayatPeminjaman {
    private String namaPeminjam;
    private String idSepeda;
    private int durasi;
    private double totalBiaya;

    public RiwayatPeminjaman(String namaPeminjam, String idSepeda, int durasi, double totalBiaya) {
        this.namaPeminjam = namaPeminjam;
        this.idSepeda = idSepeda;
        this.durasi = durasi;
        this.totalBiaya = totalBiaya;
    }

    public void tampilkanRiwayat() {
        System.out.println("-------------------------------");
        System.out.println("Nama Peminjam     : " + namaPeminjam);
        System.out.println("ID Sepeda Listrik : " + idSepeda);
        System.out.println("Durasi            : " + durasi + " Jam");
        System.out.println("Total Biaya       : Rp " + totalBiaya);
    }
}