/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithemtic_coding;

import java.util.ArrayList;

/**
 *
 * @author Alhassan
 */
public class Arithemtic_Binary {
   
     ArrayList<ChatLowHigh> list;
     
    public ArrayList<ChatLowHigh> prob(String text){
       float []probability=new float[100];
        list = new ArrayList();
      
       
        String t="";
        int index;
        int j=0;
        for(int i = 0 ; i < text.length();i++){
            
            if(t.indexOf(text.charAt(i)) == -1){
                probability[j]=1;
                t+=text.charAt(i);
                j++;
            }
            else{
                index=t.indexOf(text.charAt(i));
                probability[index] += 1;
                
            }
            
        }
        float low=0;
        float high=0;
        float prob;
         for(int x=0 ; x < j ;x++){
            prob=probability[x]/text.length();
                //System.out.println("Probability of char "+t.charAt(x)+" : "+prob );

                high =low+prob;
                list.add(new ChatLowHigh(t.charAt(x),low ,high));
                
                
                low=high;
               
            }
         /* for(ChatLowHigh loop :list ){
         System.out.println("Char "+loop.getChar() + " low   "+ loop.getLow() + "  high   "+ loop.getHigh());
         }*/
            Arithemtic_Binary h=new Arithemtic_Binary();
            
        return list;        
    }
    void anysymbol(String text ){
        
        ArrayList<Integer> code=new ArrayList<>();
        float lowRange=0;
        float highRange=1;
       
        
        for(int i = 0 ; i < text.length() ; i++){
            
            for(int j=0  ; j < list.size() ; j ++){
                
                if(text.charAt(i) == list.get(j).ch ){
                    if( lowRange < .5 && highRange > .5){
                        
                        
                        lowRange=lowRange+list.get(j).low*(highRange-lowRange);
                        
                        highRange=lowRange+list.get(j).high*(highRange-lowRange);
                        System.out.println("///////   No Scaling ///////////");
                        System.out.println("LowRange: "+lowRange + "\n"
                                + "HighRange: "+highRange);
                    }
                    else if( lowRange > .5 && highRange > .5){
                        // E2
                        System.out.println("//////   Scaling E2 /////////");
                        code.add(1);
                        lowRange =(float) ((lowRange  - 0.5)*2);
                        highRange=(float) ((highRange - 0.5)*2);
                        System.out.println("LowRange: "+lowRange + "\n"
                                + "HighRange: "+highRange);
                    }
                    else if( lowRange < 0.5 && highRange < 0.5){
                        // E1
                        System.out.println("//////   Scaling E1 /////////");
                        code.add(0);
                        lowRange  *=2;
                        highRange *=2;
                        System.out.println("LowRange: "+lowRange + "\n"
                                + "HighRange: "+highRange);
                        
                    }

                    
                }
            }
            
                
        }
        System.out.print("Code Is  0.");
        for(Integer loop : code ){
            System.out.print(loop);
        }
        System.out.println("");
    }
    
       

    public static void main(String[] args) {
        String text="aabaacaada";
        ArrayList<ChatLowHigh> list=new ArrayList<ChatLowHigh>();
        Arithemtic_Binary h=new Arithemtic_Binary();
        
        list=h.prob(text);
        h.anysymbol(text);
                
                 
        
    
    
    }
    
}
