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
public class prog14 {
//    static String[] cycle(String block,int limit){
//        for(int i=0;i<limit;i++){
//       //north
//        
//        
//        //west
//        
//        
//        //south
//        
//        
//        //east
//       }
//    }
//    static int loadLine(String line){
//        String[] s = line.split("#");
//        int[] arr = new int[s.length];
//        for(int i=0;i<s.length;i++){
//            arr[i] = s[i].replace(".", "").length();
//        }
//        int n = line.length();
//        int load =0;
//        for(int i=0;i<s.length;i++){
//            load+=(arr[i]*(2*n - arr[i] +1))/2;
//            n-= (s[i].length()+1);
//        }
//      return load;
//    }
//    static int load(String[] block){
//        int load =0;
//        int len = block[0].length();
//        for(int i=0;i<len;i++){
//            load+= loadLine(vertString(block,i));
//        }
//        return load;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
            String[] block = new String[0];
            while(s!=""){
             block = Arrays.copyOf(block,block.length+1);
             block[block.length-1] = s;
             s = sc.nextLine();
            }     
            //load(block)
//        System.out.println("Load:"+ loadbf(cycle(block,1000)));
    }  
}
