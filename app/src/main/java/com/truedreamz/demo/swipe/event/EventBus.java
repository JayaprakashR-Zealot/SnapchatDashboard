package com.truedreamz.demo.swipe.event;

import com.squareup.otto.Bus;

/**
 * Provides a singleton instance for the application event bus. For the sake of simplicity it's done via the singleton,
 * however, some dependency injection directly into interested classes.
 */
public class EventBus {

	// -----------------------------------------------------------------------
	//
	// Statics
	//
	// -----------------------------------------------------------------------
	private static final Bus sBus = new Bus();

	public static Bus getInstance() {
		return sBus;
	}

	// -----------------------------------------------------------------------
	//
	// Constructors
	//
	// -----------------------------------------------------------------------
	private EventBus() {
		// do nothing here, EventBus is just a keeper for real a Bus instance
	}

}
