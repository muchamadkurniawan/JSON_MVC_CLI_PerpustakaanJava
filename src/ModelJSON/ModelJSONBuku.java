package ModelJSON;

import Node.NodeBuku;
import NodeJSON.NodeJSONBuku;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ModelJSONBuku {
    String fname = "src/Database/DatabaseBuku.json";
    private NodeJSONBuku nodeJSONBuku = new NodeJSONBuku();

    public boolean cekFile(){
        boolean cek = false;
        try {
            java.io.File file = new java.io.File(fname);
            if(file.exists()){
                cek = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cek;
    }

    public void writeFileJSON(ArrayList<NodeBuku> listBuku){
        JSONArray arrayBuku = convertArrayListToArrayJSON(listBuku);
        try {
            FileWriter file = new FileWriter(fname);
            file.write(arrayBuku.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray convertArrayListToArrayJSON(ArrayList<NodeBuku> listBuku){
        if (listBuku==null){
            return null;
        }else{
            JSONArray arrayBuku = new JSONArray();
            for (NodeBuku buku:listBuku) {
                JSONObject objBuku = new JSONObject();
                objBuku.put(nodeJSONBuku.kode_buku, buku.kode_buku);
                objBuku.put(nodeJSONBuku.judul_buku, buku.judul_buku);
                objBuku.put(nodeJSONBuku.pengarang, buku.pengarang);
                objBuku.put(nodeJSONBuku.tahun_terbit, buku.tahun_terbit);
                objBuku.put(nodeJSONBuku.stok, buku.stok);
                arrayBuku.add(objBuku);
            }
            return arrayBuku;
        }
    }

    public ArrayList<NodeBuku> convertJSONArrayToArrayList(JSONArray arrayBuku){
        if (arrayBuku==null){
            return null;
        }else{
            ArrayList<NodeBuku> listBuku = new ArrayList<>();
            for (Object objBuku:arrayBuku) {
                JSONObject buku = (JSONObject) objBuku;
                int kode_buku = Integer.parseInt(buku.get(nodeJSONBuku.kode_buku).toString());
                String judul_buku = buku.get(nodeJSONBuku.judul_buku).toString();
                String pengarang = buku.get(nodeJSONBuku.pengarang).toString();
                int tahun_terbit = Integer.parseInt(buku.get(nodeJSONBuku.tahun_terbit).toString());
                int stok = Integer.parseInt(buku.get(nodeJSONBuku.stok).toString());
                listBuku.add(new NodeBuku(kode_buku,judul_buku,pengarang,tahun_terbit,stok));
            }
            return listBuku;
        }
    }
}
