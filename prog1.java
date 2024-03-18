/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author nikhilsultania
 */
public class prog1 {
    public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      String cry="";
      while(sc.hasNextLine()){
          String s = sc.nextLine();
          if(s == ""){
              break;
          }
          cry += s+";";
//          System.out.println(cry);
      }
      StringTokenizer st = new StringTokenizer(cry,";");
//        System.out.println(""+st.countTokens());
      int count = 0;
      while(st.hasMoreTokens()){
          String s = st.nextToken();
          System.out.println(""+s);
          s = s.replace("one","o1e");
          s= s.replace("two","t2o");
          s = s.replace("three","t3e");
          s = s.replace("four","f4r");
          s= s.replace("five","f5e");
          s= s.replace("six","s6x");
          s= s.replace("seven","s7n");
          s= s.replace("eight","e8t");
          s= s.replace("nine","n9e");
          
          
          for(char c : s.toCharArray()){
              if(Character.isDigit(c)){
                  count += (c-48)*10;
                  break;
                  
              }
          }
          for(int i = s.length()-1; i>=0;i--){
              char c = s.charAt(i);
              if(Character.isDigit(c)){
                  count += c-48;
                  break;
              }
          }
          System.out.println("Sum:"+count);
      }
        System.out.println("sum:"+count);
    }
}
