package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public File selectedFile;
    public Button btn2;
    public Button btn3;
    public Button btn1;
    public TextArea txtarea;
    String data = "";
    String newData = "";
    String key = "";
    boolean Charsize = false;

    public void Button3Action(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        selectedFile = fc.showOpenDialog(null);

    }


    public void Button2Action(ActionEvent actionEvent) throws Exception {
        Scanner fileReader = new Scanner(selectedFile);
        char character;
        int ascicode;


        key = txtarea.getText().toLowerCase();
        System.out.println("Used key: "+key);

        char keyAsciChar;
        int keyAsciInt;
        while (fileReader.hasNextLine()) {
            data = fileReader.nextLine();
            System.out.println("Content in the file before decryption: "+data);
        }
        int j = 0;
        for (int i = 0; i < data.length(); i++) {
            character = data.charAt(i);
            ascicode = character;
            if (ascicode >= 65 && ascicode <= 90 || ascicode >= 97 && ascicode <= 122) {

                if (key.length() == j) {

                    j = 0;
                }

                keyAsciChar = key.charAt(j);
                Charsize = isBig(character);

                keyAsciInt = keyAsciChar;


                keyAsciInt = keyAsciInt - 97;

                ascicode = ascicode - keyAsciInt;

                if (Charsize) {
                    if (ascicode > 90) {
                        ascicode -= 26;
                    }
                } else {
                    if (ascicode > 122) {
                        ascicode -= 26;
                    }
                }
                character = (char) ascicode;
                j++;
            }
            newData += character;
        }
        System.out.println("Decrypted content from the file: " +newData);
        newData = "";

    }


    public void Button1Action(ActionEvent actionEvent) throws Exception {
        Scanner fileReader = new Scanner(selectedFile);
        char character;
        int ascicode;


        key = txtarea.getText().toLowerCase();
        System.out.println("Used key: "+key);


        char keyAsciChar;
        int keyAsciInt;
        while (fileReader.hasNextLine()) {
            data = fileReader.nextLine();
            System.out.println("Content in the file before encryption: " + data);
        }
        int j = 0;
        for (int i = 0; i < data.length(); i++) {
            character = data.charAt(i);
            ascicode = character;
            if (ascicode >= 65 && ascicode <= 90 || ascicode >= 97 && ascicode <= 122) {

                if (key.length() == j) {

                    j = 0;
                }

                keyAsciChar = key.charAt(j);
                keyAsciInt = keyAsciChar;
                keyAsciInt = keyAsciInt - 97;

                ascicode = keyAsciInt + ascicode;


                if (ascicode > 90 && ascicode < 97 || ascicode > 122) {
                    ascicode -= 26;
                }
                character = (char) ascicode;
                j++;
            }
            newData += character;
        }
        System.out.println("Encrypted content from the file: " + newData);

    }

    public boolean isBig(char ch) {
        int charint = ch;
        if (charint >= 65 && charint <= 90) {
            return true;
        } else {
            return false;
        }
    }


    public void createFile(String encryptedData) throws Exception {
        File file = new File("C:\\Users\\jakub\\IdeaProjects\\ProjectGUIEncryption\\src\\file.txt");

        if (file.createNewFile()) {
            System.out.println("File is created");
        } else {
            System.out.println("File already exists");
        }

        FileWriter writer = new FileWriter(file);
        writer.write(encryptedData);
        writer.close();
    }
}
