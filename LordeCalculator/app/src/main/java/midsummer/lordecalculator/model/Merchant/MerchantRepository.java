package midsummer.lordecalculator.model.Merchant;

import java.util.List;

import io.realm.Realm;

/**
 * Created by NienLe on 12-Oct-17.
 */

public class MerchantRepository implements MerchantDataSource {
    private Realm realm;

    public MerchantRepository(Realm realm) {
        this.realm = realm;
    }

    @Override
    public Merchant getMerchantById(int merchantId) {
        return realm.where(Merchant.class).equalTo("id", merchantId).findFirst();
    }

    @Override
    public void addNewMerchant(final Merchant merchant) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(merchant);
            }
        });
    }

    @Override
    public void updateMerchant(final Merchant merchant) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(merchant);
            }
        });
    }

    @Override
    public void deleteMerchant(int merchantId) {
        final Merchant merchant = getMerchantById(merchantId);
        if (merchant != null)
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    merchant.deleteFromRealm();
                }
            });
    }

    @Override
    public List<Merchant> getAllMerchants() {
        return realm.where(Merchant.class).findAll();
    }
}
