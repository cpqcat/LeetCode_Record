public class change {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) five++;
            if (bills[i] == 10) ten++;
            if (bills[i] > 5) {
                int tenneed = (bills[i] - 5)/10;
            if( tenneed <= ten) {
                ten -= tenneed;
                if (five < 1) return false;
                else five--;
            }
            else {
                int fiveneed = (bills[i] - 5 - ten * 10)/5;
                ten = 0;
                if (fiveneed > five) return false;
                else five -= fiveneed;
            }
        }
    }
        return true;
    }
}