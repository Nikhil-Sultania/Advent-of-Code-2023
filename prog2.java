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
public class prog2 {
    static boolean check(StringTokenizer st) throws Exception{
           while(st.hasMoreTokens()){
               String s = st.nextToken();
               StringTokenizer stin = new StringTokenizer(s,",");
               while(stin.hasMoreTokens()){
               String sin = stin.nextToken().trim();
               byte c = (byte)sin.indexOf(" ");
               byte sad = Byte.parseByte(sin.substring(0, c));
                   switch(sin.charAt(c+1)){
                       case 'r': if(sad >12)
                           return false;
                       break;
                       case 'g': if(sad >13)
                           return false;
                       break;
                       case 'b': if(sad >14)
                           return false;
                       break;
                       default : throw new Exception("Input parsing failure");
                   }
               }      
        }  
        return true;
    }
    
    static int power(StringTokenizer st) throws Exception{
        int r,g,b;
        r = g= b = 0;
           while(st.hasMoreTokens()){
               String s = st.nextToken();
               StringTokenizer stin = new StringTokenizer(s,",");
               while(stin.hasMoreTokens()){
               String sin = stin.nextToken().trim();
               byte c = (byte)sin.indexOf(" ");
               byte sad = Byte.parseByte(sin.substring(0, c));
                   switch(sin.charAt(c+1)){
                       case 'r': 
                           r = Math.max(r, sad);
                       break;
                       case 'g': 
                           g= Math.max(g, sad);
                       break;
                       case 'b': 
                           b= Math.max(b, sad);
                       break;
                       default : throw new Exception("Input parsing failure");
                   }
               }      
        }  
        return r*g*b;
    }
    
    public static void main(String args[]) throws Exception{
      Scanner sc = new Scanner(System.in);
      String cry="";
      while(sc.hasNextLine()){
          String s = sc.nextLine();
          if(s == "")
              break;
          cry += s+"#";
      }
      
      int sum =0;
      StringTokenizer st = new StringTokenizer(cry,"#");
      
      while(st.hasMoreTokens()){
          String s = st.nextToken();
          StringTokenizer stin = new StringTokenizer(s.substring(s.indexOf(":")+1),";");
          
//          if(check(stin)){
//           sum+= Integer.parseInt(s.substring(s.indexOf(" ")+1, s.indexOf(":")));   
//          }
          sum+= power(stin);
          
       }
      
        System.out.println("Sum =" + sum);
    }
}
