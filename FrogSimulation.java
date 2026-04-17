public class FrogSimulation{
    private int goalDistance;
    private int maxHops;
    public FrogSimulation(int dist, int numHops){
        goalDistance = dist;
        maxHops = numHops;
    }
    public boolean simulate(){
        int position = 0;

        for( int i = 0;i < maxHops;i++){
            position +=hopDistance();
            if (position >= goalDistance){
                return true;
            }
            if (position < 0){
                return false;
            }
        }
        return false;
    }
    public double runSimulations(int num){
        int countSuccess = 0;
        for(int i = 0; i < num; i++){
            if(simulate()){
                countSuccess++;
            }
        }
        return (double) countSuccess / num;
        private int hopDistance() {
            return 0;
        }
    }
