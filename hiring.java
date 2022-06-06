import java.util.Random;
public class hiring {
    public static void main(String[] args){
        int candrank[] = new int[]{2,4,3,5,6,7,8,9};
        int n = 8;

        int normalhires = normal(candrank,n);
        int randomhires = randomized(candrank,n);
        System.out.println("The number of hires by normal method is"+normalhires);
        System.out.println("The number of hires by random method is"+randomhires);
        
    }

    private static int randomized(int[] candrank, int n) {
        int randomcand[] = new int[n];
        for(int i=0;i<n;i++){
            randomcand[i] = candrank[i];
        }
        swaparr(randomcand,n);
        return normal(randomcand, n);
    }

    private static void swaparr(int[] randomcand, int n) {
        Random random = new Random();
        for(int i=0;i<n;i++){
            performswap(randomcand,i,random.nextInt((n-i)+i));
        }
    }

    private static void performswap(int[] randomcand, int i, int nextInt) {
        int temp=0;
        temp = randomcand[i];
        randomcand[i] = randomcand[nextInt];
        randomcand[nextInt] = temp;
    }

    private static int normal(int[] candrank, int n) {
        int best = 0;
        int candhirecount=0;
        for(int i=0;i<n;i++){
            if(candrank[i]>best){
                best=candrank[i];
                candhirecount+=1;
            }
        }
        return candhirecount;
    }
}
