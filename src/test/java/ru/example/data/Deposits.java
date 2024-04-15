package ru.example.data;

public enum Deposits {

    MINIMAL_DEPOSIT("100", "1", "1", "100.08"),
    OPTIMAL_DEPOSIT("100000", "12", "25", "124951.16");

    private final String depositSum,
            depositDuration,
            depositRate,
            finalSum;

    Deposits(String depositSum, String depositDuration, String depositRate, String finalSum) {
        this.depositSum = depositSum;
        this.depositDuration = depositDuration;
        this.depositRate = depositRate;
        this.finalSum = finalSum;
    }

    public String getDepositSum() {
        return depositSum;
    }

    public String getDepositDuration() {
        return depositDuration;
    }

    public String getDepositRate() {
        return depositRate;
    }

    public String getFinalSum() {
        return finalSum;
    }
}
