package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> arguments = new HashMap<>(6);
        for (int i = 0; i < args.length; i += 2) {
            arguments.put(args[i], args[i + 1]);
        }

        EncryptionAlgorithm algorithm;

        switch (arguments.get("-alg")) {
            case "unicode":
                algorithm = new UnicodeEncryption();
                break;
            default:
                algorithm = new ShiftEncryption();
                break;
        }

        int key;

        if (arguments.get("-key") == null) {
            key = 0;
        } else {
            key = Integer.parseInt(arguments.get("-key"));
        }

        switch (arguments.get("-mode")) {
            case "dec":
                printData(arguments,
                        algorithm.decryption(readData(arguments),
                                key));
                break;
            default:
                printData(arguments,
                        algorithm.encryption(readData(arguments),
                                key));
                break;
        }


    }

    public static String readTextFromFile(String fileName) throws FileNotFoundException {
        StringBuilder data = new StringBuilder();
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            data.append(fileScanner.nextLine());
        }

        return data.toString();

    }

    public static String readData(Map<String, String> arguments) throws FileNotFoundException {
        if ((arguments.get("-data") != null && arguments.get("-in") != null) || arguments.get("-data") != null) {
            return arguments.get("-data");
        } else if (arguments.get("-in") != null) {
            try {
                return readTextFromFile(arguments.get("-in"));
            } catch (FileNotFoundException e) {
                System.out.println("Error !" + e.getMessage());
                throw new FileNotFoundException("File from -in argument wasn't found !");
            }
        }

        return "";
    }

    public static void printData(Map<String, String> arguments, String data) throws IOException {
        if (arguments.get("-out") != null) {
            try {
                writeFile(arguments.get("-out"), data);
            } catch (IOException e) {
                System.out.println("Error !" + e.getMessage());
                throw new IOException();
            }
        } else {
            System.out.println(data);
        }

    }


    public static void writeFile(String filename, String data) throws IOException {
        FileWriter file = new FileWriter(filename);
        file.write(data);
        file.close();
    }
}





