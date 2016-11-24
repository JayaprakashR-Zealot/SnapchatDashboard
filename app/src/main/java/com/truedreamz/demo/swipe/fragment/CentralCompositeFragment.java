package com.truedreamz.demo.swipe.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.truedreamz.demo.swipe.R;
import com.truedreamz.demo.swipe.adapter.FragmentsClassesPagerAdapter;
import com.truedreamz.demo.swipe.event.EventBus;
import com.truedreamz.demo.swipe.event.PageChangedEvent;

/**
 * Fragment to manage the horizontal pages (left, central, right) of the 5 pages application navigation (top, center,
 * bottom, left, right).
 */
public class CentralCompositeFragment extends Fragment {

	// -----------------------------------------------------------------------
	//
	// Fields
	//
	// -----------------------------------------------------------------------
	public ViewPager mHorizontalPager;
	private int mCentralPageIndex = 0;
	private OnPageChangeListener mPagerChangeListener = new OnPageChangeListener() {
		@Override
		public void onPageSelected(int position) {
			EventBus.getInstance().post(new PageChangedEvent(mCentralPageIndex == position));
		}

		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

		}

		@Override
		public void onPageScrollStateChanged(int state) {
		}
	};

	// -----------------------------------------------------------------------
	//
	// Methods
	//
	// -----------------------------------------------------------------------
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.fragment_composite_central, container, false);
		findViews(fragmentView);
		return fragmentView;
	}

	private void findViews(View fragmentView) {
		mHorizontalPager = (ViewPager) fragmentView.findViewById(R.id.fragment_composite_central_pager);
		initViews();
	}

	private void initViews() {
		populateHozizontalPager();
		mHorizontalPager.setCurrentItem(mCentralPageIndex);
		mHorizontalPager.setOnPageChangeListener(mPagerChangeListener);
	}

	private void populateHozizontalPager() {
		ArrayList<Class<? extends Fragment>> pages = new ArrayList<Class<? extends Fragment>>();
		pages.add(LeftFragment.class);
		pages.add(CentralFragment.class);
		pages.add(RightFragment.class);
		mCentralPageIndex = pages.indexOf(CentralFragment.class);
		mHorizontalPager.setAdapter(new FragmentsClassesPagerAdapter(getChildFragmentManager(), getActivity(), pages));


	}
}
