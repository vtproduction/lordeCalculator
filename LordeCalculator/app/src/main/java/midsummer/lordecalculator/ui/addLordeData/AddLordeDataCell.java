package midsummer.lordecalculator.ui.addLordeData;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;
import com.jaychang.srv.Updatable;

import butterknife.BindView;
import midsummer.lordecalculator.R;
import midsummer.lordecalculator.helper.LogUtil;
import midsummer.lordecalculator.helper.StringUtil;
import midsummer.lordecalculator.model.LordeData.LordeData;

/**
 * Created by NIENLM on 10/30/17.
 */

public class AddLordeDataCell extends SimpleCell<LordeData, AddLordeDataCell.AddLordeViewHolder> implements Updatable<LordeData>{

    private LordeDataCellClickListener callback;

    public AddLordeDataCell(@NonNull LordeData item, LordeDataCellClickListener callback) {
        super(item);
        this.callback = callback;
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.item_lorde_data;
    }

    @NonNull
    @Override
    protected AddLordeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return new AddLordeViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull AddLordeViewHolder addLordeViewHolder, int i, @NonNull Context context, Object payload) {
        if (payload != null) {

            if (payload instanceof Bundle) {
                Bundle bundle = (Bundle) payload;
                String dataString = bundle.getString("data");
                LordeData updateData = new Gson().fromJson(dataString, LordeData.class);
                addLordeViewHolder.setData(updateData);
            } else if (payload instanceof LordeData) {
                LordeData data = (LordeData) payload;
                //LogUtil.d("onBindViewHolder: "  + feed.getCellState().toString());
                addLordeViewHolder.setData(data);
            }
            return;
        }
        addLordeViewHolder.setData(getItem());
    }

    @Override
    public boolean areContentsTheSame(@NonNull LordeData data) {
        return data.getId() == getItem().getId();
    }

    @Override
    public Object getChangePayload(@NonNull LordeData data) {
        Bundle bundle = new Bundle();
        String userString = new Gson().toJson(data);
        bundle.putString("data", userString);
        return bundle;
    }

    @Override
    protected long getItemId() {
        return getItem().getId();
    }

    public class AddLordeViewHolder extends SimpleViewHolder {
        @BindView(R.id.txt_lorde_type)
        TextView txtLordeType;
        @BindView(R.id.txt_lorde_content)
        TextView txtLordeContent;
        @BindView(R.id.txt_lorde_value)
        TextView txtLordeValue;

        public AddLordeViewHolder(@NonNull View itemView) {
            super(itemView);

        }


        public void setData(final LordeData lordeData){
            try {
                String tmp = "";
                for (int number : lordeData.getNumbers())
                    tmp += number + " ";
                txtLordeContent.setText(tmp);
                txtLordeValue.setText("x" + lordeData.getValue());
                txtLordeType.setText(StringUtil.getLordeDataType(lordeData.getType()));
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        callback.onCellClick(lordeData);
                    }
                });
            }catch (Exception e){
                LogUtil.e(e);
            }
        }
    }


    public interface LordeDataCellClickListener {
        void onCellClick(LordeData lordeData);
    }
}
