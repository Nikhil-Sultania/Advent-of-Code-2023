/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author nikhilsultania
 */
class partN{
    int r;
    int c1;
    int c2;

    public partN(int r, int c1, int c2) {
        this.r = r;
        this.c1 = c1;
        this.c2 = c2;
    }


    public boolean equals(int r,int c) {
        if(r > this.r + 1 || r< this.r -1){
            return false;
        }
        if(c > this.c2 + 1 || c < this.c1 -1){
            return false;
        }
        return true;
    }
    
        public boolean equalsC(int c) {
        if(c > this.c2 + 1 || c < this.c1 -1){
            return false;
        }
        return true;
    }
        public int getVal(char[][] arr){
            return Integer.parseInt(String.valueOf(arr[r]).substring(c1,c2+1));
        }
    
}
public class prog3 {
    
    static HashMap<Integer, ArrayList<partN>> map  = new HashMap();
    static char[][] arr = new char[0][0];
        static int gear(int row,int col){
          int sum = 0;
          ArrayList al = new ArrayList();
          if(map.containsKey(row-1)){
              ArrayList temp = (ArrayList)map.get(row-1).clone();
              temp.removeIf(x -> !((partN)x).equalsC(col));
              al.addAll(temp);
          }
          if(map.containsKey(row)){
             ArrayList temp = (ArrayList)map.get(row).clone();
              temp.removeIf(x -> !((partN)x).equalsC(col));
              al.addAll(temp);  
          }
          if(map.containsKey(row+1)){
             ArrayList temp = (ArrayList)map.get(row+1).clone();
              temp.removeIf(x -> !((partN)x).equalsC(col));
              al.addAll(temp);  
          }
             if(al.size()== 2)
              sum = ((partN)al.get(0)).getVal(arr)* ((partN)al.get(1)).getVal(arr);
             
//              System.out.println("" + row + "," + col + ":" + al.size());
          return sum;
    }
    static boolean check(int r, int c1,int c2 ){
     for(int i = c1;i<=c2;i++){
         try{
             if(!Character.isDigit(arr[r-1][i]) && arr[r-1][i]!= '.')
                 return true;
         } catch(ArrayIndexOutOfBoundsException e){}
         try{
            if(!Character.isDigit(arr[r+1][i]) && arr[r+1][i]!= '.')
                 return true; 
         } catch(ArrayIndexOutOfBoundsException e){}
     }
     for(int i=r-1;i<=r+1;i++){
         try{
             if(!Character.isDigit(arr[i][c1-1]) && arr[i][c1-1]!= '.')
                 return true;
         } catch(ArrayIndexOutOfBoundsException e){}
         try{
            if(!Character.isDigit(arr[i][c2+1]) && arr[i][c2+1]!= '.')
                 return true; 
         } catch(ArrayIndexOutOfBoundsException e){} 
     }
    return false;    
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
      while(sc.hasNextLine()){
          String s = sc.nextLine();
          if(s == "")
              break;
          arr = Arrays.copyOf(arr,arr.length+1);
          arr[arr.length-1] = s.toCharArray();
      }
      System.gc();
      
      int sum =0;
      int start;
      for(int i=0;i<arr.length;i++){
          start = arr[0].length;
       for (int j=0;j<arr[0].length;j++){
          if(Character.isDigit(arr[i][j])){
              if( j == 0 || !Character.isDigit(arr[i][j-1]))
                  start =j;
           if(j == arr[0].length - 1 || !Character.isDigit(arr[i][j+1])){
               if(check(i,start,j)){
                   if(!map.containsKey(i)){
                       map.put(i,new ArrayList<partN>());
                   }
                   map.get(i).add(new partN(i,start,j));
               } 
           }
          }
       }
      }
      
      
      for(int i =0;i<arr.length;i++){
        for (int j=0;j<arr[0].length;j++){
            if(arr[i][j]=='*'){
                sum += gear(i,j);
            }
        }  
      }
        System.out.println(sum);
    }
}
