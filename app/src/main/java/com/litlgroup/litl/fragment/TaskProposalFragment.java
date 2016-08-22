package com.litlgroup.litl.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.litlgroup.litl.R;
import com.litlgroup.litl.utils.CircleIndicator;
import com.litlgroup.litl.utils.ImageUtils;
import com.litlgroup.litl.utils.MediaPagerAdapter;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskProposalFragment extends Fragment {

    @BindView(R.id.tvTitle)
    TextView mTvTitle;
    @BindView(R.id.tvPostedDate)
    TextView mTvPostedDate;
    @BindView(R.id.tvPrice)
    TextView mTvPrice;
    @BindView(R.id.tvDescription)
    TextView mTvDescription;
    @BindView(R.id.tvViewedBy)
    TextView mTvViewedBy;
    @BindView(R.id.tvViewedByCount)
    TextView mTvViewedByCount;
    @BindView(R.id.tvBidByCount)
    TextView mTvBidByCount;
    @BindView(R.id.tvBidBy)
    TextView mTvBidBy;
    @BindView(R.id.vpMedia)
    ViewPager mVpMedia;
    @BindView(R.id.ivProfileImage)
    ImageView mIvProfileImage;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.vpIndicator)
    LinearLayout mViewPagerCountDots;

    @BindColor(android.R.color.transparent)
    int mTransparent;
    @BindColor(R.color.colorAccent)
    int accentColor;
    @BindColor(R.color.colorPrimaryDark)
    int mPrimaryDark;
    @BindColor(R.color.colorPrimary)
    int mColorPrimary;

    private DatabaseReference mDatabase;

    public TaskProposalFragment() {
    }

    public static TaskProposalFragment newInstance() {
        TaskProposalFragment fragment = new TaskProposalFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_task_proposal, container, false);
        ButterKnife.bind(this, view);

        mCollapsingToolbar.setExpandedTitleColor(mTransparent);
        mCollapsingToolbar.setContentScrimColor(mColorPrimary);
        mCollapsingToolbar.setStatusBarScrimColor(mPrimaryDark);

        initToolbar();

        ImageUtils.setCircularImage(mIvProfileImage, "https://lh4.googleusercontent.com/-WdAdZiM6sKg/AAAAAAAAAAI/AAAAAAAAAAA/AGNl-OrDerqmVUzgAncF_UGH3YIIMV6Izw/s96-c/photo.jpg%22");

        setupViewPager();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.task_proposal_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void setupViewPager() {
        final MediaPagerAdapter adapter = new MediaPagerAdapter(getActivity());
        adapter.addImage("https://firebasestorage.googleapis.com/v0/b/litl-40ef9.appspot.com/o/Tasks%2FAssembly-the-Splitback-Sofa03.jpg?alt=media&token=23f9b9b2-11f8-4423-bc28-1bd75bcfc4ae");
        adapter.addImage("https://firebasestorage.googleapis.com/v0/b/litl-40ef9.appspot.com/o/Tasks%2Fsofa1.jpeg?alt=media&token=6a748cf5-c447-4916-afaf-91eeed86a8d6");
        adapter.addImage("https://firebasestorage.googleapis.com/v0/b/litl-40ef9.appspot.com/o/Tasks%2Fsofa1.jpeg?alt=media&token=6a748cf5-c447-4916-afaf-91eeed86a8d6");
        adapter.addImage("https://firebasestorage.googleapis.com/v0/b/litl-40ef9.appspot.com/o/Tasks%2Fsofa1.jpeg?alt=media&token=6a748cf5-c447-4916-afaf-91eeed86a8d6");

        mVpMedia.setAdapter(adapter);

        CircleIndicator circleIndicator = new CircleIndicator(mViewPagerCountDots, mVpMedia);
        circleIndicator.setViewPagerIndicator();
    }

    private void initToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}