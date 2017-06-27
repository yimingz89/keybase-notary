// Authors: 2017 CS PRIMES
// Robert Chen, John Kuszmaul, Yiming Zheng
// Mentored by Alin Tomescu

// Purpose: To access the Keybase server and read the merkle root from
// JSON

package org.keybase;

import java.net.URL;
import java.io.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
    
    private static final Logger log = LoggerFactory.getLogger(JSONParser.class);

    public static String getMerkleRoot(int num) throws IOException, IllegalArgumentException {
        URL url = null;
        if (num >= 1) {
            url = new URL("https://keybase.io/_/api/1.0/merkle/root.json?seqno=" + num);
        } else {
            log.error("ERROR: Not a valid URL");
            throw new IllegalArgumentException("Num must be a positive integer."); // num must be a positive integer
        }

        ObjectMapper objectMapper = new ObjectMapper();
        MerkleRoot root = objectMapper.readValue(url.openStream(), MerkleRoot.class);
        return root.getHash();
    }


    public static int getCurrentSeqno() {
        URL url;
        try {
            url = new URL("https://keybase.io/_/api/1.0/merkle/root.json");
        } catch (Exception e) {
            log.error("ERROR: Unable to access keybase merkle roots");
            e.printStackTrace();
            System.exit(1);
            return -1; // included to make compiler happy,
            // but this line of code should never be reached.
        }


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MerkleRoot root = objectMapper.readValue(url.openStream(), MerkleRoot.class);
            return root.getSeqno();
        } catch (IOException e) {
            log.error("ERROR: IO Exception unable to read Merkle root from JSON.");
            e.printStackTrace();
            System.exit(1);
            return -1; // included to make compiler happy,
            // but this line of code should never be reached.
        }

    }

}
