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
class Lens{
    String label;
    byte focal_length;
    public Lens(String s){
        String[] temp = s.split("=");
        label = temp[0];
        focal_length = Byte.parseByte(temp[1]);
    }
}
public class prog15 {
    static short hash(String s){
        char[] temp = s.toCharArray();
        short current =0;
        for(char c : temp){
          current+= (short)c;
          current*=17;
          current%=256;
        }
        return current;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        ArrayList<Lens> boxes[] = new ArrayList[256];
        Arrays.setAll(boxes, x -> new ArrayList());
        
        for(String s: input){
            if(s.charAt(s.length()-1) == '-'){
             String st = s.substring(0, s.length()-1);
             boxes[hash(st)].removeIf(x -> x.label.equals(st));
            } else{
             Lens l = new Lens(s);
             var temp = boxes[hash(l.label)];
             int i =0;
             while(i<temp.size()){
                 String lab = temp.get(i).label;
                 if(lab.equals(l.label)){
                     temp.set(i, l);
                     break;
                 }
                 i++;
             }
             if(i == temp.size()){
                 temp.add(l);
             }
            }
        }
        long sum =0;
        
//        for(String s: input)
//            sum+= hash(s);
        
       for(int i=1;i<=256;i++){
           int power = 0;
           int size = boxes[i-1].size();
           for(int j=1;j<= size;j++){
              power +=  j * boxes[i-1].get(j-1).focal_length;
           }
           power*=i;
           sum+=power;
       }
        System.out.println("Sum:"+sum);
    }
}
