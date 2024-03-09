import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
class Elements{
    int weight;
    int profit;
    double ratio;

    public Elements(int weight,int profit,double ratio){
        this.weight=weight;
        this.profit=profit;
        this.ratio=ratio;
    }
}
public class Fractional_knapsack{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of weights : ");
        int n = sc.nextInt();
        Elements elearr[] = new Elements[n];
        for(int i=0;i<n;i++){
            System.out.printf("Enter weight of object %d : ",i+1);
            int weight = sc.nextInt();
            System.out.printf("Enter profit on weight %d : ", i+1);
            int profit = sc.nextInt();
            double ratio = (double)profit/weight;
            elearr[i] = new Elements(weight,profit,ratio);
        }
        Arrays.sort(elearr, new Comparator<Elements>(){
            public int compare(Elements e1, Elements e2){
                return Double.compare(e2.ratio,e1.ratio);
            }
        });
        System.out.println("Enter the capacity of knapsack : ");
        int cap=sc.nextInt();
        double x[]= new double[n];
        for(int i=0;i<n;i++){
            x[i]=0;
        }
        for(int i=0;i<n;i++){
            if(elearr[i].weight>cap){
                x[i]=(double)cap/elearr[i].weight;
                break;
            }
            else{
                x[i]=1;
                cap-=elearr[i].weight;
            }
        }
        double maxProfit=0;
        for(int i=0;i<n;i++){
            maxProfit+=x[i]*elearr[i].profit;
        }
        System.out.printf("The maximum profit that can be obtained  is : %.2f",maxProfit);
    }
}

