import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.lang.Math;
//created by Shixiong Jing
//lab #8

public class garden{
    
    public static void main(String[] args){
    	//create garden and print origin status
        int[] garden1=creategarden();
        int[] garden2=creategarden();
        print(garden1);
        print(garden2);
        //run 40 seasons
        for(int i=1;i<41;i++){
            //generate num of rutabegas
            Random rng=new Random();
            int num=rng.nextInt(5);
            System.out.println("Season: "+i+", "+num+" rutabega(s)");
            //grow and printout result
            garden1=grow(num,1,garden1);
            garden2=grow(num,2,garden2);
        }
        print(garden1);
        print(garden2);
        //calculate resized times
        double resize1=(Math.log((double)garden1.length/5))/(Math.log((double)2));
        double resize2=(garden2.length-5)/2;
        System.out.println("Pangloss garden size is "+garden1.length);
        System.out.println("Pangloss resized " +(int)resize1+" times.");
        System.out.println("Martin garden size is "+garden2.length);
        System.out.println("Martin resized " +(int)resize2+" times.");
    }

    //mehod to create new garden
    private static int[] creategarden(){
    	int[] garden=new int[5];
    	return garden;
    }

    //method to grow
    private static int[] grow(int num, int id, int[] garden){
        //find out how many places have been used
        int place=count(garden);
        //resize the array if not enough space
        while(num+place+1>garden.length){
            int[] newgarden;
            if(id==1){
                newgarden=new int[2*garden.length];
            }
            else{
                newgarden=new int[2+garden.length];
            }
            for(int i=0;i<garden.length;i++){
                if(i<garden.length){
                    newgarden[i]=garden[i];
                }
                else{
                    newgarden[i]=0;
                }
            }
            garden=newgarden;
            if(id==1){
                System.out.println("resized Pangloss's garden to "+garden.length);
            }
            else{
                System.out.println("resized Martin's garden to "+garden.length);
            }
        }
        
        //plant new rutabega
        for(int i=place;i<=place+num-1;i++){
            garden[i]=num;
        }
        return garden;
    }
    
    //find out how many places have been used
    private static int count(int[] garden){
        int place=0;
        for(int i=0;i<garden.length;i++){
            if(garden[i]==0){
                place=i;
                break;
            }
        }
        return place;
    }
    
    //method to print out garden status
    private static void print(int[] garden){
        System.out.print("[");
        for(int i=0;i<garden.length;i++){
            if(garden[i]==0){
                if(i<garden.length-1){
                    System.out.print(" ***,");
                }
                else{
                    System.out.print(" ***");
                }
            }
            else{
                System.out.print(" "+garden[i]+",");
            }
        }
        System.out.print("]\n");
    }
}