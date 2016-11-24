package com.truedreamz.demo.swipe.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Adapter for {@link ViewPager} that will populated from the collection of Fragments classes. Objects of that classes
 * will be instantiated on demand and used as a pages views.
 */
public class FragmentsClassesPagerAdapter extends FragmentPagerAdapter {

	// -----------------------------------------------------------------------
	//
	// Constructors
	//
	// -----------------------------------------------------------------------
	public FragmentsClassesPagerAdapter(FragmentManager fragmentManager, Context context,
			List<Class<? extends Fragment>> pages) {
		super(fragmentManager);
		mPagesClasses = pages;
		mContext = context;
	}

	// -----------------------------------------------------------------------
	//
	// Fields
	//
	// -----------------------------------------------------------------------
	private List<Class<? extends Fragment>> mPagesClasses;
	private Context mContext;

	// -----------------------------------------------------------------------
	//
	// Methods
	//
	// -----------------------------------------------------------------------
	@Override
	public Fragment getItem(int posiiton) {
		return Fragment.instantiate(mContext, mPagesClasses.get(posiiton).getName());
	}

	@Override
	public int getCount() {
		return mPagesClasses.size();
	}
}
