/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author nikhilsultania
 */

class Bet{
    String hand;
    byte type;
    int bid;

    public Bet(String hand, int bid) {
        this.hand = hand;
        this.bid = bid;
        hand = hand.replace("J", ""); // Crazy Idea works for 6,5,0,1,2
        if(hand.length() == 0 || hand.replace(hand.charAt(0)+"","").length() == 0){
            type = 0;//prog7.typePriority[0];
        } else if(hand.replace(hand.charAt(0)+"","").length() == 1){
            type = 1;//prog7.typePriority[1];
        } else if(hand.substring(1).replace(hand.charAt(1)+"","").length() == 0){
            type = 1;//prog7.typePriority[1];
        } else if(hand.replace(hand.charAt(0)+"","").replace(hand.replace(hand.charAt(0)+"","").charAt(0)+"","").length() == 0){
            type = 2;//prog7.typePriority[2];
        } else if(hand.replace(hand.charAt(0)+"","").length() == 2 || 
                  hand.substring(1).replace(hand.charAt(1)+"","").length() == 1 ||

                hand.substring(2).replace(hand.charAt(2)+"","").length() == 0 ){
            type = 3;//prog7.typePriority[3];
        } else if ((new HashSet(Arrays.asList(hand.split("")))).size() == 3){
            type = 4;//prog7.typePriority[4];
        } else if ((new HashSet(Arrays.asList(hand.split("")))).size() == 4){
            type = 5;//prog7.typePriority[5];
        } else {
            type = 6;//prog7.typePriority[6];
        }
    }
    
    
}
public class prog7 {
    //public static final String[] typePriority = {"Five","Four","Full","Three","Two","One","High"};
    public static final String cardPriority = "AKQT98765432J";
    
    public static boolean islessthan(Bet A,Bet B){
        if(A.type < B.type){
            return false;
        } else if (A.type > B.type){
            return true;
        } else{
            for(int i=0;i<5;i++){
                if(cardPriority.indexOf(A.hand.charAt(i)) < cardPriority.indexOf(B.hand.charAt(i))){
                    return false;
                } else if(cardPriority.indexOf(A.hand.charAt(i)) > cardPriority.indexOf(B.hand.charAt(i))){
                    return true; 
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Bet> arr = new LinkedList();
      while(sc.hasNextLine()){
          String s = sc.nextLine();
          if(s == ""){
              break;
          }
          arr.add(new Bet(s.substring(0, s.indexOf(" ")),Integer.parseInt(s.substring(s.indexOf(' ')+1))));
//          System.out.println(cry);

      }
      arr.sort((Bet A, Bet B) -> {
          if(islessthan(A, B)){
              return -1;
          } else{
              return 1;
          }
        });
       int sum =0;
      for(int i=0;i<arr.size();i++){
          sum += arr.get(i).bid * (i+1);
      }
        System.out.println("sum:" + sum);
    }
}
