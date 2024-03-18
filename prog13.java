/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nikhilsultania
 */
public class prog13 {
    static String invert(String s,int i){
        return s.substring(0, i) + (s.charAt(i) == '.' ?'#':'.')+s.substring(i+1);
    }
    static boolean verifyh(String[] s , int row,boolean endnear){
        if(endnear){
           for(int i = 0;i<s.length-row;i++){
              if(!s[row - i-1].equals(s[row + i ]))
                  return false;// make row -i , row +i and limit to s.length - row if fails
           } 
        } else {
            for(int i = 0;i<row;i++){
              if(!s[row - i-1].equals(s[row +i]))
                  return false;
           }  
        }
        return true;
    }
    static boolean verifyv(String[] s , int col,boolean endnear){
        if(endnear){
           for(int i = 0;i<s[0].length()-col;i++){
              if(!vertString(s,col - i-1).equals(vertString(s,col + i)))
                  return false;
           } 
        } else {
            for(int i = 0;i<col;i++){
              if(!vertString(s,col- i-1).equals(vertString(s,col + i)))
                  return false;
           }  
        }
        return true;
    }
    static int checkHorizontal(String[] s){
        String ref = s[0];
        for(int i= s.length-1;i>0;i--){
            if(ref.equals(s[i])){
                if(verifyh(s,(i+1)/2,false))
                    return (i+1)/2;
            }
        }
        
        ref = s[s.length-1];
        for(int i =0;i<s.length-1;i++){
           if(ref.equals(s[i])){
               if(verifyh(s,(i+s.length)/2,true))
                    return (i+s.length)/2;
            }
        }
        return 0;
    }
    static String vertString(String[] s,int i){
        String vert = "";
        for(String st: s){
            vert+= st.charAt(i);
        }
        return vert;
    }
    static int checkVertical(String[] s){
       
        String ref = vertString(s,0);
        for(int i= s[0].length()-1;i>0;i--){
            if(ref.equals(vertString(s,i))){
                if(verifyv(s,(i+1)/2,false))
                    return (i+1)/2;
            }
        }
        
        ref = vertString(s,s[0].length()-1);
        for(int i =0;i<s[0].length()-1;i++){
           if(ref.equals(vertString(s,i))){
                if(verifyv(s,(i+s[0].length())/2,true))
                    return (i+s[0].length())/2;
            }
        }        return 0;
    }
    public static void main(String[] args) {
            int count =0;
            int row=0;
            int col=0;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while(s!=""){
            String[] block = new String[0];
            while(s!=""){
             block = Arrays.copyOf(block,block.length+1);
             block[block.length-1] = s;
             s = sc.nextLine();
            }
//            count++;
            int refrow = checkHorizontal(block);
            int refcol = checkVertical(block);
            int i;
            a:
            for( i =0;i<block.length;i++){
            for(int j= 0; j<block[i].length();j++){
                block[i] = invert(block[i],j);
            int colTemp;
            int rowtemp = checkHorizontal(block);
            if(rowtemp==0){
                colTemp = checkVertical(block);
                if(colTemp != 0 ){
                    if(colTemp!= refcol){
                    col+= colTemp;
//                    count++;
                    break a;
                    } else {
                        block[0] = invert(block[0],refcol);
                        colTemp = checkVertical(block);
                        if(colTemp!=0){
                            col+=colTemp;
                            break a;
                        }
                        block[0] = invert(block[0],refcol);
                        block[0] = invert(block[0],refcol-1);
                        colTemp = checkVertical(block);
                        if(colTemp!=0){
                            col+=colTemp;
                            break a;
                        }
                        block[0] = invert(block[0],refcol-1);
                    }
                }
            } else{
                if(rowtemp!=refrow){
                row+= rowtemp;
//                System.out.println(rowtemp);
//                System.out.println(i +" " + j);
//                count++;
                break a;
                } else{
                    colTemp = checkVertical(block);
                    if(colTemp != 0){
                    col+= colTemp;
//                    count++;
                    break a;
                    } else{
                        block[refrow] = invert(block[refrow],0);
                        rowtemp = checkHorizontal(block);
                        if(rowtemp!=0){
                            row+= rowtemp;
                            break a;
                        }
                        block[refrow] = invert(block[refrow],0);
                        block[refrow-1] = invert(block[refrow-1],0);
                        rowtemp = checkHorizontal(block);
                        if(rowtemp!=0){
                            row+= rowtemp;
                            break a;
                        }
                        block[refrow-1] = invert(block[refrow-1],0);
                    }
                }
            }
            
            block[i] = invert(block[i],j);
            
            }
            
          }
           
            if(i==block.length){
                System.out.println("--------");
         for(String st:block)
             System.out.println(st);
                System.out.println("--------");
            }   
            
           s = sc.nextLine();
        }
        System.out.println("Row:"+ row);
        System.out.println("Col:" + col);
        System.out.println(row*100+col);
        System.out.println(count);
    }
}
