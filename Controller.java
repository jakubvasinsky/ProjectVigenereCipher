package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;

public class Controller {
    public Button btn2;
    public Button btn3;
    public Button btn1;
    public TextArea txtarea;

    public void Button2Action(ActionEvent actionEvent) throws Exception {
     /*   String strData="";

        try {
            SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
            byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
            strData=new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;*/
    }

    public void Button1Action(ActionEvent actionEvent) throws Exception{
      /*  String strData="";

        try {
            SecretKeySpec skeyspec=new SecretKeySpec(strData.getBytes(),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            byte[] encrypted=cipher.doFinal(strData.getBytes());
            strData=new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }*/

    }

    public void Button3Action(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile !=null){

        }

    }
}
