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
public class CodeRangeQ {
     
    int code;
    
    float q;
    
    ArrayList<Range> range=new ArrayList<>();
    
    public CodeRangeQ(int code ,ArrayList<Range> range , float q){
        this.code=code;
        this.range=range;
        this.q=q;
    }
}
