import java.util.Scanner;
import java.io.*;

public class Lab09{
    
    public static void main(String[] args){
    	int choice=1;
        int colornum;
        String color;
    	Scanner sc=new Scanner(System.in);
        World world=new World();
        Scientist sci=new Scientist();
    	while(choice==1){
            System.out.print("Enter dimension to travel  >>");
            int dim=sc.nextInt();
            System.out.print("Enter units to travel? >>");
            int units=sc.nextInt();
            colornum=sci.move(dim,units,world);
            color=world.printcolor(colornum);
            printloc(sci.location);
            world.paint(sci.location);
            System.out.print(" with color "+ color);
            System.out.print("\nContinue? (0 to quit and 1 to continue) >>");
            choice=sc.nextInt();
        }
    }

    public static void printloc(int[] a){
        System.out.print("location [");
        for(int i=0;i<5;i++){
            System.out.print(" "+a[i]+" ");
        }
        System.out.print("]");
    }
}

    