// Authors: 2017 CS PRIMES
// Robert Chen, John Kuszmaul, Yiming Zheng
// Mentored by Alin Tomescu

// Purpose: To access the Keybase server and read the merkle root from
// JSON

package org.keybase;

import java.net.URL;
import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {

    public static String getMerkleRoot(int num) throws Exception {
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
	    return root.getHash();
	} catch (IOException e) {
	    e.printStackTrace();
	    return "";	
	}
    }

    public static int getCurrentSeqno() {
    	URL url;
    	try {
    		url = new URL("https://keybase.io/_/api/1.0/merkle/root.json");
    	} catch (Exception e) {
    		System.out.println("Unable to access keybase merkle roots");
    		return -1;
    	}
    	

    	ObjectMapper objectMapper = new ObjectMapper();
    	try {
    		MerkleRoot root = objectMapper.readValue(url.openStream(), MerkleRoot.class);
	    return root.getSeqno();
    	} catch (IOException e) {
    		e.printStackTrace();
    		return -1;
    	}
	
    }
    
}
