/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//                    lowRange=lowRange+low*(highRange-lowRange);
//                    highRange=lowRange+high*(highRange-lowRange);
/*double value = 1222.3457652133;
        value =Double.parseDouble(new DecimalFormat(".").format(value));
        System.out.println("double value "+value);*/
package arithemtic_coding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Alhassan
 */
public class Arithemtic_Coding {
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
            Arithemtic_Coding h=new Arithemtic_Coding();
            
          
        return list;  
        
    }
    double anysymbol(String text ){
        
        double lowRange=0;
        double highRange=1;
       
        
        for(int i = 0 ; i < text.length() ; i++){
            
            for(int j=0  ; j < list.size() ; j ++){
                
                if(text.charAt(i) == list.get(j).ch ){
                    /*double value = 1222.3457652133;
                    alue =Double.parseDouble(new DecimalFormat(".").format(value));
        System.out.println("double value "+value);*/
                    //System.out.println("Char: "+text.charAt(i));
                    //System.out.println("lowrange: "+lowRange+"charlow: "+list.get(j).low+"range: "+(highRange-lowRange));
                    double temp=lowRange;
                    lowRange=lowRange+list.get(j).low*(highRange-lowRange);
                   // System.out.println("lowrange "+ lowRange);
                   //lowRange=Double.parseDouble(new DecimalFormat("#.##").format(lowRange));
                   //System.out.println("Lower: "+lowRange);
                    //System.out.println("lowrange: "+temp+"charhigh: "+list.get(j).high+"range: "+(highRange-temp));
                    highRange=temp+list.get(j).high*(highRange-temp);
                   // highRange=Double.parseDouble(new DecimalFormat("#.##").format(highRange));
                    //System.out.println("Higher: "+highRange);
                    
                }
            }
            
                
        }
        double result=( ( lowRange+highRange)/2);
        System.out.println("Code Is: " +result);
        return result;
                
    }
    String Decompress(double code , int numberOfChars){
        String text="";
        char ch = 'U';
        String charToString = Character.toString(ch);
        double result=0.0f;
        double lowRange=0;
        double highRange=1;
        for(int i = 0 ; i < numberOfChars ; i++){
            
            result=(code-lowRange)/(highRange-lowRange);
            
            for(int x = 0 ; x < list.size() ; x++){
                
                if(list.get(x).getLow()  < result && list.get(x).getHigh() > result){
                   
                  //  System.out.println("Char Is: "+list.get(x).getChar());
                    
                    text += Character.toString(list.get(x).ch);
                    double temp=lowRange;
                            
                    lowRange=lowRange+list.get(x).getLow()*(highRange-lowRange);
                  //lowRange=Double.parseDouble(new DecimalFormat("#.###").format(lowRange));
                   // System.out.println("Lower: "+lowRange);
                    
                    highRange=temp+list.get(x).getHigh()*(highRange-temp);
                  //highRange=Double.parseDouble(new DecimalFormat("#.###").format(highRange));
                  //  System.out.println("Higher: "+highRange);
                  //  System.out.println("////////////////");
                }
            }
        }
    return text;
    }
  
       

    public static void main(String[] args) {
        String text="aabaacaada";
        int sizeOfText=text.length();
        double code=0.0;
        String textBackFromDecompress="";
        ArrayList<ChatLowHigh> list=new ArrayList<ChatLowHigh>();
        Arithemtic_Coding h=new Arithemtic_Coding();
        // ياعمر علشان الدالة بتاعة  اني سيمبل دي تشتغل لازم اية اللي يشتغل قبليها بروب دي اللي بتحسب الاحتمالات ماشي
        h.prob(text);
        code=h.anysymbol(text);
        
        textBackFromDecompress += h.Decompress( code , sizeOfText);
        //عمر النص اللي بيرجع من الدالة اللي بتفك الضغط بيتحط في اللي فوق دي علي طول وبعدين انا طبعتها اللي فيها اللي هو النص اللي رجع من الدالة بيش يامان
        System.out.println("textBackFromDecompress : "+textBackFromDecompress);
    
    }

    

    
        
    
    
}
