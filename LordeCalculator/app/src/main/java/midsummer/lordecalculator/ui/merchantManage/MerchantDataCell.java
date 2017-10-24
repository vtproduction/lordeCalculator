package midsummer.lordecalculator.ui.merchantManage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import midsummer.lordecalculator.R;
import midsummer.lordecalculator.helper.LogUtil;
import midsummer.lordecalculator.model.Merchant.Merchant;

/**
 * Created by NIENLM on 10/24/17.
 */

public class MerchantDataCell extends SimpleCell<Merchant, MerchantDataCell.MerchantDataViewHolder>{
    private Context context;
    private MerchantDataCellClickListener callback;

    public MerchantDataCell(@NonNull Merchant item, Context context, MerchantDataCellClickListener callback) {
        super(item);
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_merchant_data;
    }

    @NonNull
    @Override
    protected MerchantDataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return new MerchantDataViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull MerchantDataViewHolder merchantDataViewHolder, int i, @NonNull Context context, Object o) {

    }

    public class MerchantDataViewHolder extends SimpleViewHolder {
        @BindView(R.id.txt_merchant_name)
        TextView txtMerchantName;
        @BindView(R.id.txt_label_owner)
        TextView txtLabelOwner;
        @BindView(R.id.txt_merchant_phone)
        TextView txtMerchantPhone;
        @BindView(R.id.txt_rate_de)
        TextView txtRateDe;
        @BindView(R.id.txt_rate_lo)
        TextView txtRateLo;
        @BindView(R.id.txt_rate_xien)
        TextView txtRateXien;
        @BindView(R.id.txt_remain_loan)
        TextView txtRemainLoan;
        private Merchant merchant;
        public MerchantDataViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setData(Merchant merchant){
            try {
                this.merchant = merchant;
                
            }catch (Exception e){
                LogUtil.e(e);
            }
        }
    }


    public interface MerchantDataCellClickListener{
        void onClick(Merchant merchant);
        void onEdit(Merchant merchant);
        void onDelete(Merchant merchant);
    }
}
