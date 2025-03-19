package desafio.itau.springboot.dataTransfer;

import java.util.DoubleSummaryStatistics;

public class Statistics {
    
    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public Statistics(DoubleSummaryStatistics stats){
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.min = stats.getMin();
        this.max = stats.getMax();
    }

    public double getAvg() {
        return avg;
    }
    public long getCount() {
        return count;
    }
    public double getMax() {
        return max;
    }
    public double getMin() {
        return min;
    }
    public double getSum() {
        return sum;
    }
}
