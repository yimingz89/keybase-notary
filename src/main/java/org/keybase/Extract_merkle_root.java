// Authors: John Kuszmaul, Yiming Zheng
// CS PRIMES 2017
// Date: 4/2/2017

// Purpose: This program first receieves the javascript from the
// keybase website, and then extracts the merkle root from the
// javascript.

package org.keybase;

import java.net.*;
import java.util.*;
import java.io.*;

public class Extract_merkle_root {

    public static void main(String[] args) {
	String pathname = "data.json";
	File output = new File(pathname);
	PrintWriter to_output = null;
	try {
	    to_output = new PrintWriter(output);
	}
	catch (FileNotFoundException ex) {
	    System.out.println("ERROR: Cannot create " + pathname);
	    System.exit(1);
	}
	try {
	    getRoot(10, to_output);
	}
	catch (Exception e) {
	    System.out.println("Error getting Root");
	    System.exit(1);
	}
	to_output.close();
    }

    // returns the numth merkle root 
    public static void getRoot(int num, PrintWriter output_file) throws Exception {
	URL keybase = new URL("https://keybase.io/_/api/1.0/merkle/root.json?seqno=" + num);
        URLConnection yc = keybase.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	String inputLine;
	
        while ((inputLine = in.readLine()) != null)
	    output_file.println(inputLine);
        in.close();
    }
    
}

//    public static String parseJSON(JsonParser jsonParser) throws JsonParseException, IOException {
//	while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
//	    String name = jsonParser.getCurrentName();
//	    if (name.equals("hash"))
//		return jsonParser.getText();
//	}
//	System.out.println("ERROR: Unable to find token \"hash\"");
//	System.exit(1);
//    }

//	StringBuffer input = new StringBuffer();
//	    input.append(inputLine);
//	    input.append("\n");
//	return input.toString();
