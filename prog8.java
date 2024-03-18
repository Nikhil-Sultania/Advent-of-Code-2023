/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author nikhilsultania
 */
class Node{
    Node left;
    Node right;
    final String lr;
    final String rr;
    final String name;
    public Node(String lr, String rr,String name) {
        this.lr = lr;
        this.rr = rr;
        this.name = name;
    }
    
    public Node left(){
        if(left==null)
           left = prog8.tree.get(lr);
        return left;
    }
    
    public Node right(){
        if(right==null)
           right = prog8.tree.get(rr);
        return right;
    }
    
    
}
public class prog8 {
    static HashMap<String,Node> tree = new HashMap<>();
//    private static boolean check(ArrayList<Node> al){
//        for(Node n:al)
//            if(!n.name.endsWith("Z")) return false;
//        return true;
//    }
    public static long lcm(long number1, long number2) {
    if (number1 == 0 || number2 == 0) {
        return 0;
    }
    long absNumber1 = Math.abs(number1);
    long absNumber2 = Math.abs(number2);
    long absHigherNumber = Math.max(absNumber1, absNumber2);
    long absLowerNumber = Math.min(absNumber1, absNumber2);
    long lcm = absHigherNumber;
    while (lcm % absLowerNumber != 0) {
        lcm += absHigherNumber;
    }
    return lcm;
}
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String map = sc.nextLine();
     sc.nextLine();
     String s =sc.nextLine();
     while(s!=""){

         tree.put(s.substring(0,3),new Node(s.substring(7,10),s.substring(12,15),s.substring(0,3)));
     s = sc.nextLine();
     }
     
     //Node current = tree.get("AAA"); // init
     ArrayList<Node> start = new ArrayList(tree.values());
     start.removeIf(x -> !x.name.endsWith("A"));
     
     long lcm =1;
     
     
     for(Node current : start){
     long steps =0;
     while(!(current.name.endsWith("Z"))){
//       while(!check(current)){
        char ch = map.charAt((int) (steps%(map.length())));
         if(ch == 'L'){
           current = current.left();
         } else {
           current = current.right();
         }
         steps++;
     }
     lcm = lcm(lcm,steps);
    } 
        System.out.println("Steps : "+lcm);
    }
   
}
