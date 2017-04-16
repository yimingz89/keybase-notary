package org.keybase;

import java.net.URL;
import java.io.*;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
    public static void main(String[] args) throws Exception {
	int num = 11;
	
	URL url = new URL("https://keybase.io/_/api/1.0/merkle/root.json?seqno=1");
	if (num >= 1) {
	    url = new URL("https://keybase.io/_/api/1.0/merkle/root.json?seqno=" + num);
	} else {
	    System.out.println("ERROR: Not a valid URL");
	    System.exit(1);
	}
	
	ObjectMapper objectMapper = new ObjectMapper();
	try {
	    MerkleRoot root = objectMapper.readValue(url.openStream(), MerkleRoot.class);
	    System.out.println(root.getHash());
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	
    }
}
