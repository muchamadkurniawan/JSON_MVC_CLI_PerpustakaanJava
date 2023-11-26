import ModelJSON.ModelJSONBuku;
import Node.NodeBuku;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("test function convert file json to Array list");
        ModelJSONBuku modelJSONBuku = new ModelJSONBuku();
        ArrayList <NodeBuku> listBuku = new ArrayList<>();
        listBuku.add(new NodeBuku(1,"Buku 1","Pengarang 1",2010,10));
        listBuku.add(new NodeBuku(2,"Buku 2","Pengarang 2",2011,11));
        listBuku.add(new NodeBuku(3,"Buku 3","Pengarang 3",2012,12));
        JSONArray arrayBuku = modelJSONBuku.convertArrayListToArrayJSON(listBuku);
        ArrayList<NodeBuku> listBuku2 = modelJSONBuku.convertJSONArrayToArrayList(arrayBuku);
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