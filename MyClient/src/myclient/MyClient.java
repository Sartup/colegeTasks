package myclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MyClient {

    public static void main(String[] args) {
        
        try {
            Socket CS = new Socket("127.0.0.1", 9090);
            BufferedReader BR = new BufferedReader(new InputStreamReader(CS.getInputStream()));
            PrintWriter PW = new PrintWriter(CS.getOutputStream(),true);
            String str;
            for(int i = 0; i < 3; i ++)
            {
                str = BR.readLine();
                JOptionPane.showMessageDialog(null, str);
            }
            PW.println("Thank you");
        } catch (IOException ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
