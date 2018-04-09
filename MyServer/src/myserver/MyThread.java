package myserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MyThread extends Thread{
    Socket ST;
    MyThread(Socket ST){
        this.ST = ST;
    }
    public void run(){
        try {
            BufferedReader BR = new BufferedReader(new InputStreamReader(ST.getInputStream()));
            PrintWriter PW = new PrintWriter(ST.getOutputStream(),true);
            PW.println("First Message \n Second Message \n Third Message");
            JOptionPane.showMessageDialog(null, BR.readLine());
        } catch (IOException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
