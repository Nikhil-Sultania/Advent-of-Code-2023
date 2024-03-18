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
class Pipe{
    char d1,d2;
    char fromDir;
    int[] pos;
    Pipe(int[] pos,char fromDir){
        this.pos =pos;
        this.fromDir = fromDir;
        char c = prog10.arr[pos[0]][pos[1]];
        switch(c){
            case '|':
                d1 = 'n';
                d2 = 's';
                break;
            case '-':
                d1 = 'e';
                d2 = 'w';
                break;
            case 'L':
                d1 = 'n';
                d2 = 'e';
                break;
            case 'J':
                d1 = 'n';
                d2 = 'w';
                break;
            case '7':
                d1 = 's';
                d2 = 'w';
                break;
            case 'F':
                d1 = 's';
                d2 = 'e';
                break;
            case '.':
                d1 = '0';
                d2 = '0';
                break;
            default:
                System.out.println("Unknown pipe type");
                break;
        }
    }
        
     private char nextC(){
         char inv = switch(fromDir){
             case 'n'->'s';
             case 's'-> 'n';
             case 'e'-> 'w';
             case 'w' -> 'e';    
             default ->'.';
         };
         return d1==inv?d2:d1;
    }
     public Pipe next(){
         char next = nextC();
         return new Pipe(new int[]{
                                   pos[0] + switch(next){
                                                      case 'n' -> -1;
                                                      case 's' -> 1;
                                                      default  -> 0;
                                                     },
                                   pos[1] + switch(next){
                                                      case 'e' -> 1;
                                                      case 'w' -> -1;
                                                      default  -> 0;
                                                     }
                                   },
                         next);
     }
     
}
public class prog10 {
    static char[][] arr = new char[0][]; 
    // odd = never even
    // so for inside points in all directions it will be odd no. of edges
    // not redundant cuz outsiders could see odd edges in upto 3 sides at once
    static ArrayList<int[]> posits = new ArrayList<>(){
            @Override
           public boolean contains(Object o){
               int[] i = (int [])o;
               for(int[] j : this){
                   if(Arrays.equals(i,j)){
                       return true;
                   }
               }
               return false;
           }
        };
    public static char getPipeLetter(char dir1, char dir2) {

        if ((dir1 == 'n' && dir2 == 's') || (dir1 == 's' && dir2 == 'n')) {
            return '|';
        } else if ((dir1 == 'e' && dir2 == 'w') || (dir1 == 'w' && dir2 == 'e')) {
            return '-';
        } else if (dir1 == 'n' && dir2 == 'e') {
            return 'L';
        } else if (dir1 == 'n' && dir2 == 'w') {
            return 'J';
        } else if (dir1 == 's' && dir2 == 'w') {
            return '7';
        } else if (dir1 == 's' && dir2 == 'e') {
            return 'F';
        } else {
            throw new IllegalArgumentException("Unknown pipe type");
        }

    }

    static boolean check4(int i,int j){
        //up
        int edges = 0;
        for(int a = 0; a < i ; a++){
            Pipe temp = new Pipe(new int[]{a,j},'s');
            if(posits.contains(temp.pos) && temp.d1!='n' && temp.d2 !='n' &&  temp.d1!='s' && temp.d2 !='s')
                edges++;
        }
        if(edges%2== 0 && edges!=0)
            return false;
        edges = 0;
        //down
        for(int a = i+1; a < arr.length ; a++){
            Pipe temp = new Pipe(new int[]{a,j},'s');
            if(posits.contains(temp.pos) && temp.d1!='n' && temp.d2 !='n' &&  temp.d1!='s' && temp.d2 !='s')
                edges++;
        }
        if(edges%2== 0 && edges!=0)
            return false;
        edges = 0;
        //left
        for(int a = 0; a < j ; a++){
            Pipe temp = new Pipe(new int[]{i,a},'e');
            if(posits.contains(temp.pos) && temp.d1!='w' && temp.d2 !='w' &&  temp.d1!='e' && temp.d2 !='e')
                edges++;
        }
        if(edges%2== 0 && edges!=0)
            return false;
        edges = 0;
        //right
        for(int a = j+1; a < arr[0].length ; a++){
            Pipe temp = new Pipe(new int[]{i,a},'e');
            if(posits.contains(temp.pos) && temp.d1!='w' && temp.d2 !='w' &&  temp.d1!='e' && temp.d2 !='e')
                edges++;
        }
        if(edges%2== 0)
            return false;
        return true;
    }
    public static void main(String[] args) {
        Pipe left = null;
        Pipe right = null;
        int[] pos ={0,0};
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
      while(s!=""){
          arr = Arrays.copyOf(arr,arr.length+1);
          arr[arr.length-1] = s.toCharArray();
          if(s.indexOf('S')!= -1){
            pos = new int[]{(arr.length-1),s.indexOf('S')};  
          }
          s = sc.nextLine();
      }
      System.gc();
      
      try{
          Pipe p = new Pipe(new int[]{pos[0]-1,pos[1]},'n');
          if(p.d1 == 's' || p.d2 == 's'){
              left = p; 
          }
              
      } catch(ArrayIndexOutOfBoundsException e){
          
      }
      
      try{
          Pipe p = new Pipe(new int[]{pos[0],pos[1]-1},'w');
          if(p.d1 == 'e' || p.d2 == 'e'){
              if(left == null)
                  left = p;
              else right =p;
          }
              
      } catch(ArrayIndexOutOfBoundsException e){
          
      }
                  try{
          Pipe p = new Pipe(new int[]{pos[0],pos[1]+1},'e');
          if(p.d1 == 'w' || p.d2 == 'w'){
                            if(left == null)
                  left = p;
              else right =p;
          }
              
      } catch(ArrayIndexOutOfBoundsException e){
          
      }
                        try{
          Pipe p = new Pipe(new int[]{pos[0]+1,pos[1]},'s');
          if(p.d1 == 'n' || p.d2 == 'n'){
                            if(left == null)
                  left = p;
              else right =p; 
          }
              
      } catch(ArrayIndexOutOfBoundsException e){
          
      }
                        
       try{
           arr[pos[0]][pos[1]] = getPipeLetter(left.fromDir, right.fromDir);
       } catch(IllegalArgumentException e){
          arr[pos[0]][pos[1]] = getPipeLetter(right.fromDir, left.fromDir); 
       }
       
       int steps =0;
       posits.add(pos);
       while(!Arrays.equals(left.pos, right.pos)){
           posits.add(left.pos);
           posits.add(right.pos);
           left = left.next();
           right = right.next();
       }
       posits.add(left.pos);
       for(int i = 0;i<arr.length;i++){
           for(int j =0 ; j<arr[0].length;j++){
             if(!posits.contains(new int[]{i,j})){
                 if(check4(i,j)){
                     steps++;
                     System.out.print('I');
                 } else{
                     System.out.print('O');
                 }
                 } else
                   System.out.print(arr[i][j]);
          }
           System.out.println("");
       }
        System.out.println(steps);    
    }
}
