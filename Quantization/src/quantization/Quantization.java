/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantization;

import java.util.ArrayList;

/**
 *
 * @author Alhassan
 */
public class Quantization {
    
    
    ArrayList<CodeRangeQ> list;
        ArrayList<Range> range;
        ArrayList<Integer> compressed ;
    ArrayList<CodeRangeQ> CodeRangeQ(float step, float end){
        list=new ArrayList<>();
        range=new ArrayList<>();
        
        float maxError=(step/2);
        float numberOfLevels=(end/step);
        int code=0;
        
        float q=maxError;
        float startRange=0;
        float endRange=step-1;
        range.add(new Range(startRange , endRange));
        
        list.add(new CodeRangeQ(code,range,q));
        startRange=step;
        for(int i = 1 ; i < numberOfLevels ; i++){
            
            endRange=startRange+step-1;
            range.add(new Range( startRange ,endRange ) );
            code++;
            q +=step;
            list.add(new CodeRangeQ(code,range,q));
            startRange=endRange+1;
        }
        
        
        return list;
    }
    
    ArrayList<Integer> Compress(float[] arr , ArrayList<CodeRangeQ> compress){
        compressed=new  ArrayList<>();
        for(int x=0;x<arr.length;x++){
            for(int j=0 ; j<range.size();j++){
                if(range.get(j).start <= arr[x] && range.get(j).end >= arr[x])
                    compressed.add(list.get(j).code);
               
            }
        }
        
        return compressed;
    }
    
    ArrayList<Float> Decompress(ArrayList<Integer> comp,ArrayList<CodeRangeQ> list){
        ArrayList<Float> decomp=new ArrayList<>();
        for( int i = 0 ; i < comp.size() ; i++){
            for(int x=0 ;x<list.size();x++){
                if(comp.get(i).equals(list.get(x).code)){
                    decomp.add(list.get(x).q);
                }
            }
            
        }
        return decomp;
    }
    
    ArrayList<Float> ErrorSquar(float arr[],ArrayList<Float> decomp){
        ArrayList<Float> error=new ArrayList<>();
        for(int i = 0 ; i < arr.length ;i++){
            error.add((float)Math.pow(arr[i]-decomp.get(i), 2));
        }
        
        return error;
    }
    public static void main(String[] args) {
        float arr[]={13,97,8,55,39,217};
        //////////////////////////////////
        ArrayList<CodeRangeQ> list=new ArrayList<>();
        Quantization obj=new Quantization();
        ArrayList<Integer>  comp=new  ArrayList<Integer>();
        ArrayList<Float> decomp,error=new ArrayList<>();
        ///////////////
        list=obj.CodeRangeQ( 32, 256);
        System.out.println("Code |  Range         |  Q ");
        for(int i =0 ; i < 8 ; i++){
            
            System.out.print(list.get(i).code);
            System.out.print("    | "+list.get(i).range.get(i).start+" >>>> "+list.get(i).range.get(i).end+" | ");
            System.out.println(list.get(i).q);
        }
        ///////////////////////////
        comp=obj.Compress(arr,list);
        System.out.print("Compress ");
        for(int j = 0 ; j < arr.length ; j++){
            System.out.print(comp.get(j)+"  ");
        }
        ///////////////////////////////////
        System.out.println("");
        decomp=obj.Decompress(comp, list);
        for(int x=0 ; x< decomp.size();x++){
            System.out.print(decomp.get(x)+"  ");
        }
        System.out.println("");
        ////////////////
        error=obj.ErrorSquar(arr, decomp);
        for(int x = 0 ; x<arr.length ; x++){
            System.out.print(error.get(x)+"  ");
        }
    }

    

    
    
}
