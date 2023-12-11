package Model;

import ModelJSON.ModelJSONBuku;
import Node.NodeBuku;
import java.util.ArrayList;

public class ModelBuku {
    private ArrayList<NodeBuku> books;
    private ModelJSONBuku modelJSONBuku;
    public ModelBuku(){
        books = new ArrayList<>();
        modelJSONBuku = new ModelJSONBuku();
        loadBooks();
    }
   private void loadBooks(){
        books = modelJSONBuku.readFromFile();
   }
   public ArrayList<NodeBuku> GetBooks(){
        return books;
   }

   private int getLastKode(){
        int last = books.size() - 1;
        return books.get(last).kode_buku;
   }
   public void addBook(String judul, String pengarang, int tahun_terbit, int stok){
        int kode_buku = getLastKode() + 1;
        NodeBuku buku = new NodeBuku(kode_buku, judul, pengarang, tahun_terbit, stok);
        books.add(buku);
   }
   public void commit(){
        modelJSONBuku.writeFileJSON(books);
   }
   public NodeBuku getBook(int kode_buku){
        NodeBuku book = null;
        for (NodeBuku buku:books) {
            if (buku.kode_buku == kode_buku){
                return buku;
            }
        }
        return book;
   }

   public void updateBook(NodeBuku book){
        int index = books.indexOf(book);
//        books.set(index, book);
        books.get(index).judul_buku = book.judul_buku;
        books.get(index).pengarang = book.pengarang;
        books.get(index).tahun_terbit = book.tahun_terbit;
        books.get(index).stok = book.stok;
   }

   public void deleteBook(NodeBuku book){
        books.remove(book);
   }
}
