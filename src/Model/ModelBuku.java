package Model;
import DatabaseJSON.JSONbuku;
import Node.NodeBuku;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class ModelBuku {
    private ArrayList<NodeBuku> books;
    public ModelBuku(){
        books = new ArrayList<>();
    }

    public void insertBuku(String judul, String pengarang, int tahun){
        int kode = books.get(books.size()-1).kode_buku;
        books.add(new NodeBuku(kode+1,judul,pengarang,tahun));
    }

    public ArrayList<NodeBuku> readAllbuku(){
        return books;
    }

    public NodeBuku searchBook(String judul){
        NodeBuku buku = null;
        for (int i=0;i<books.size();i++){
            if (judul.equals(books.get(i).judul_buku)){
                buku = books.get(i);
            }
        }
        return buku;
    }
    public void updateStok(String judul,int newStok){
        NodeBuku buku = searchBook(judul);
        if (buku!=null){
            buku.updateStok(newStok);
        }
    }
    public void deleteBook(String judul){
        NodeBuku buku = searchBook(judul);
        if (buku!=null){
            books.remove(buku);
        }
    }
}
