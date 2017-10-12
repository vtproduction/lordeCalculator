package midsummer.lordecalculator.model.Merchant;

import java.util.List;

/**
 * Created by NienLe on 11-Oct-17.
 */

public interface MerchantDataSource {
    Merchant getMerchantById(int merchantId);
    void addNewMerchant(Merchant merchant);
    void updateMerchant(Merchant merchant);
    void deleteMerchant(int merchantId);
    List<Merchant> getAllMerchants();
}
