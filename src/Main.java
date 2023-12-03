import Model.ModelBuku;
import ModelJSON.ModelJSONBuku;
import Node.NodeBuku;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // test load data
        ModelBuku modelBuku = new ModelBuku();

        // test deleteBook
        Boolean delete = modelBuku.deleteBook(5);
        if (delete){
            System.out.println("Delete berhasil");
        }else{
            System.out.println("Delete gagal");
        }
        //print all buku
        modelBuku.GetBooks().forEach((buku) -> {
            System.out.println(buku.kode_buku);
            System.out.println(buku.judul_buku);
            System.out.println(buku.pengarang);
            System.out.println(buku.tahun_terbit);
            System.out.println(buku.stok);
        });

        // test updateBook
        Boolean update = modelBuku.updateBook(9, "Buku 1", "Pengarang 1", 2020, 10);
        if (update){
            System.out.println("Update berhasil");
            NodeBuku buku = modelBuku.getBook(1);
            System.out.println(buku.judul_buku);
            System.out.println(buku.pengarang);
            System.out.println(buku.tahun_terbit);
            System.out.println(buku.stok);
        }else{
            System.out.println("Update gagal");
        }
    }
}