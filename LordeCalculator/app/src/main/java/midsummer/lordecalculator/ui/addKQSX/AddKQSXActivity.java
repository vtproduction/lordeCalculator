package midsummer.lordecalculator.ui.addKQSX;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import midsummer.lordecalculator.R;
import midsummer.lordecalculator.helper.DateTimeFormatHelper;
import midsummer.lordecalculator.helper.LogUtil;
import midsummer.lordecalculator.helper.ToastUtil;
import midsummer.lordecalculator.model.KQSX.KQSX;

/**
 * Created by NIENLM on 10/26/17.
 */

public class AddKQSXActivity extends AppCompatActivity implements AddKQSXContract.View {


    @BindView(R.id.btn_back)
    LinearLayout btnBack;
    @BindView(R.id.btn_add_new)
    TextView btnAddNew;
    @BindView(R.id.txt_label_date)
    TextView txtLabelDate;
    @BindViews({R.id.edt_1,R.id.edt_2,R.id.edt_3,
            R.id.edt_4,R.id.edt_5,R.id.edt_6,
            R.id.edt_7,R.id.edt_8,R.id.edt_9,
            R.id.edt_10,R.id.edt_11,R.id.edt_12,
            R.id.edt_13,R.id.edt_14,R.id.edt_15,
            R.id.edt_16,R.id.edt_17,R.id.edt_18,
            R.id.edt_19,R.id.edt_20,R.id.edt_21,
            R.id.edt_22,R.id.edt_23,R.id.edt_24,
            R.id.edt_25,R.id.edt_26,R.id.edt_27})
    EditText[] editTexts;

    private AddKQSXContract.Presenter mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kqsx);
        ButterKnife.bind(this);
        mPresenter = new AddKQSXPresenter(this, Realm.getDefaultInstance());
        mPresenter.load();
    }



    @Override
    public void load(KQSX kqsx) {
        try {
            txtLabelDate.setText(DateTimeFormatHelper.FormatDateTime(DateTime.now()));
            if (kqsx != null){
                for (int i = 0; i < kqsx.getResults().size(); i++)
                    editTexts[i].setText("" + kqsx.getResults().get(i));
            }
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public void displayMessage(String message) {
        ToastUtil.show(message);
    }

    @OnClick({R.id.btn_back, R.id.btn_add_new})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_add_new:
                updateKQSX();
                break;
        }
    }

    private void updateKQSX(){
        List<Integer> integerList = new ArrayList<>();
        for (EditText editText : editTexts){
            int value = Integer.parseInt(editText.getText().toString());
            integerList.add(value);
        }
        mPresenter.addToDB(integerList);
    }
}
