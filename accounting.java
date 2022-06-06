import java.util.*;
public class accounting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input=1;
        int valueTaken = 0;
        int currentCapacity=0;
        int totalCapacity=1;
        int costperstep = 0;
        int amortizedcostperstep = 0;
        int total_cost=0;
        int costarray[] = new int[1000];
        int stepnumber = 0;
        int balance = 0;
        int totalamortizedcost = 0;
        int expansioncost=0;
        int balancearray[] = new int[999];
        int costing=0;


        while(input==1){
        
        System.out.println("ENTER 1 TO RUN AND 2 TO EXIT");
        input = sc.nextInt();

        if(input==1){
            System.out.println("ENTER ELEMENT TO BE INSERTED");
            valueTaken = sc.nextInt();
            if(currentCapacity == totalCapacity){
                stepnumber+=1;
                currentCapacity+=1;
                amortizedcostperstep=3; //ignore 
                totalCapacity=totalCapacity*2;
                expansioncost = totalCapacity/2;
                costperstep=expansioncost + 1; // ignore
                total_cost=costperstep;
                balance = balance - total_cost+ amortizedcostperstep;
                costarray[stepnumber-1] = total_cost; // ignore
                balancearray[stepnumber-1] = balance;
            }
            else{
                currentCapacity+=1;
                stepnumber+=1;
                amortizedcostperstep=3; // ignore
                costperstep=1;// ignore
                total_cost=costperstep;
                balance = balance - total_cost+amortizedcostperstep;
                costarray[stepnumber-1] = total_cost; // ignore
                balancearray[stepnumber-1] = balance;
            }
        }
        else{
            break;
        }
    }
            System.out.println("THE TOTAL COST IS: ");
            for(int i=0;i<stepnumber;i++){
                System.out.println(costarray[i]);
            }

            System.out.println("THE TOTAL BALANCE IS: ");
            for(int i=0;i<stepnumber;i++){
                System.out.println(balancearray[i]);
            }

            costing = ((amortizedcostperstep*stepnumber)/stepnumber);

            System.out.println("THE TOTAL AMORTIZED COST IS "+costing);



    }
}
