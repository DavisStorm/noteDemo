package com.davis.mall.adapter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.davis.mall.R;
import com.davis.mall.bean.CategoryBannerBean;
import com.davis.mall.bean.CategoryBean;
import com.davis.mall.utils.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/13  17:02
 * @desc
 */
public class RvDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private List<CategoryBean.DataBean.TreeBean> mData;
    private CategoryBannerBean.DataBean mBannerData;
    final Handler handler = new Handler();
    private Runnable mRunnableaaa;
    private RvDetailOnItemClickLisener mlisener;


    public RvDetailAdapter(Context context, List<CategoryBean.DataBean.TreeBean> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        if (viewType == TypeEnum.HEADER_TYPE.ordinal()) {
            View view = inflater.inflate(R.layout.rv_detail_header, null);
            holder = new HeaderHolder(view);
        } else {
            View view = inflater.inflate(R.layout.category_detail_adapter, null);
            holder = new ContentHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof HeaderHolder) {
            if (mBannerData != null) {
                final List<CategoryBannerBean.DataBean.ListBean> mBannerList = mBannerData.getList()==null?
                        new ArrayList<>():mBannerData.getList();
                final HeaderHolder headholder = (HeaderHolder) holder;
                PagerAdapter pagerAdapter = createPagerAdapter(mBannerList);
                headholder.mVp.setAdapter(pagerAdapter);
                pagerAdapter.notifyDataSetChanged();
                //轮播
                if (mRunnableaaa == null) {
                    final int[] num = {0};
                    mRunnableaaa = new Runnable() {
                        public void run() {
                            if (mBannerList==null || mBannerList.size() ==0) return;
                            num[0]++;
                            headholder.mVp.setVisibility(View.VISIBLE);
                            // 设置初始 position
                            headholder.mVp.setCurrentItem(num[0] % mBannerList.size(), true);
                            Log.e("Runnableaaa", "run: " + (num[0] % mBannerList.size()));
                            handler.postDelayed(this, 2 * 1000);//设置循环时间，此处是2秒
                            //需要执行的代码
                        }
                    };
                    handler.post(mRunnableaaa);
                }

            }
        } else if (holder instanceof ContentHolder) {
            ContentHolder contentHolder = (ContentHolder) holder;
            contentHolder.mTv_name.setText(mData.get(position - 1).getSecond_class_name());
            BaseQuickAdapter quickAdapter = createQuickAdapter(position - 1);

//          WrapContentLayoutManager manager2 = new WrapContentLayoutManager(quickAdapter,contentHolder.view.getContext(),3);
            GridLayoutManager manager2 = new GridLayoutManager(contentHolder.view.getContext(), 3);
            manager2.setOrientation(GridLayoutManager.VERTICAL);
            contentHolder.rv_inner.setLayoutManager(manager2);
            contentHolder.rv_inner.setAdapter(quickAdapter);
        }
    }

    private BaseQuickAdapter createQuickAdapter(int position) {
        CategoryBean.DataBean.TreeBean treeBean = mData.get(position);
        final List<CategoryBean.DataBean.TreeBean.ChildrenTreeBean> children_tree
                = treeBean.getChildren_tree();
        BaseQuickAdapter<CategoryBean.DataBean.TreeBean.ChildrenTreeBean> quickAdapter = new BaseQuickAdapter<CategoryBean.DataBean.TreeBean.ChildrenTreeBean>
                (R.layout.inneradapter_category, children_tree == null ? new ArrayList<>() : children_tree) {

            @Override
            protected void convert(final BaseViewHolder helper, final CategoryBean.DataBean.TreeBean.ChildrenTreeBean item) {
                helper.setText(R.id.tv_inner_name, item.getThird_class_name());
                ImageView inner_iv = helper.getView(R.id.inner_adapter_img);
                RequestOptions options = new RequestOptions()
                        .placeholder(R.drawable.loading)//加载成功之前占位图
                        .error(R.drawable.loading)//加载错误之后的错误图
                        .override(300, 300)//指定图片的尺寸
                        .fitCenter()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE);//只缓存最终的图片 ;
                Glide.with(mContext).load(item.getImg_url()).apply(options).into(inner_iv);
                RelativeLayout rl_Container = helper.getView(R.id.inner_rl_container);
                rl_Container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mlisener.onContentItemClick(item.getThird_class_id(), 3, item.getThird_class_name());//3表示三级分类

                    }
                });
            }
        };

        return quickAdapter;
    }

    private PagerAdapter createPagerAdapter(final List<CategoryBannerBean.DataBean.ListBean> bannerlist) {

        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return bannerlist == null ? 0 : bannerlist.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
                return view == obj;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                RelativeLayout rl_out = (RelativeLayout) LayoutInflater.from(mContext).inflate
                        (R.layout.banner_img_viewpager, container, false);
                ImageView imgView = (ImageView) rl_out.getChildAt(0);
                RequestOptions options = new RequestOptions()
                        .placeholder(R.drawable.loading)//加载成功之前占位图
                        .error(R.drawable.loading)//加载错误之后的错误图
                        .override(300, 300)//指定图片的尺寸
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.NONE);//跳过磁盘缓存
                Glide.with(container.getContext()).load(bannerlist.get(position).getAdimgurls())
                        .apply(options).into(imgView);
                container.addView(rl_out);
                return rl_out;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        };
        return pagerAdapter;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        handler.removeCallbacksAndMessages(null);
        mRunnableaaa = null;

    }

    @Override
    public int getItemCount() {
        return mData == null ? 1 : mData.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TypeEnum.HEADER_TYPE.ordinal();
        } else {
            return TypeEnum.CONTENT_TYPE.ordinal();
        }
    }

    public void setData(List<CategoryBean.DataBean.TreeBean> list) {
        mData = list;
        notifyDataSetChanged();
    }

    public void setHeadViewData(CategoryBannerBean.DataBean data) {
        mBannerData = data;
        notifyDataSetChanged();
    }

    private enum TypeEnum {
        HEADER_TYPE,//头布局类型
        CONTENT_TYPE//内容布局类型
    }

    private class HeaderHolder extends RecyclerView.ViewHolder {

        private ViewPager mVp;

        public HeaderHolder(View view) {
            super(view);
            mVp = view.findViewById(R.id.vp);
        }
    }

    private class ContentHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView mTv_name;
        private RecyclerView rv_inner;

        public ContentHolder(View view) {
            super(view);
            this.view = view;
            mTv_name = view.findViewById(R.id.tv_category_second);
            rv_inner = view.findViewById(R.id.rv_inner);
        }
    }

    public void setOnItemClick(RvDetailOnItemClickLisener mlisener) {
        this.mlisener = mlisener;
    }

    public interface RvDetailOnItemClickLisener {
        void onContentItemClick(String cate_id, int cate_class, String name);

        void onHeadClick(String position);
    }
}
