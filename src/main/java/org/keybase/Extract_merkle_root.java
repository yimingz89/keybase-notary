// Authors: John Kuszmaul, Yiming Zheng
// CS PRIMES 2017
// Date: 4/2/2017
// Purpose: This program first receieves the javascript from the
// keybase website, and then extracts the merkle root from the
// javascript.
// NOTE: Does not work.

package org.keybase;

import org.json.*;
import java.util.*;
import java.io.*;

public class Extract_merkle_root {

    public static void main(String[] args) {
	
    }

    // returns the nth merkle root right now it just returns the most
    // recent merkle root because I don't know where to access the
    // rest.
    public static String getRoot(int num) {
	URL keybase = new URL("https://keybase.io/_/api/1.0/merkle/root.json");
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
