package org.keybase;
 
import java.net.URL;
import java.io.*;
import java.util.Date;
import java.util.Map;
 
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class JSONParser {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://keybase.io/_/api/1.0/merkle/root.json");
         
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MerkleRoot root = objectMapper.readValue(url.openStream(), MerkleRoot.class);
            System.out.println(root.getHash());
        } catch (IOException e) {
            e.printStackTrace();
        }
         
         
    }
}
