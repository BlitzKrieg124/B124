import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;




public class main{
    public static void main(String[] args) {

        try {
            
            boolean found ;
            ArrayList<résultat>  listResultat = new ArrayList<>();
            String line; 
            FileWriter fw = new FileWriter(args[1]);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]),StandardCharsets.UTF_8));
            FileReader fr = new FileReader(args[0]);
            BufferedReader Br = new BufferedReader(fr);
            while ((line = Br.readLine())!= null)  { 

            
    
                found = false; 
                for (résultat elemenRésultat : listResultat) {
                    if (elemenRésultat.getArrondissement().equals(line.split(",")[3])){  
                    listResultat.get(listResultat.indexOf(elemenRésultat)).ajouter();
                    found = true;
               
               
                }


                }

                if (found == false)
                listResultat.add(new résultat(line.split(",")[3]));

           
            }
 
        listResultat.remove(0);    
        Br.close();
        bw.write("arrondissement, nombre d'interventions\n");
        for (résultat elemReRésultat : listResultat) {
          bw.write(elemReRésultat.toString());
           
    }
        bw.close();    

        }
        catch(IOException e)
        {

            System.out.println(e.getMessage());
            
        }




    }

    
}



