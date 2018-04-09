/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw;

import java.util.ArrayList;

/**
 *
 * @author Alhassan
 */
public class LZW {
    ArrayList<Dictionary> dic;
    ArrayList<Integer> Lzw(String data){
        ArrayList<Integer> tags=new ArrayList<>();
        dic=new ArrayList<Dictionary>();
        // add in Dictionary 2 index!
        dic.add(new Dictionary(65,"A"));
        dic.add(new Dictionary(66,"B"));
        String input=data;
        String next="";
        
        //ABAA
        int dicindex=128;
        int findIndex = 0;
        int index=0;
        while(input.length()>0){
            System.out.println("while");
            int end=1;
            next=input.substring(0, end);
            System.out.println("0 < dic.size()  "+dic.size());
            
            int xi=0;
                for(int i = 0 ; i < dic.size() ;i++ ){
                    i=xi;
                    System.out.println("i=xi; "+i);
                  System.out.println("for: "+i);
                   System.out.println("next: "+next);
                   
                  System.out.println("dic.get(i)._char:"+dic.get(i)._String);
                  
                if(next.equals(dic.get(i)._String)){
                     index=dic.get(i)._number;
                    System.out.println(" index=dic.get(i)._number; "+index);
                   
                    next=input.substring(0, ++end);
                    System.out.println("next "+next);
                    xi=0;
                }
                else {
                    xi=i+1;
                    System.out.println("xi=i+1; "+xi);
                    
                        
                    
                }
                
                }
                System.out.println("end"+end);
                System.out.println("hsassssssss");
            do{
            
            System.out.println("hassan ");
            System.out.println(" dic.ad " +dic.add(new Dictionary(dicindex,next)));
            System.out.println("tags.add(i "+tags.add(index));
            dicindex++;
            input=input.substring(end-1);
            
            System.out.println("input  " +input);
            
            }while(2<3);{
            System.out.println("d");
        }
        
                       
            
        }
       return tags;  
    }
        
        
        
        
        
        
        
        
        
        
       
    
    public static void main(String[] args) {
        ArrayList<Integer> g=new ArrayList<>();
        LZW j=new LZW();
        
        g=j.Lzw("ABCDFG");
        
        for(int i = 0 ; i<g.size() ; i++){
            System.out.println("Tag: "+i+" >> "+g.get(i));
        }
    }
    
}
