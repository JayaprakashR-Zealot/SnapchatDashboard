package com.truedreamz.demo.swipe.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import com.squareup.otto.Subscribe;
import com.truedreamz.demo.swipe.R;
import com.truedreamz.demo.swipe.event.EventBus;
import com.truedreamz.demo.swipe.event.PageChangedEvent;
import com.truedreamz.demo.swipe.view.VerticalPager;

/**
 * Manages start screen of the application.
 */
public class MainActivity extends FragmentActivity {

	// -----------------------------------------------------------------------
	//
	// Statics
	//
	// -----------------------------------------------------------------------
	/**
	 * Start page index. 0 - top page, 1 - central page, 2 - bottom page.
	 */
	private static final int CENTRAL_PAGE_INDEX = 1;

	// -----------------------------------------------------------------------
	//
	// Fields
	//
	// -----------------------------------------------------------------------
	public VerticalPager mVerticalPager;

	// -----------------------------------------------------------------------
	//
	// Methods
	//
	// -----------------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViews();
	}

	private void findViews() {
		mVerticalPager = (VerticalPager) findViewById(R.id.activity_main_vertical_pager);
		initViews();
	}

	private void initViews() {
		snapPageWhenLayoutIsReady(mVerticalPager, CENTRAL_PAGE_INDEX);
	}

	private void snapPageWhenLayoutIsReady(final View pageView, final int page) {
		/*
		 * VerticalPager is not fully initialized at the moment, so we want to snap to the central page only when it
		 * layout and measure all its pages.
		 */
		pageView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onGlobalLayout() {
				mVerticalPager.snapToPage(page, VerticalPager.PAGE_SNAP_DURATION_INSTANT);

				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
					// recommended removeOnGlobalLayoutListener method is available since API 16 only
					pageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				else
					removeGlobalOnLayoutListenerForJellyBean(pageView);
			}

			@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
			private void removeGlobalOnLayoutListenerForJellyBean(final View pageView) {
				pageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		EventBus.getInstance().register(this);
	}

	@Override
	protected void onPause() {
		EventBus.getInstance().unregister(this);
		super.onPause();
	}

	@Subscribe
	public void onLocationChanged(PageChangedEvent event) {
		mVerticalPager.setPagingEnabled(event.hasVerticalNeighbors());
	}

}
