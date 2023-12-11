package Controller;

import Model.ModelBuku;
import Node.NodeBuku;

import java.util.ArrayList;

public class ControllerBuku {
    private ModelBuku model;

    public ControllerBuku(ModelBuku model) {
        this.model = model;
    }

    public ArrayList<NodeBuku> viewBooks() {
        return model.GetBooks();
    }

    public void insertBook(String judul, String pengarang, int tahun_terbit, int stok) {
        model.addBook(judul, pengarang, tahun_terbit, stok);
    }

    public void updateBook(int kode_buku, String judul, String pengarang, int tahun_terbit, int stok) {
        NodeBuku book = model.getBook(kode_buku);
        if (book == null) {
            System.out.println("Buku tidak ditemukan");
        }else{
            book.judul_buku = judul;
            book.pengarang = pengarang;
            book.tahun_terbit = tahun_terbit;
            book.stok = stok;
            model.updateBook(book);
        }
    }

    public void deleteBook(int kode_buku) {
        NodeBuku book = model.getBook(kode_buku);
        if (book == null) {
            System.out.println("Buku tidak ditemukan");
        }else{
            model.deleteBook(book);
        }
    }

    public NodeBuku searchBook(int kode_buku){
        return model.getBook(kode_buku);
    }
}