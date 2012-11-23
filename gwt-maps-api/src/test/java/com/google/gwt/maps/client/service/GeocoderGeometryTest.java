package com.google.gwt.maps.client.service;

/*
 * #%L
 * GWT Maps API V3 - Core API
 * %%
 * Copyright (C) 2011 - 2012 GWT Maps API V3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.maps.client.AbstractMapsGWTTest;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.base.LatLngBounds;
import com.google.gwt.maps.client.services.GeocoderGeometry;
import com.google.gwt.maps.client.services.GeocoderLocationType;

public class GeocoderGeometryTest extends AbstractMapsGWTTest {

	@Override
	public LoadLibrary[] getLibraries() {
		return new LoadLibrary[] { LoadLibrary.PLACES };
	}

	@SuppressWarnings("unused")
	public void testUse() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				GeocoderGeometry o = GeocoderGeometry.newInstance();
				finishTest();
			}
		});
	}

	public void testBounds() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				GeocoderGeometry o = GeocoderGeometry.newInstance();
				LatLng sw = LatLng.newInstance(-31.203405, 125.244141);
				LatLng ne = LatLng.newInstance(-25.363882, 131.044922);
				LatLngBounds left = LatLngBounds.newInstance(sw, ne);
				assertEquals(
						"((-31.203405, 125.24414100000001), (-25.363882, 131.04492200000004))",
						left.getToString());
				o.setBounds(left);
				LatLngBounds right = o.getBounds();
				assertEquals(left.getToString(), right.getToString());
				finishTest();
			}
		});
	}

	public void testLocation() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				GeocoderGeometry o = GeocoderGeometry.newInstance();
				LatLng left = LatLng.newInstance(25, 26);
				o.setLocation(left);
				LatLng right = o.getLocation();
				assertEquals(left.getToString(), right.getToString());
				finishTest();
			}
		});
	}

	public void testLocationType() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				GeocoderGeometry o = GeocoderGeometry.newInstance();
				GeocoderLocationType left = GeocoderLocationType.APPROXIMATE;
				o.setLocation_Type(left);
				GeocoderLocationType right = o.getLocation_Type();
				assertEquals(left, right);
				finishTest();
			}
		});
	}

	public void testViewPort() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				GeocoderGeometry o = GeocoderGeometry.newInstance();
				LatLng sw = LatLng.newInstance(-31.203405, 125.244141);
				LatLng ne = LatLng.newInstance(-25.363882, 131.044922);
				LatLngBounds left = LatLngBounds.newInstance(sw, ne);
				assertEquals(
						"((-31.203405, 125.24414100000001), (-25.363882, 131.04492200000004))",
						left.getToString());
				o.setViewPort(left);
				LatLngBounds right = o.getViewPort();
				assertEquals(left.getToString(), right.getToString());
				finishTest();
			}
		});
	}
}