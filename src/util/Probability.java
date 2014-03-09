package util;

/**
 * Created by lvm on 3/8/14.
 */
public final class Probability {
    public final static Probability get = new Probability();

    public static int probability(double...numbers){
        double sum=0;
        for (double instance : numbers){ sum+=instance; }
        for (i=0;i<numbers.length;i++){ numbers[i] /= sum; }
        double randomNumber = Math.random(); double progression = 0;
        for (i=0;i<numbers.length;i++){
            if ((randomNumber > progression) && (randomNumber <= progression + numbers[i])) {
                return i;
                break;
            } else { progression += numbers[i]; }
        }
    }
}
