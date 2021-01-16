package br.com.abc.javacore.Vio.test;

import java.io.*;

public class StreamsTest {
    public static void main(String[] args) {
//        recorder();
//        reader();
//        tunedRecorder();
        tunedReader();
    }

    private static void recorder() {
        byte[] data = {65, 66, 67, 68, 69, 70};
        try (FileOutputStream recorder = new FileOutputStream("folder/stream.txt")) {
            recorder.write(data);
            recorder.flush();
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // using buffer
    private static void tunedRecorder() {
//        Long way:
//          FileOutputStream recorder = new FileOutputStream("folder/stram.txt");
//          BufferedOutputStream bf = new BufferedOutputStream(recorder);
        byte[] data = {65, 66, 67, 68, 69, 70};
//        Short way:
        try (BufferedOutputStream bufferRecorder = new BufferedOutputStream(new FileOutputStream("folder/stream.txt"), 4098)) {
            bufferRecorder.write(data);
            bufferRecorder.flush();
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reader() {
        try (FileInputStream reader = new FileInputStream("folder/stream.txt")) {
            int read;
            while ((read = reader.read()) != -1) {
                byte b = (byte) read;
                System.out.println(" " + b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tunedReader() {
        try (BufferedInputStream bufferReader = new BufferedInputStream(new FileInputStream("folder/stream.txt"),4098)) {
            int read;
            while ((read = bufferReader.read()) != -1) {
                byte b = (byte) read;
                System.out.println("" + b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
