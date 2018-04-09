package myserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyServer {

    public static void main(String[] args) {
        
        
        try {
            ServerSocket Lis = new ServerSocket(9090);
            
            while(true)
            {
                MyThread th = new MyThread(Lis.accept());
                th.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
}
