package com.davis.mall.ui.note;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.davis.mall.R;
import com.davis.mall.bean.Petal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlowerLayoutActivity extends AppCompatActivity {
    @BindView(R.id.flowerlayout)
    FlowerLayout flowerlayout;
    @BindView(R.id.tv_instruction)
    TextView tvInstruction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowerlayout);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ArrayList<Petal> petals = new ArrayList<>();
        petals.add(new Petal(R.mipmap.icon_1, "icon_1"));
        petals.add(new Petal(R.mipmap.icon_2, "icon_2"));
        petals.add(new Petal(R.mipmap.icon_3, "icon_3"));
        petals.add(new Petal(R.mipmap.icon_4, "icon_4"));
        petals.add(new Petal(R.mipmap.icon_5, "icon_5"));
        petals.add(new Petal(R.mipmap.icon_6, "icon_6"));
        petals.add(new Petal(R.mipmap.icon_7, "icon_7"));
        petals.add(new Petal(R.mipmap.icon_8, "icon_8"));
        petals.add(new Petal(R.mipmap.icon_9, "icon_9"));
        petals.add(new Petal(R.mipmap.icon_10, "icon_10"));
        flowerlayout.setAdapter(new FlowerAdapter(petals));
    }


    public class FlowerAdapter extends BaseAdapter {
        private List<Petal> mPetals;

        public FlowerAdapter(List<Petal> petals) {
            mPetals = petals;
        }

        @Override
        public int getCount() {
            return mPetals.size();
        }

        @Override
        public Object getItem(int position) {
            return mPetals.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.flower_item, parent, false);
            ImageView iv = view.findViewById(R.id.id_pic);
            iv.setImageResource(mPetals.get(position).getResId());
            TextView tv = view.findViewById(R.id.id_info);
            tv.setText(mPetals.get(position).getInfo());
            return view;
        }
    }
}
