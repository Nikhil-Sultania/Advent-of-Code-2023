/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nikhilsultania
 */
record position(int row,int col){};
public class prog11 {
    static ArrayList<String> arr = new ArrayList<>();
    static ArrayList<position> pos = new ArrayList(); 
    static boolean checkcol(int i){
        for(String s:arr)
          if(s.charAt(i)=='#')
            return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] extrarow = new int[0];
      while(s!=""){
          arr.add(s);
          int i = extrarow.length;
          extrarow = Arrays.copyOf(extrarow, i+1);
          if(s.indexOf('#') == -1){
              if (i==0) extrarow[0] = 1;
              else extrarow[i] = extrarow[i-1]+1; 
          } else{
              if (i==0) extrarow[0] = 0;
              else extrarow[i] = extrarow[i-1]; 
          }
          s = sc.nextLine();
      }
      System.gc();
      
      int[] extracol = new int[arr.get(0).length()];
       for(int i=0;i<arr.get(0).length();i++){
           if(checkcol(i)){
//               for(int j = 0;j<arr.size();j++){
//                   String st = arr.get(j);
//                arr.set(j, st.substring(0, i) + "." + st.substring(i));//replicate
//               }
//               i++; // avoids infinite loop

            if(i==0)
                extracol[0] =1;
            else extracol[i] = extracol[i-1] +1;
           } else {
               if(i==0)
                extracol[0] =0;
               else extracol[i] = extracol[i-1];
           }
       }
       
       
       for(String st: arr)
           System.out.println(st);
       for(int i=0;i<arr.size();i++){
           s =arr.get(i);
           for(int j = 0;j<s.length();j++){
             if(s.charAt(j) == '#')
               pos.add(new position(i,j));
           }
       }
        
       long sum =0;
       for(int i=0;i<pos.size()-1;i++){
           position first = pos.get(i);
           for(int j=i+1;j<pos.size();j++){
              sum+= Math.abs(first.row() - pos.get(j).row()) 
                  + 999999 * Math.abs(extrarow[first.row()] - extrarow[pos.get(j).row()]) 
                  + Math.abs(first.col() - pos.get(j).col())
                  + 999999* Math.abs(extracol[first.col()] - extracol[pos.get(j).col()]);
           }   
       }
        System.out.println(sum);
    }
}
