import java.util.Scanner;
public class aggregate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total_cost[] = new int[1000];
        // int capacity[] = new int[1000];
        int costperstep = 0;
        int usedcapacity=0;
        int logical_capacity = 1;
        int input;
        int total_steps = 0;
        int checking=1;
        double amorcost = 0;
        int totalcost=0;
        while(checking==1){
            System.out.println("PRESS 1 TO RUN AND PRESS 2 TO EXIT");
            checking = sc.nextInt();
            if(checking==1){
                System.out.println("ENTER THE ELEMENT TO BE INSERTED");
                input = sc.nextInt();
                if(usedcapacity==logical_capacity){
                    costperstep = logical_capacity+1;
                    logical_capacity = logical_capacity*2;
                    usedcapacity+=1;
                    totalcost+=costperstep;
                    total_steps+=1;
                    total_cost[total_steps-1] = costperstep;
                }
                else{
                    costperstep=1;
                    totalcost+=costperstep;
                    usedcapacity+=1;
                    total_steps+=1;
                    total_cost[total_steps-1] = costperstep;
                }      
            }
            else{
                break;
            }
            
            }

            amorcost = ((1.0 * totalcost)/total_steps);

            System.out.print("TOTAL COST IS");
            
            
            for(int i=0;i<total_steps;i++){
                System.out.println(total_cost[i]);
            }
            
            
            System.out.println("THE AMORTIZED COST = "+amorcost);
        
    }
}
