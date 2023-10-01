package jogoprojeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ficheiros {
    public ArrayList MostraFicheiro(String NomeFicheiro){
        ArrayList linhas = new ArrayList();
        File FicheiroTemporario = new File(NomeFicheiro);
        try {
            FileReader fr = new FileReader(FicheiroTemporario);
            BufferedReader br = new BufferedReader(fr);
        while (br.ready())
            {linhas.add(br.readLine());}
            br.close();
            fr.close();
        return linhas;
        }catch (IOException ex) {}
            return linhas;
    }
   
    public boolean Existe(String NomeFicheiro){
        File FicheiroTemporario = new File(NomeFicheiro);
        try{
            if (!FicheiroTemporario.exists())
                return true;}
        catch (Exception ex) {}
        return false;
        }

    public boolean InsereLinhasFicheiro(String NomeFicheiro, String Nome, String Pontos){        
        File FicheiroTemporario = new File(NomeFicheiro);
        try {
            FileWriter fw = new FileWriter(FicheiroTemporario, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Nome);
            bw.newLine();
            bw.write(Pontos);
            bw.newLine();
            bw.close();
            fw.close();
            return true;
        }
        catch (IOException ex) {}
        return false;
        }

    public boolean CriaFicheiro(String NomeFicheiro) {
       
        File FicheiroTemporario = new File(NomeFicheiro);
        try {
            FicheiroTemporario.createNewFile();
            return true;}
        catch (Exception ex) {}
        return false;
        }
}