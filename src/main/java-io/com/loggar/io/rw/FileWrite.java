package com.loggar.io.rw;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

public class FileWrite {
    @Test
    public void writeCharData() throws IOException {
        String in = "A huge line of text";
        PrintWriter pWriter = new PrintWriter(new FileWriter("./dist/io/charData.txt"));
        pWriter.println(in);
        pWriter.close();
    }

    @Test
    public void writeSmallAmountCharData1() throws IOException {
        String in = "A small amount of text";
        FileWriter fWriter = new FileWriter("./dist/io/charDataSmall.1.txt");
        fWriter.write(in);
        fWriter.close();
    }

    @Test
    public void writeSmallAmountCharData2() throws IOException {
        FileWriter fWriter = new FileWriter("./dist/io/charDataSmall.2.txt");
        fWriter.write("10" + System.lineSeparator());
        fWriter.write("20.5" + System.lineSeparator());
        fWriter.write("Employee" + System.lineSeparator());
        fWriter.write("50.00" + System.lineSeparator());
        fWriter.write("Coffee" + System.lineSeparator());
        fWriter.close();
    }

    @Test
    public void writeBinaryData() throws IOException {
        File positions = new File("./dist/io/binaryData.bin");
        int[] pos = { 0, 1, 2, 3, 4 };
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(positions));

        for (int i = 0; i < pos.length; i++)
            outStream.writeInt(pos[i]);
        outStream.close();
    }

    @Test
    public void writeLargeBinaryData() throws IOException {
        File positions = new File("./dist/io/binaryDataLarge.bin");
        int[] pos = { 0, 1, 2, 3, 4 };
        DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(positions)));

        for (int i = 0; i < pos.length; i++)
            outStream.writeInt(pos[i]);
        outStream.close();
    }
}
