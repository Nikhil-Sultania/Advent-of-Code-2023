/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author nikhilsultania
 */
class Filter{
    long dest;
    long source;
    long range;

    public Filter(int dest, int source, int range) {
        this.dest = dest;
        this.source = source;
        this.range = range;
    }
    
    public Filter(String s) {
        String temp[] =s.trim().split(" ");
        dest = Long.parseLong(temp[0]);
        source = Long.parseLong(temp[1]);
        range = Long.parseLong(temp[2]);
    }
    
    public boolean isSuitable(long num){
        if(num>=source && num <= source+range){
            return true;
        } else {
            return false;
        }
    }
    
    public long apply(long num){
        return dest + num - source;
    }
        
}
class SillyMap{
    ArrayList<Filter> list = new ArrayList();
    public void add(Filter f){
        list.add(f);
    }
    public long value(long num){
      for(Filter f : list){
          if(f.isSuitable(num)){
              return f.apply(num);
          }
      }
      return num;
    }
    public static SillyMap compose(ArrayList maps){
      return new SillyMap(){
          @Override
          public long value(long num){
            return (long)maps.stream().reduce(num, (y,x) -> ((SillyMap)x).value((long)y));
          }
      };
    }
    
}
public class prog5 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
     BufferedReader f = new BufferedReader(new FileReader(new File("//Users//nikhilsultania//Downloads//data.txt")));   
     String s[] = f.readLine().substring(6).trim().split(" ");
     long[] seeds = new long[s.length];
     for(int i=0;i<s.length;i++){
         seeds[i] = Long.parseLong(s[i]);
     }
     f.readLine();
     f.readLine();
     ArrayList<SillyMap> al = new ArrayList<SillyMap>();
     

     for(int i =0;i<7;i++){
     al.add(new SillyMap());
     String filt = f.readLine();
     while(filt != null && !filt.isBlank()){
         al.get(i).add(new Filter(filt));
         filt = f.readLine();
     }
     f.readLine();
     }
     f.close();
     SillyMap silly = SillyMap.compose(al);
     long min= silly.value(seeds[0]);
     for(int i =0;i<seeds.length;i+=2){
         for(long j=0;j< seeds[i+1];j++){
         min = Math.min(min,silly.value(j+seeds[i]));
         }
     }
     System.out.println(min);
    }
}


