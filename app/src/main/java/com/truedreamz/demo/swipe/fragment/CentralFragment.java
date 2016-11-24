package com.truedreamz.demo.swipe.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.truedreamz.demo.swipe.R;
import com.truedreamz.demo.swipe.activity.MainActivity;

import static com.truedreamz.demo.swipe.R.id.btnARMessaging;
import static com.truedreamz.demo.swipe.R.id.btnAugs;
import static com.truedreamz.demo.swipe.R.id.btnDiscover;

/**
 * Fragment to manage the central page of the 5 pages application navigation (top, center, bottom, left, right).
 */
public class CentralFragment extends Fragment {

	Button btnProfile, btnARMessaging,btnAugs,btnDiscover;

	ViewPager pager;
	MainActivity mCenterActivity;

	// -----------------------------------------------------------------------
	//
	// Methods
	//
	// -----------------------------------------------------------------------
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.fragment_central, container, false);

		pager = (ViewPager) container;
		mCenterActivity=(MainActivity) getActivity();

		btnARMessaging=(Button)fragmentView.findViewById(R.id.btnARMessaging);
		btnARMessaging.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				pager.setCurrentItem(0);
			}
		});

		btnAugs=(Button)fragmentView.findViewById(R.id.btnAugs);
		btnAugs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				pager.setCurrentItem(2);
			}
		});

		/*imgAppIcon=(ImageView)fragmentView.findViewById(R.id.);
		imgAppIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mCenterActivity.mVerticalPager.snapToPage(0);
			}
		});*/

		btnProfile=(Button)fragmentView.findViewById(R.id.btnProfile);
		btnProfile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mCenterActivity.mVerticalPager.snapToPage(0);
			}
		});

		btnDiscover=(Button)fragmentView.findViewById(R.id.btnDiscover);
		btnDiscover.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mCenterActivity.mVerticalPager.snapToPage(2);
			}
		});

		return fragmentView;
	}

}
