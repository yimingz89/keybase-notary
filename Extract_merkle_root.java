// Authors: John Kuszmaul, Yiming Zheng
// CS PRIMES 2017
// Date: 4/2/2017

// Purpose: To extract the Keybase merkle root from the Internet

// NOTE: Does not work.
import org.json.*;
import java.util.*;
import java.io.*;

public class Extract_merkle_root {

    public static void main(String[] args) {
	String jString = new Scanner(new File("filename")).useDelimiter("\\Z").next();

	JSONObject obj = new JSONObject(jString);
	System.out.println(mRoot);
					


    }

}
