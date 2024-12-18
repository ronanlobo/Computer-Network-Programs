package CNLabPrograms;
import java.util.*;
class LineCoding
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of bits: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter bits: ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("\nUnipolar Line Coding: ");
        for(int i = 0; i<n; i++){
            if(arr[i]==1) System.out.print("''");
            else System.out.print("__");
        }
        System.out.println("\nPolar NRZ Line Coding: ");
        for(int i = 0; i<n; i++){
            if(arr[i]==1) System.out.print("__");
            else System.out.print("''");
        }
        System.out.println("\nPolar RZ Line Coding: ");
        for(int i = 0; i<n; i++){
            if(arr[i]==1) System.out.print("'|_");
            else System.out.print("_|'");
        }
        System.out.println("\nManchester Line Coding: ");
        for(int i = 0; i<n; i++){
            if(arr[i]==1) System.out.print("_|'");
            else System.out.print("'|_");
        }
        System.out.println("\nDifferential Manchester Line Coding: ");
        int lastbit = 1; //assume first bit as high
        for(int i = 0; i<n; i++){
            if(arr[i]==1){
                if(lastbit == 1) System.out.print("_|'");
                else System.out.print("'|_");
            }
            else{
                if(lastbit == 1) System.out.print("|_|'");
                else System.out.print("|'|_");
            }
            lastbit=arr[i];
        }
        sc.close();
    }
}