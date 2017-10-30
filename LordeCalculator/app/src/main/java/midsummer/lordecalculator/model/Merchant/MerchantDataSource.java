package midsummer.lordecalculator.model.Merchant;

import java.util.List;

/**
 * Created by NienLe on 11-Oct-17.
 */

public interface MerchantDataSource {
    Merchant getMerchantById(String merchantId);
    void addNewMerchant(Merchant merchant);
    void updateMerchant(String merchantId, String merchantName, String merchantPhone, boolean isOwner, float rateLO, float rateDE, float rateXIEN, long remainLoan);
    void deleteMerchant(String merchantId);
    List<Merchant> getAllMerchants();
}
