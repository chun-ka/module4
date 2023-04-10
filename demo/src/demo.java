public class demo {

    public static int main(String[] args) {
        int solution(int[] coins, int amount) {
            int count=0;
            int temp;
            for (int i = 0; i < coins.length-1; i++) {
                for (int j = i+1; j < coins.length; j++) {
                    if (coins[j]>coins[i]){
                        temp=coins[j];
                        coins[j]=coins[i];
                        coins[i]=temp;
                    }
                }
            }
            for (int i = 0; i <coins.length ; i++) {
                int surplus=amount/coins[i];
                if (surplus==amount/coins[i]&& amount==coins[i]){
                    count+= surplus;
                    amount=0;
                }else {
                    if (amount>=coins[i]){
                        amount=amount%coins[i];
                        count+= surplus;
                    }
                }
            }
            for (int i = 0; i < coins.length; i++) {
                if (amount==coins[i]){
                    return count;
                }
            }
            return -1;

        }
    }
}
