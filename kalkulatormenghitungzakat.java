import java.util.Scanner;
public class kalkulatormenghitungzakat {
   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("Kalkulator Membayar Zakat");
            System.out.println("\nPilih jenis zakat yang ingin dihitung:");
            System.out.println("1. Zakat Fitrah");
            System.out.println("2. Zakat Mal (Emas/Perak)");
            System.out.println("3. Zakat Penghasilan (Zakat Profesi)");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = input.nextInt();

            if (pilihan == 1) {
                hitungZakatFitrah(input);
            } else if (pilihan == 2) {
                pilihZakatMal(input);
            } else if (pilihan == 3) {
                hitungZakatPenghasilan(input);
            } else if (pilihan == 4) {
                lanjut = false;
                System.out.println("Terima kasih telah menggunakan program zakat.");
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

            if (lanjut) {
                lanjut = kembaliKeMenu(input);
            }
        }
        input.close();
    }

    public static void hitungZakatFitrah(Scanner input) {
        System.out.print("1. Zakat Fitrah");
        System.out.print("Masukkan jumlah anggota keluarga yang mau dibayarkan zakat: ");
        int jumlahAnggota = input.nextInt();

        System.out.print("Masukkan harga beras per kg sesuai dengan wilayah masing-masing : ");
        double hargaBeras = input.nextDouble();

        double zakatFitrahPerOrang = 2.5 * hargaBeras;
        double totalZakat = jumlahAnggota * zakatFitrahPerOrang;

        System.out.println("Harga beras yang digunakan per kg    : Rp " + String.format("%,.0f", hargaBeras));
        System.out.println("Zakat Fitrah per orang (2.5 kg beras): Rp " + String.format("%,.0f", zakatFitrahPerOrang));

        System.out.println("Zakat Fitrah yang harus dibayar untuk " + jumlahAnggota + " orang adalah: Rp " + String.format("%,.0f", totalZakat));
    }

    public static void pilihZakatMal(Scanner input) {
        System.out.println("\nPilih jenis zakat mal yang ingin dihitung:");
        System.out.println("1. Zakat Emas");
        System.out.println("2. Zakat Perak");
        System.out.println("3. Zakat Emas dan Perak");
        System.out.print("Masukkan pilihan Anda: ");
        int pilihan = input.nextInt();

        if (pilihan == 1) {
            hitungZakatEmas(input);
        } else if (pilihan == 2) {
            hitungZakatPerak(input);
        } else if (pilihan == 3) {
            hitungZakatEmas(input);
            hitungZakatPerak(input);
        } else {
            System.out.println("Pilihan tidak valid. Kembali ke menu utama.");
        }
    }
    
    public static void hitungZakatEmas(Scanner input) {
        System.out.print("Nisab untuk zakat emas adalah 85 gram.");
        System.out.print("Masukkan total berat emas yang dimiliki (gram): ");
        double emas = input.nextDouble();

        if (emas >= 85) {
            double zakatEmas = 0.025 * emas;
            System.out.println("Zakat untuk emas: " + zakatEmas + " gram emas.");
        } else {
            System.out.println("Emas tidak mencapai nisab, tidak ada zakat untuk emas.");
        }
    }

    public static void hitungZakatPerak(Scanner input) {
        System.out.print("Nisab untuk zakat perak adalah 595 gram.");
        System.out.print("Masukkan total berat perak yang dimiliki (gram): ");
        double perak = input.nextDouble();

        if (perak >= 595) {
            double zakatPerak = 0.025 * perak;
            System.out.println("Zakat untuk perak: " + zakatPerak + " gram perak.");
        } else {
            System.out.println("Perak tidak mencapai nisab, tidak ada zakat untuk perak.");
        }
    }
    
    public static void hitungZakatPenghasilan(Scanner input) {
        double nisabPenghasilan = 5220000;
        System.out.print("3. Zakat Penghasilan (Zakat Profesi)");
        System.out.println("Nisab untuk zakat penghasilan adalah Rp " + String.format("%,.0f", nisabPenghasilan) + ".");
        System.out.print("Masukkan jumlah pendapatan per bulan: ");
        double pendapatan = input.nextDouble();

        if (pendapatan >= nisabPenghasilan) {
            double zakatPenghasilan = 0.025 * pendapatan;
            System.out.println("Zakat penghasilan yang harus dibayar sebesar: Rp " + String.format("%,.0f", zakatPenghasilan));
        } else {
            System.out.println("Pendapatan tidak mencapai nisab, tidak ada zakat penghasilan.");
        }
    }
    
    public static boolean kembaliKeMenu(Scanner input) {
        System.out.print("\nApakah Anda ingin kembali ke menu utama? (y/n): ");
        char pilihan = input.next().toLowerCase().charAt(0);
        return pilihan == 'y';
    }
}