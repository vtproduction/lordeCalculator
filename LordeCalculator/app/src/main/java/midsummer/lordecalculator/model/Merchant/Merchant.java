package midsummer.lordecalculator.model.Merchant;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by NienLe on 11-Oct-17.
 */

public class Merchant extends RealmObject {

    @PrimaryKey
    public int id;
    public String name;
    public String phone;
    public boolean isOwner;

    public float rateDE;
    public float rateLO;
    public float rateXIEN;
    public long remainLoan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public float getRateDE() {
        return rateDE;
    }

    public void setRateDE(float rateDE) {
        this.rateDE = rateDE;
    }

    public float getRateLO() {
        return rateLO;
    }

    public void setRateLO(float rateLO) {
        this.rateLO = rateLO;
    }

    public float getRateXIEN() {
        return rateXIEN;
    }

    public void setRateXIEN(float rateXIEN) {
        this.rateXIEN = rateXIEN;
    }

    public long getRemainLoan() {
        return remainLoan;
    }

    public void setRemainLoan(long remainLoan) {
        this.remainLoan = remainLoan;
    }
}
