package midsummer.lordecalculator.ui.CheckPincode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import midsummer.lordecalculator.R;
import midsummer.lordecalculator.helper.KeyboardUtil;
import midsummer.lordecalculator.ui.home.HomeActivity;

/**
 * Created by NienLe on 11-Oct-17.
 */

public class CheckPincodeActivity extends AppCompatActivity implements CheckPincodeContract.View {
    @BindView(R.id.edittext_pincode)
    EditText edittextPincode;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    private CheckPincodeContract.presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pincode_check);
        ButterKnife.bind(this);
        setup();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter == null) presenter = new CheckPincodePresenter(this);
        presenter.checkAtStartup();
    }

    @Override
    public void setup() {
        edittextPincode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.checkPinCode(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void navigateToMain() {

        KeyboardUtil.hideSoftKeyboard(this);
        startActivity(new Intent(this, HomeActivity.class));
    }
}
