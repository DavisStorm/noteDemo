package com.davis.mall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.davis.mall.R;
import com.davis.mall.bean.GouWuCheBean;
import com.davis.mall.bean.GouwWuCheOuterBean;
import com.davis.mall.views.AmountView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author 王阳
 * @time 2020/1/6  10:30
 * @desc
 */
public class GouWuCheAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int OutterType = 1;
    private int InnerType = 2;
    private ArrayList<Object> mData;
    private Context mContext;
    private HashMap<Integer, Boolean> ifSelectList = new HashMap<Integer, Boolean>();
    private HashMap<Integer, Integer> amountList = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> dianpuList = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> dianPuHejiPrices = new HashMap<>();
    private HashMap<Integer, Integer> dianPuYouhuiPrices = new HashMap<>();
    private HashMap<Integer, Integer> dianPuSelecteNum = new HashMap<>();//key位置,value已选数量
    private OnSumChangeLisener mLisener;

    public GouWuCheAdapter(Context context, ArrayList<Object> data, OnSumChangeLisener lisener) {
        mData = data;
        mContext = context;
        mLisener = lisener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        RecyclerView.ViewHolder holder;
        if (viewType == OutterType) {
            View view = inflater.inflate(R.layout.adapter_gouwuche_outter, null);
            holder = new OutterViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.adapter_gouwuche_inner, null);
            holder = new InnerViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        Object data = mData.get(position);
        if (viewHolder instanceof OutterViewHolder) {
            OutterViewHolder holderOutter = (OutterViewHolder) viewHolder;
            GouwWuCheOuterBean bean = (GouwWuCheOuterBean) data;
            holderOutter.tv_youhui_name.setText(bean.getYouhui_name());
            if (bean.getYouhui_type() == 1) {
                holderOutter.tv_sing.setText("多买多优惠");
                holderOutter.tv_yiman.setText("2件8折，3件7折");
            } else {
                holderOutter.tv_sing.setText("满减");
                holderOutter.tv_yiman.setText("满300减50");
            }
            holderOutter.position = position;
            dianpuList.put(position, bean.getDianpu_pod_num());
        } else {
            InnerViewHolder holderInner = (InnerViewHolder) viewHolder;
            final GouWuCheBean.DataBean.ListBean bean = (GouWuCheBean.DataBean.ListBean) data;
            RequestOptions options =new RequestOptions()
                    .placeholder(R.drawable.loading)//加载成功之前占位图
                    .error(R.drawable.loading)//加载错误之后的错误图
                    .override(300,300)//指定图片的尺寸
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE);//只缓存最终的图片 ;
            Glide.with(mContext).load(bean.getImages()).apply(options).into(holderInner.img_pic);
            holderInner.tv_chicuncolor.setText(bean.getPod_chima() + "，" + bean.getPod_color());
            holderInner.tv_price_main.setText(bean.getPrice() + "");
            holderInner.position = position;
            holderInner.amount_view.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
                @Override
                public void onAmountChange(View view, int amount) {
                    amountList.put(position, amount);
                    countYouhui(position, bean.isIfSelected(), amount);
                }
            });
            holderInner.amount_view.setGoods_storage(100000);
            holderInner.amount_view.setText(amountList.get(position));
            holderInner.amount_view.clearFocus();

            holderInner.rb_ifchoose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ifSelectList.put(position, isChecked);
                    countYouhui(position, isChecked, bean.getPod_num());

                }
            });
        }
    }

    private void countYouhui(int position, boolean ifselected, int amount) {
        Set<Integer> dianpuListSet = dianpuList.keySet();
        Integer parenDianpu = 0;//定位店铺的位置
        for (Integer integer : dianpuListSet) {
            int qujian = integer + dianpuList.get(integer);
            if (integer < position && qujian >= position) {
                parenDianpu = integer;
            }
        }
        //先做内部数据更改
        GouWuCheBean.DataBean.ListBean bean = (GouWuCheBean.DataBean.ListBean) mData.get(position);
        bean.setPod_num(amount);
        bean.setIfSelected(ifselected);
        mLisener.onSumChange(parenDianpu, mData);//只做外部数据显示
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        if (holder instanceof InnerViewHolder) {
            InnerViewHolder innerHolder = (InnerViewHolder) holder;
            Object item = mData.get(innerHolder.position);
            if (item instanceof GouWuCheBean.DataBean.ListBean) {
                GouWuCheBean.DataBean.ListBean bean = (GouWuCheBean.DataBean.ListBean) item;
                innerHolder.rb_ifchoose.setChecked(bean.isIfSelected());
                innerHolder.amount_view.setText(bean.getPod_num());
            }
        } else if (holder instanceof OutterViewHolder) {
            OutterViewHolder outterHolder = (OutterViewHolder) holder;
            Object item = mData.get(outterHolder.position);
            if (item instanceof GouwWuCheOuterBean) {
                GouwWuCheOuterBean bean = (GouwWuCheOuterBean) item;
                if (bean.getYouhui_type() == 1) {
                    int selectedNum = bean.getSelected_num();
                    if (selectedNum == 2) {
                        outterHolder.tv_yiman.setText("已满2件，已减" + bean.getYouhui_sum() + "元");
                    } else if (selectedNum >= 3) {
                        outterHolder.tv_yiman.setText("已满3件，已减" + bean.getYouhui_sum() + "元");
                    } else {
                        outterHolder.tv_yiman.setText("2件8折，3件7折");
                    }
                } else if (bean.getYouhui_type() == 2) {
                    int cutSum = bean.getYouhui_sum();
                    if (cutSum >= 50) {
                        outterHolder.tv_yiman.setText("已满300，已减"+cutSum);
                    } else {
                        outterHolder.tv_yiman.setText("满300减50");
                    }
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof GouwWuCheOuterBean) {
            return OutterType;
        } else {
            return InnerType;
        }
    }

    public void setData(ArrayList<Object> transformBean) {
        if (mData != null && mData.size() > 0) {
            mData.clear();
        }
        mData = transformBean;
        if (mData != null && mData.size() > 0) {
            for (int i = 0; i < mData.size(); i++) {
                Object item = mData.get(i);
                if (item instanceof GouWuCheBean.DataBean.ListBean) {
                    GouWuCheBean.DataBean.ListBean bean = (GouWuCheBean.DataBean.ListBean) item;
                    amountList.put(i, bean.getPod_num());
                    ifSelectList.put(i, false);
                } else {
                    dianPuSelecteNum.put(i, 0);
                    dianPuHejiPrices.put(i, 0);
                }
            }
        }

        notifyDataSetChanged();
    }

    public ArrayList<Object> getData() {
        return mData;
    }


    class OutterViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_youhui_name;
        private TextView tv_sing;
        private TextView tv_yiman;
        private int position;

        public OutterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_youhui_name = itemView.findViewById(R.id.tv_youhui_name);
            tv_sing = itemView.findViewById(R.id.tv_sing);
            tv_yiman = itemView.findViewById(R.id.tv_yiman);
        }
    }

    class InnerViewHolder extends RecyclerView.ViewHolder {
        private CheckBox rb_ifchoose;
        private ImageView img_pic;
        private TextView tv_pod_name;
        private TextView tv_chicuncolor;
        private TextView tv_price_main;
        private AmountView amount_view;
        private int position;

        public InnerViewHolder(@NonNull View itemView) {
            super(itemView);
            rb_ifchoose = itemView.findViewById(R.id.rb_ifchoose);
            img_pic = itemView.findViewById(R.id.img_pic);
            tv_pod_name = itemView.findViewById(R.id.tv_pod_name);
            tv_chicuncolor = itemView.findViewById(R.id.tv_chicuncolor);
            tv_price_main = itemView.findViewById(R.id.tv_price_main);
            amount_view = itemView.findViewById(R.id.amount_view);
        }
    }

    public void startDelete() {
        ArrayList<Integer> waitToRemove = new ArrayList<>();
        ArrayList<Object> arrayListCopy = new ArrayList<>(mData);
        Set<Map.Entry<Integer, Boolean>> entries = ifSelectList.entrySet();
        for (Map.Entry<Integer, Boolean> ele : entries) {
            if (ele.getValue()) {
                Integer position = ele.getKey();
                waitToRemove.add(position);
                GouWuCheBean.DataBean.ListBean bean =
                        (GouWuCheBean.DataBean.ListBean) arrayListCopy.get(position);
                int changedPosition = mData.indexOf(bean);
                //判断是否这个店铺已经没有了商品
                if (mData.get(changedPosition - 1) instanceof GouwWuCheOuterBean) {
                    if (changedPosition == mData.size() - 1) {//表示删除的是最后一个
                        Object bean2 = mData.get(changedPosition - 1);
                        int index = arrayListCopy.indexOf(bean2);
                        mData.remove(changedPosition - 1);
                        waitToRemove.add(index);
                    } else if (mData.get(changedPosition + 1) instanceof GouwWuCheOuterBean) {
                        Object bean2 = mData.get(changedPosition - 1);
                        int index = arrayListCopy.indexOf(bean2);
                        mData.remove(changedPosition - 1);
                        waitToRemove.add(index);
                    }
                }
                mData.remove(bean);
            }
        }
        //同步ifSelectList，amountList
        HashMap<Integer, Boolean> ifSelectListHashMap = new HashMap<>();
        HashMap<Integer, Integer> amountListHashMap = new HashMap<>();
        //先删除多余的数据
        for (int i = 0; i < waitToRemove.size(); i++) {
            Integer position = waitToRemove.get(i);
            if (arrayListCopy.get(position) instanceof GouwWuCheOuterBean) {
                continue;
            }
            amountList.remove(position);
            ifSelectList.remove(position);
        }
        //再同步key
        Set<Integer> amountListKeys = amountList.keySet();
        for (Integer ele : amountListKeys) {
            Integer value = amountList.get(ele);
            Integer key = ele;
            for (int i = 0; i < waitToRemove.size(); i++) {
                if (ele > waitToRemove.get(i)) {
                    key = key - 1;
                }
            }
            amountListHashMap.put(key, value);
        }

        Set<Integer> ifSelectListKeys = ifSelectList.keySet();
        for (Integer ele : ifSelectListKeys) {
            Boolean value = ifSelectList.get(ele);
            Integer key = ele;
            for (int i = 0; i < waitToRemove.size(); i++) {
                if (ele > waitToRemove.get(i)) {
                    key = key - 1;
                }
            }
            ifSelectListHashMap.put(key, value);
        }
        ifSelectList = ifSelectListHashMap;

        amountList = amountListHashMap;
        dianpuList.clear();
        notifyDataSetChanged();
        mLisener.onDelete();

    }

    public interface OnSumChangeLisener {

        void onSumChange(int position, ArrayList<Object> data);

        void onDelete();

//        void onNotSelecteAll(boolean ifSelecteAll);
    }

}
