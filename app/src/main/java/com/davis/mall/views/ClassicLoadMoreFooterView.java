package com.davis.mall.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreFooterLayout;
import com.davis.mall.R;

/**
 * @author 王阳
 * @time 2019/12/31  16:02
 * @desc
 */
public class ClassicLoadMoreFooterView extends SwipeLoadMoreFooterLayout {
    private TextView tvLoadMore;
    private ImageView ivSuccess;
    private ProgressBar progressBar;

    private int mFooterHeight;
    private String completeWords = "加载成功";
    private boolean ifNoMoreWords = false;

    public ClassicLoadMoreFooterView(Context context) {
        this(context, null);
    }

    public ClassicLoadMoreFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClassicLoadMoreFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mFooterHeight = getResources().getDimensionPixelOffset(R.dimen.load_more_footer_height_classic);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvLoadMore = (TextView) findViewById(R.id.tvLoadMore);
        ivSuccess = (ImageView) findViewById(R.id.ivSuccess_loadmore);
        progressBar = (ProgressBar) findViewById(R.id.progressbar_loadmore);
    }

    @Override
    public void onPrepare() {
        ivSuccess.setVisibility(GONE);
    }

    @Override
    public void onSwipe(int y, boolean isComplete) {
        if (!isComplete) {
            ivSuccess.setVisibility(GONE);
            progressBar.setVisibility(GONE);
            if (-y >= mFooterHeight) {
                tvLoadMore.setText("加载更多");
            } else {
                tvLoadMore.setText("上拉加载");
            }
        }
    }

    @Override
    public void onLoadMore() {
        tvLoadMore.setText("正在加载...");
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void onRelease() {

    }

    @Override
    public void complete() {
        progressBar.setVisibility(GONE);
        ivSuccess.setVisibility(VISIBLE);
        if(!whenNoMoreData(ifNoMoreWords)) {
            tvLoadMore.setText(completeWords);
        }else {
            tvLoadMore.setText("没有更多数据");
        }
        ifNoMoreWords = false;
    }

    public boolean whenNoMoreData(boolean ifNoMoreWords) {
        this.ifNoMoreWords = ifNoMoreWords;
        return ifNoMoreWords;
    }

    @Override
    public void onReset() {
        ivSuccess.setVisibility(GONE);
    }
}
