package View;

import Controller.ControllerBuku;
import Model.ModelBuku;
import Node.NodeBuku;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewBook {
    private ControllerBuku controller;

    public ViewBook(ControllerBuku controller){
        this.controller = controller;
    }
    public void viewBooks(){
        System.out.println("Menu Menampilkan Semua buku");
        for (NodeBuku buku:controller.viewBooks()) {
            System.out.println("Kode buku : "+buku.kode_buku);
            System.out.println("Judul buku : "+buku.judul_buku);
            System.out.println("Pengarang buku : "+buku.pengarang);
            System.out.println("Tahun buku : "+buku.tahun_terbit);
            System.out.println("Stok buku : "+buku.stok);
            System.out.println("====================================");
        }
    }

    public void insertBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Menambahkan buku");
        System.out.print("Masukkan judul buku : ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan pengarang buku : ");
        String pengarang = scanner.nextLine();
        System.out.print("Masukkan tahun terbit buku : ");
        int tahun_terbit = scanner.nextInt();
        System.out.print("Masukkan stok buku : ");
        int stok = scanner.nextInt();
        controller.insertBook(judul,pengarang,tahun_terbit,stok);
    }

    public void updateBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Mengubah buku");
        System.out.print("Masukkan kode buku : ");
        int kode_buku = scanner.nextInt();
        System.out.print("Masukkan judul buku : ");
        String judul = scanner.next();
        System.out.print("Masukkan pengarang buku : ");
        String pengarang = scanner.next();
        System.out.print("Masukkan tahun terbit buku : ");
        int tahun_terbit = scanner.nextInt();
        System.out.print("Masukkan stok buku : ");
        int stok = scanner.nextInt();
        controller.updateBook(kode_buku,judul,pengarang,tahun_terbit,stok);
    }

    public void deleteBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Menghapus buku");
        System.out.print("Masukkan kode buku : ");
        int kode_buku = scanner.nextInt();
        controller.deleteBook(kode_buku);
    }

    public void searchBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Mencari buku");
        System.out.print("Masukkan kode buku : ");
        int kode_buku = scanner.nextInt();
        NodeBuku book = controller.searchBook(kode_buku);
        if (book == null){
            System.out.println("Buku tidak ditemukan");
        }else{
            System.out.println("Kode buku : "+book.kode_buku);
            System.out.println("Judul buku : "+book.judul_buku);
            System.out.println("Pengarang buku : "+book.pengarang);
            System.out.println("Tahun buku : "+book.tahun_terbit);
            System.out.println("Stok buku : "+book.stok);
            System.out.println("====================================");
        }
    }
}
