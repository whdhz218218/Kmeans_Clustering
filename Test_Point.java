package assignment1;

import junit.framework.TestCase;
import assignment1.Point;

public class Test_Point extends TestCase {
	
	public void testNullValue() {
		//test_g4G3Gd
		double[] coordinates = null;
		Exception expectedError = null;
		try {
			new Point( coordinates );
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
	
	public void testLessThan1Value() {
		//test_p3FMGd
		double[] coordinates = { };
		Exception expectedError = null;
		try {
			new Point( coordinates );
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
	
	public void test1Value() {
		//test_ad3jDE
		double[] coordinates = { 1.5};
		Exception expectedError = null;
		try {
			new Point( coordinates );
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError == null );
	}
	
	public void testdiffdis() throws Exception {
		//test_ef4ggt
		double[] a = { 1.5, 3};
		double[] b = { 9};
		Point pt1 = new Point(a);
		Point pt2 = new Point(b);
		Exception expectedError = null;
		try {
			pt1.distancesq(pt1, pt2);
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}

	public void testsamedis() throws Exception {
		//test_34jfGR
		double[] a = { 2,5,7};
		double[] b = { 3,6,4};
		Point pt1 = new Point(a);
		Point pt2 = new Point(b);
		double distancesq=pt1.distancesq(pt1, pt2);
		junit.framework.TestCase.assertTrue( distancesq == 11);
	}

}
