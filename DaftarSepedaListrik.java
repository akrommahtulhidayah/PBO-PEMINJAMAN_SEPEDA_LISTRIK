public class DaftarSepedaListrik {
    private String id;       // ID Sepeda Listrik
    private String nama;     // Nama Sepeda
    private String status;   // Status Sepeda (Tersedia/Dipinjam)
    private double tarif;    // Tarif per jam

    // Konstruktor
    public DaftarSepedaListrik(String id, String nama, String status, double tarif) {
        this.id = id;
        this.nama = nama;
        this.status = status;
        this.tarif = tarif;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    // Method untuk menampilkan info sepeda lengkap
    public void tampilkanInfo() {
        System.out.println("-----------------------------");
        System.out.println("ID Sepeda Listrik : " + id);
        System.out.println("Nama Sepeda       : " + nama);
        System.out.println("Status            : " + status);
        System.out.println("Tarif             : " + tarif + "/Jam");
        System.out.println("-----------------------------");
    }
}