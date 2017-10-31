package midsummer.lordecalculator.ui.addLordeData;

import android.content.Intent;

import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleRecyclerView;

import org.joda.time.DateTime;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import midsummer.lordecalculator.helper.DateTimeFormatHelper;
import midsummer.lordecalculator.helper.LogUtil;
import midsummer.lordecalculator.helper.RandomString;
import midsummer.lordecalculator.model.LordeData.LordeData;
import midsummer.lordecalculator.model.LordeData.LordeDataSource;
import midsummer.lordecalculator.model.LordeData.LordeRepository;
import midsummer.lordecalculator.model.LordeStatistic.LordeStatistic;
import midsummer.lordecalculator.model.LordeStatistic.LordeStatisticDataSource;
import midsummer.lordecalculator.model.LordeStatistic.LordeStatisticRepository;
import midsummer.lordecalculator.model.Merchant.Merchant;
import midsummer.lordecalculator.model.Merchant.MerchantDataSource;
import midsummer.lordecalculator.model.Merchant.MerchantRepository;

/**
 * Created by NIENLM on 10/30/17.
 */

public class AddLordeDataPresenter implements AddLordeDataContract.Presenter {

    private Realm realm;
    private AddLordeDataContract.View mView;
    private LordeDataSource mLorde;
    private MerchantDataSource mMerchant;
    private LordeStatisticDataSource mLordeStatistic;
    private String merchantId;

    public AddLordeDataPresenter(Realm realm, AddLordeDataContract.View mView) {
        this.realm = realm;
        this.mView = mView;
        this.mLorde = new LordeRepository(realm);
        this.mMerchant = new MerchantRepository(realm);
        this.mLordeStatistic = new LordeStatisticRepository(realm);
    }


    @Override
    public void addNew(int type, List<Integer> numbers, int value) {
        try {
            int trueType = -1;
            switch (type){
                case AddLordeDataContract.TYPE_DE:
                case AddLordeDataContract.TYPE_DAU:
                case AddLordeDataContract.TYPE_DIT:
                case AddLordeDataContract.TYPE_DAU_DIT:
                case AddLordeDataContract.TYPE_BO:
                    trueType = LordeDataSource.TYPE_DE;
                    break;
                case AddLordeDataContract.TYPE_LO:
                    trueType = LordeDataSource.TYPE_LO;
                    break;
                case AddLordeDataContract.TYPE_XIEN:
                case AddLordeDataContract.TYPE_QUAY:
                    trueType = LordeDataSource.TYPE_XIEN;
                    break;
            }
            if (trueType == -1) return;
            LordeData lordeData =new LordeData();
            String id = new RandomString(6, true).nextString();
            long now = DateTime.now().getMillis();
            lordeData.setId(now + Long.parseLong(id));

            RealmList<Integer> integers = new RealmList<>();
            integers.addAll(numbers);
            lordeData.setNumbers(integers);
            lordeData.setValue(value);
            lordeData.setType(trueType);
            mView.addToList(lordeData);
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public void start(Intent intent) {
        try {
            merchantId = intent.getStringExtra("merchantId");
            Merchant merchant = mMerchant.getMerchantById(merchantId);
            mView.initData(merchant);
        }catch (Exception e){
            LogUtil.e(e);
            mView.initData(null);
        }

    }

    @Override
    public void stop() {
        this.realm.close();
    }

    @Override
    public void submit(SimpleRecyclerView recyclerView) {
        if (recyclerView == null || recyclerView.getItemCount() == 0) return;
        RealmList<LordeData> lordeDataRealmList = new RealmList<>();
        for (SimpleCell cell : recyclerView.getAllCells())
            if (cell.getItem() instanceof LordeData){
                LordeData lordeData = (LordeData)cell.getItem();
                lordeDataRealmList.add(lordeData);
            }
        mLordeStatistic.addNew(merchantId, DateTimeFormatHelper.DateTimeNowToLong(), lordeDataRealmList);
    }
}
