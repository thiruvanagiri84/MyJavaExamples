package com.basics.practice;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/** This class contains some general utility functions for dealing with Streams.
 */
 class FileSteamsUtil {
    /**
     * default read size for stream copy
     */
    public static final int DEFAULT_BUFFER_SIZE = 1024;

    /** Copies the data from an InputStream object to an OutputStream object.
     * @param sourceStream The input stream to be read.
     * @param destinationStream The output stream to be written to.
     * @return int value of the number of bytes copied.
     * @exception IOException from java.io calls.
     */
    public static int copyStream(InputStream sourceStream,OutputStream destinationStream) throws IOException {
        int bytesRead = 0;
        int totalBytes = 0;
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];

        while(bytesRead >= 0) {
            bytesRead = sourceStream.read(buffer,0,buffer.length);

            if(bytesRead > 0) {
                destinationStream.write(buffer,0,bytesRead);
            }

            totalBytes += bytesRead;
        }

        return totalBytes;
    }

    /**
     * Converts little endian bytes to a int
     * @param value byte array to read
     * @return integer value of the byte array
     */
    public static int littleEndianToInt(byte[] value) {
        return ByteBuffer.wrap(value).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    /**
     * Converts little endian bytes to a long
     * @param value byte array to read
     * @return long value of the byte array
     */
    public static long littleEndianToLong(byte[] value) {
        return ByteBuffer.wrap(value).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }

    /**
     * Converts little endian Unicode bytes to a String
     * @param value byte array of Unicode Little Endian
     * @return String value of the byte array
     */
    public static String littleEndianToString(byte[] value) {
        return ByteBuffer.wrap(value).order(ByteOrder.LITTLE_ENDIAN).asCharBuffer().toString();
    }

    /**
     * Read an entire stream and return it as a String
     *
     * @param sourceStream the InputStream to read.
     * @return a String containing the contents of the stream.
     * @exception IOException from java.io calls.
     */
    public static String readStreamAsString(InputStream sourceStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(sourceStream));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        copyStream(sourceStream,output);

        return output.toString();
    }

    /**
     * This is a quick method to get a subset of a byte array as a new array
     * @param start index of the source to begin reading from
     * @param count number of bytes to copy
     * @param source byte array to read from
     * @return byte array of size <code>count</code>
     */
    public static byte[] subset(int start,int count,byte[] source) {
        byte[] ret = new byte[count];

        for(int i = 0; i < count; i++) {
            ret[i] = source[start + i];
        }

        return ret;
    }
}
