// Authors: John Kuszmaul, Yiming Zheng
// CS PRIMES 2017
// Date: 4/2/2017
// Purpose: This program first receieves the javascript from the
// keybase website, and then extracts the merkle root from the
// javascript.

//package org.keybase; // can't get it to compile with this

import java.net.*;
//import org.json.*; // not downloaded yet
import java.util.*;
import java.io.*;

public class Extract_merkle_root {

    public static void main(String[] args) {
	String merkleroot = "";
	try {
	    merkleroot = getRoot(10);
	}
	catch (Exception e) {
	    System.out.println("Error getting Root");
	    System.exit(1);
	}
	System.out.print(merkleroot);
    }

    // returns the nth merkle root right now it just returns the most
    // recent merkle root because I don't know where to access the
    // rest.
    public static String getRoot(int num) throws Exception {
	URL keybase = new URL("https://keybase.io/_/api/1.0/merkle/root.json?seqno=" + num);
        URLConnection yc = keybase.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	StringBuffer input = new StringBuffer();
	String inputLine;
        while ((inputLine = in.readLine()) != null) {
	    input.append(inputLine);
	    input.append("\n");
	}
        in.close();
	return input.toString();
    }
    
}
