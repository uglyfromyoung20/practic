package ru.ssau.tk.ugly.practic;

public class Settlement extends Location {
    private int settlement;
    private SettlementType type;

    public void setSettlement(int settlement) {
        this.settlement = settlement;
    }

    public int getSettlement() {
        return settlement;
    }

    public void setType(SettlementType type) {
        this.type = type;
    }

    public SettlementType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Тип поселения: " + getType() + '\n' + "Название: " + getName() + '\n' + "Широта и долгота: " + getLatitude() + ' ' + getLongitude() + '\n';
    }
}