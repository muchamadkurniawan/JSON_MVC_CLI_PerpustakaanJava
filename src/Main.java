import Controller.ControllerBuku;
import Model.ModelBuku;
import ModelJSON.ModelJSONBuku;
import Node.NodeBuku;
import View.ViewBook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void menuPilihanUtama(){
        System.out.println("Menu Pilihan");
        System.out.println("1. Manage Buku");
        System.out.println("2. Manage Anggota");
        System.out.println("3. Manage Peminjaman");
        System.out.println("4. Manage Pengembalian");
        System.out.print("Masukkan pilihan anda : ");
    }

    public static void mainProgram(){

    }

    private static void menuManageBuku() {
        System.out.println("Menu Manage Buku");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Lihat Buku");
        System.out.println("3. Update Buku");
        System.out.println("4. Hapus Buku");
        System.out.println("5. Cari Buku");
        System.out.println("6. Kembali");
        System.out.print("Masukkan pilihan anda : ");
    }
    public static void main(String[] args) {
        // object model, controller, view
        ModelBuku modelBuku = new ModelBuku();
        ControllerBuku controllerBuku = new ControllerBuku(modelBuku);
        ViewBook viewBook = new ViewBook(controllerBuku);

        //testing insert
        viewBook.insertBook();
        viewBook.viewBooks();
        viewBook.updateBook();
        viewBook.deleteBook();
        viewBook.searchBook();
    }
}