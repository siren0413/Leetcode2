package question;

/**
 * Created by siren0413 on 1/27/14.
 */
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int totalGas = 0, currentGas = 0, index = 0;
        for(int i = 0; i < gas.length; i++){
            if(currentGas < 0) {
                currentGas = gas[i]-cost[i];
                index = i;
            }else{
                currentGas += gas[i]-cost[i];
            }
            totalGas += gas[i]-cost[i];
        }
        if(totalGas<0) return -1;
        return index;
    }
}
