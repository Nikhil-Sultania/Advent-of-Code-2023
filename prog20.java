/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

/**
 *
 * @author nikhilsultania
 */

/**
name in HashMap
*/
class Pulse{
    String signature;
    
}
class Module{
  String[] dest;
    public Module(String destinations) {
        dest = destinations.split(",");
        for(int i=0;i<dest.length;i++)
            dest[i]= dest[i].trim();
    }  
    abstract void evaluatePulse(Pulse p);
}

class Flip extends Module{
    final boolean ON =true;
    final boolean OFF = false;
    boolean current = OFF;
    public Flip(String destinations){
        super(destinations);
    }
}
public class prog20 {
    public static void main(String[] args) {
        int low=0;
        int high=0;
        
        
        System.out.println(low*high);
    }
}
