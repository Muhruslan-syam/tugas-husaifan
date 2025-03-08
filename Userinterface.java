
import java.sql.SQLOutput;
import java.util.Scanner;

public class Userinterface {

    public static void Menu(){
        System.out.println();
        System.out.println("+===================+");
        System.out.println("|   Pilih menu:     |");
        System.out.println("+-------------------+");
        System.out.println("|   (c):Create      |");
        System.out.println("|   (R):Read        |");
        System.out.println("|   (U) : Update    |");
        System.out.println("|   (D) : Delete    |");
        System.out.println("|   (X) : Exit      |");
        System.out.println("+===================+");
    }
    public static void main(String[]args){
        database db = new database();
        System.out.println("===aplikasi simple database text database===");
        while (true){
            Menu();
            Scanner sc = new Scanner(System.in);
            System.out.print("Pilih = ");
            String a = sc.nextLine();
            a = a.toUpperCase();
            switch (a){
                case "C":
                    System.out.println("---INFO: anda memilih menu Create---");
                    System.out.println("--------------------------------------");
                    System.out.println("INPUT DATA BARU");
                    System.out.print("NIM = ");
                    String nim = sc.nextLine();
                    System.out.print("NAMA MAHASISWA  = ");
                    String nama = sc.nextLine();
                    System.out.print("ALAMAT          = ");
                    String alamat = sc.nextLine();
                    System.out.print("SEMESTER        = ");
                    int semester = sc.nextInt();
                    System.out.print("SKS             = ");
                    int sks = sc.nextInt();
                    System.out.print("IPK             = ");
                    double ipk = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("------------------------------");

                    boolean status = db.insert(nim,nama,alamat,semester,sks,ipk);
                    if (status == true){
                        System.out.println("---DATA BERHASIL DITABAHKAN---");
                    }
                    else {
                        System.out.println("--NIM"+nim+"SUDAH ADA DI DATABASE--");
                        System.out.println("---GAGAL MENAMBAHKAN DATA BARU---");
                    }
                    System.out.println("------------------------------");
                    break;

                case "R":
                    System.out.println("---INFO: Anda memilih menu Read---");
                    db.view();
                    break;
                case "U":
                    System.out.println("---INFO: Anda memilih menu UPDATE---");
                    db.view();
                    System.out.print("INPUT KEY (NIM MAHASISWA YANG INGIN DIUBAH) = ");
                    String key = sc.next();
                    int index = db.search(key);
                    if (index >= 0){
                        System.out.println("Anda akan meng-Update data "+db.getData().get(index));
                        System.out.print("NIM = ");
                        String Nim = sc.next();
                        System.out.print("NAMA MAHASISWA  = ");
                        String Nama = sc.next();
                        System.out.print("ALAMAT          = ");
                        String Alamat = sc.next();
                        System.out.print("SEMESTER        = ");
                        int Semester = sc.nextInt();
                        System.out.print("SKS             = ");
                        int Sks = sc.nextInt();
                        System.out.print("IPK             = ");
                        double Ipk = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("------------------------------");
                        status = db.update(index,Nim,Nama,Alamat,Semester,Sks,Ipk);
                        if ( status == true){
                            System.out.println("---data berhasil di perbaharui---");
                        }else {
                            System.out.println("---data gagal di perbaharui---");
                        }

                    }
                    else {
                        System.err.println("---Mahasiswa dengan NIM: "+key+" Tidak ada di data base--- ");

                    }
                    break;
                case "D":
                    System.out.println("---INFO: Anda memilih menu delet---");
                    db.view();
                    System.out.print("INPUT KEY (NIM YANG INGIN DI HAPUS) = ");
                    key = sc.nextLine();
                    index = db.search(key);
                    if (index >=0){
                        System.out.println("---APAKAH ANDA YAKIN INGIN MENGHAPUS NI DATA DENGAN NIM :"+db.getData().get(index)+"---");
                        System.out.println("--Y/N--");
                        System.out.print("PILIH = ");
                         a = sc.nextLine();
                        if (a.equalsIgnoreCase("Y")){
                            status = db.delet(index);
                            if (status==true){
                                System.out.println("---ANDA BERHASIL MENGHAPUS DATA---");

                            }else {
                                System.out.println("---BATAL HAPUS DATA---");
                            }
                        }
                    }
                    break;
                case "X":
                    System.out.println("---INFO: Anda memilih menu Exit---");
                    System.out.println("---apakah anda yaki mau keluar dari aplikasi ini (y/n)---");
                    System.out.print("Pilih = ");
                    a = sc.nextLine();
                    if (a.equalsIgnoreCase("Y")){
                        System.exit(0);
                    }
                    break;
            }
        }

    }
}
