import ModelJSON.ModelJSONBuku;
import Node.NodeBuku;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("test function read from file JSON");
        ModelJSONBuku modelJSONBuku = new ModelJSONBuku();
        ArrayList<NodeBuku> listBuku2 = modelJSONBuku.readFromFile();
        System.out.println("------------------------------------");
        for (NodeBuku buku:listBuku2) {
            System.out.println(buku.kode_buku);
            System.out.println(buku.judul_buku);
            System.out.println(buku.pengarang);
            System.out.println(buku.tahun_terbit);
            System.out.println(buku.stok);
            System.out.println("====================================");
        }
    }
}