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

// Idea : 2^(No. of matches -1 ) for each
// no of matches 
public class prog4 {

    static int[][] count = new int[206][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i =0;
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
          s = s.substring(s.indexOf(":")+1);
          String[] win = s.substring(0, s.indexOf("|")).trim().split(" ");
          String us = s.substring(s.indexOf("|")+1).trim();
          if(us.charAt(1) == ' ')
              us = " " + us;
          us = " " + us;
          int n = 0;
          for(String w : win){
            if(w.length() == 0)
                continue;
            if(w.length()== 1)
              w = "  " + w;
            if(us.contains(w)){
//               System.out.println(w + " " + us.charAt(us.indexOf(w)) + us.charAt(us.indexOf(w)+1) + us.charAt(us.indexOf(w)+2));
                  n++;
              }
          }
//          if(check(stin)){
//           sum+= Integer.parseInt(s.substring(s.indexOf(" ")+1, s.indexOf(":")));   
//          }
//          sum += (int)Math.pow(2, n-1);
          count[i][0] = 1;
          count[i][1] = n;
          i++;
       }
      
        for(i=0;i<count.length;i++){
            sum+= count[i][0];
            for(int j=1;j<=count[i][1];j++){
                count[i+j][0] += count[i][0];
            }
        }
        System.out.println("Sum =" + sum);
    }
    
}
