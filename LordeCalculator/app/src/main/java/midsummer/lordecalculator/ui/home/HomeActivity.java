package midsummer.lordecalculator.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midsummer.lordecalculator.R;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.btn_calculate_result)
    Button btnCalculateResult;
    @BindView(R.id.btn_history)
    Button btnHistory;
    @BindView(R.id.btn_manage_merchant)
    Button btnManageMerchant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }




    @OnClick({R.id.btn_calculate_result, R.id.btn_history, R.id.btn_manage_merchant})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_calculate_result:
                onBtnCalculateResultClicked();
                break;
            case R.id.btn_history:
                onBtnHistoryClicked();
                break;
            case R.id.btn_manage_merchant:
                onBtnManageMerchantClick();
                break;
        }
    }


    private void onBtnCalculateResultClicked(){

    }

    private void onBtnHistoryClicked(){

    }

    private void onBtnManageMerchantClick(){

    }
}
