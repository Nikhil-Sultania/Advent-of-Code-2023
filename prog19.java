/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author nikhilsultania
 */
class Clause{
    char parameter;
    Predicate<Integer> op;
    String redirect;

    public Clause(String todo) {
        redirect = todo.substring(todo.indexOf(':')+1).strip();
        parameter = todo.charAt(0);
        int val = Integer.parseInt(todo.substring(2, todo.indexOf(":")));
        op = switch(todo.charAt(1)){
            case '<' -> a -> a < val;
            case '>' -> a -> a > val;
            default -> throw new UnsupportedOperationException("F you");
        };

    }

}
class Filter{
    ArrayList<Clause> iftree = new ArrayList();
    String def;
    Filter(String s){
       String[] tree = s.split(",");
       for(int i=0;i<tree.length-1;i++){
         iftree.add(new Clause(tree[i]));
       }
       def = tree[tree.length-1];
    }

    String evaluate(Part p){
        for(Clause c:iftree){
            int parameter = switch(c.parameter){
                case 'x'-> p.x;
                case 'm'-> p.m;
                case 'a'-> p.a;
                case 's'-> p.s;
                default -> throw new UnsupportedOperationException("You messed up in transmission");
            };
            if(c.op.test(parameter))
                return c.redirect;
        }
        return def;
    }
}
class Part{
    int x,m,a,s;
    public Part(String xmas){
        String[] splitted = xmas.split(",");
        x = Integer.parseInt(splitted[0].trim().substring(2));
        m = Integer.parseInt(splitted[1].trim().substring(2));
        a = Integer.parseInt(splitted[2].trim().substring(2));
        s = Integer.parseInt(splitted[3].trim().substring(2));
    }
}
public class prog19 {
    public static void main(String[] args) {
        ArrayList<Part> accepted = new ArrayList();
        HashMap<String,Filter> filters = new HashMap();
        ArrayList<Part> parts = new ArrayList();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while(s!=""){
         filters.put(s.substring(0, s.indexOf("{")),new Filter(s.substring(s.indexOf("{")+1,s.indexOf("}"))));
         s = sc.nextLine();
        }
        //parts
        s = sc.nextLine();
        while(s!=""){
         parts.add(new Part(s.substring(s.indexOf("{")+1,s.indexOf("}"))));
         s = sc.nextLine();
        }
        for(Part p : parts){
            Filter curr = filters.get("in");
            String response = curr.evaluate(p);
            while(!response.equals("R")){
                if(response.equals("A")){
                    accepted.add(p);
                    break;
                }
                curr = filters.get(response);
                response = curr.evaluate(p);
            }
        }
        int sum =0;
        for(Part p: accepted){
            sum+=p.x;
            sum+=p.m;
            sum+=p.a;
            sum+=p.s;
        }
        System.out.println("Sum:" + sum);
        System.out.println(parts.size());
    }
}
