/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author nikhilsultania
 */
class Input{
    int length;
    Pattern pattern;
    int[] pile;
    Input (String s){
        length = s.indexOf(" ");
        String[] arr = s.substring(length+1).split(",");
        pile = new int[arr.length];
        for(int i =0;i<arr.length;i++){
            pile[i] = Integer.parseInt(arr[i]);
        }
        String pat ="";
        for(int i=0;i<length;i++){
            if(s.charAt(i)=='?')
                pat+="[#.]";
            else
                pat+= "[" + s.charAt(i)+"]";
        }
        pattern = Pattern.compile(pat);
    }
    String generateSequence(char c,int l){
        String s ="";
        for(int i=0;i<l;i++){
          s+=c;
        }
        return s;
    }
    static ArrayList<ArrayList> generate(int total,int listSize){
        
        ArrayList al = new ArrayList();
        if(listSize == 1){   
           al.add(new ArrayList());
           ((ArrayList)al.get(0)).add(total);
        }
        else{
        for(int i=0;i<=total;i++){
            int j =i;
            var temp = generate(total-i,listSize-1);
            temp.forEach(x -> x.add(0,j));
            al.addAll(temp);
         }
        }
        return al;
    }
    int count(){
        int total = length - pile.length + 1;
        for(int i : pile){
            total-=i;
        }
        int count =0;
        ArrayList<ArrayList> perms = generate(total,pile.length+1);
        for(ArrayList iter : perms){
         String s = generateSequence('.',(int)iter.get(0));
         for(int i=0;i<pile.length;i++){
          s+= generateSequence('#',pile[i]) + generateSequence('.',(int)iter.get(i+1)) + ".";   
         }
         s = s.substring(0,s.length()-1);
         if(pattern.matcher(s).matches())
             count++;
      }
        return count;
    }
}
public class prog12 {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String s = sc.nextLine();
     ArrayList<Input> al = new ArrayList<>();
     while(s!=""){
       al.add(new Input(s));
       s = sc.nextLine();
     }
        int sum =0;
        for(Input i : al){
            sum+= i.count();
        }
        System.out.println(sum);
    }
}
