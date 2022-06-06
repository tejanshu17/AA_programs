import java.util.*;
public class potential {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input=1;
        int value=0;
        int currentCapacity = 0;
        int maxCapacity = 1;
        int cost = 0;
        int potentialCost = 1;
        int totalcost = 0;
        int totalcostarray[] = new int[999];
        int expansionCost = 0;
        int summation = 0;
        double ans = 0.0;
        
        while(input==1){
        
        
        System.out.println("ENTER 1 TO RUN AND 2 TO EXIT");
        input = sc.nextInt();

        if(input==1){
            System.out.println("ENTER THE ELEMENT TO BE INSERTED");
            value = sc.nextInt();

            if(currentCapacity == maxCapacity){

                currentCapacity+=1;
                maxCapacity = maxCapacity*2;


                // now expansion occured so we find expansion cost

                expansionCost = maxCapacity/2;
                
                // normal cost which is always charged

                cost=1;

                // we find total cost which also includes potential cost
                
                totalcost = expansionCost+cost+potentialCost;

                totalcostarray[currentCapacity-1] = totalcost;
            }
            else{
                currentCapacity+=1;
                cost=1;


                // since there is a change in potential, potential cost will also be charged and total cost will change


                totalcost = cost+potentialCost;
                totalcostarray[currentCapacity-1] = totalcost;// display sake
            }

        }

        else{

            break;
        }


        }

        System.out.println("THE TOTAL COST AFTER EVERY ITERATION IS : ");

        for(int i=0;i<currentCapacity;i++){

            System.out.println("TOTAL COST: "+"               " +totalcostarray[i]);


        }

        for(int i=0;i<currentCapacity;i++){
            summation+=totalcostarray[i];
        }

        System.out.println(summation);

        ans = ((1.0*summation)/currentCapacity);

        System.out.println("THE TOTAL POTENTIAL COST IS : " +ans );

    }
}
