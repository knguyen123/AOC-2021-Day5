import java.io.*;
import java.util.Scanner;
public class day5P2{
   public static void main(String[] args) throws FileNotFoundException{
      Scanner f = new Scanner(new File("coordinates.txt"));
      int[][] arr = new int[1000][1000];
      int x1 = 0;
      int x2 = 0;
      int y1 = 0;
      int y2 = 0;
      int s = 0; 
      int l = 0;
      int sy = 0;
      int ly = 0;
      int y = 0;
      int count = 0;
      while(f.hasNext()){
         x1 = Integer.parseInt(f.next());
         y1 = Integer.parseInt(f.next());
         x2 = Integer.parseInt(f.next());
         y2 = Integer.parseInt(f.next());
         if(x1==x2){
            if(y1>y2){
               s = y2;
               l = y1;
            }else{
               l = y2;
               s = y1;            
            }
            for(; s <= l; s++){
               arr[x1][s]++;
            }
         }else if(y1==y2){
            if(x1>x2){
               s = x2;
               l = x1;
            }else{
               l = x2;
               s = x1;            
            }
            for(; s <= l; s++){
               arr[s][y1]++;
            }
         }else{
            if(x1<x2){
               s = x1;
               l = x2;
               sy = y1; 
               ly = y2;
           }else{
               s = x2;
               l = x1;
               sy = y2;
               ly = y1;
            } 
            
            if(sy<ly){//if smaller x's y < larger x's y
               for(; s <= l; s++, sy++){
                  arr[s][sy]++;  
               }
            }else{
               for(; s <= l; s++, sy--){
                  arr[s][sy]++;  
               }
            }
  
         }
      }
         
      
      for(int r = 0; r < 1000; r++){
         for(int c = 0; c < 1000; c++){
            if(arr[r][c]>1){
               count++;
            }
         }
      }
      
      System.out.println(count);
   }
}


