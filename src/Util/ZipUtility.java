package Util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * ZipUtility.java
 * @author benbac
 */

public class ZipUtility {

    public static byte[] compress(byte[] input, int level) {
        // Create the compressor with highest level of compression
        Deflater compressor = new Deflater();
        compressor.setLevel(level);

        // Give the compressor the data to compress
        compressor.setInput(input);
        compressor.finish();

        // Create an expandable byte array to hold the compressed data.
        ByteArrayOutputStream bos = new ByteArrayOutputStream(input.length);

        // Compress the data
        byte[] buf = new byte[1024];
        while (!compressor.finished()) {
            int count = compressor.deflate(buf);
            bos.write(buf, 0, count);
        }
        try {
            bos.flush();
            bos.close();
        } catch (IOException e) { 
            e.getStackTrace();
        }
        // Get the compressed data
        return bos.toByteArray();        
    }    
    
    public static byte[] decompress (byte[] compressedData) {
        // Create the decompressor and give it the data to compress
        Inflater decompressor = new Inflater();
        decompressor.setInput(compressedData);
        
        // Create an expandable byte array to hold the decompressed data
        ByteArrayOutputStream bos = new ByteArrayOutputStream(compressedData.length);

        // Decompress the data
        byte[] buf = new byte[1024];
       
        while (!decompressor.finished()) {
            System.out.println("here");
            System.out.println(decompressor.getBytesRead());
            System.out.println(decompressor.getBytesWritten());
            
            try {
                int count = decompressor.inflate(buf);
                bos.write(buf, 0, count);
            } catch (DataFormatException e) {
                e.getStackTrace();
            }
        }
         
        try {
            bos.flush();
            bos.close();       
        } catch (IOException e) {
            e.getStackTrace();
        }
        // Get the decompressed data
        return bos.toByteArray();         
    }       
                
}
