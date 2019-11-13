package assignment1;

import junit.framework.TestCase;
import assignment1.Centroid;
import java.util.*;


public class Test_Centroid extends TestCase {
	public void testNullValue() {
		//test_RG5sg3
		double[] coordinates = null;
		Exception expectedError = null;
		try {
			new Centroid( coordinates );
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
	
	public void testLessThan1Value() {
		//test_4veFE8
		double[] coordinates = { };
		Exception expectedError = null;
		try {
			new Centroid( coordinates );
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
	
	public void test1Value() {
		//test_cjsD35
		double[] coordinates = { 1.5};
		Exception expectedError = null;
		try {
			new Centroid( coordinates );
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError == null );
	}
	
	public void testDiffDis() throws Exception {
		//test_ai3CK2
		double[] a = { 1.5, 3};
		double[] b = { 9};
		Centroid ct1 = new Centroid(a);
		Point pt2 = new Point(b);
		Exception expectedError = null;
		try {
			ct1.distancesq(ct1, pt2);
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}

	public void testSameDis() throws Exception {
		//test_h39FED
		double[] a = { 2,5,7};
		double[] b = { 3,6,4};
		Centroid ct1 = new Centroid(a);
		Point pt2 = new Point(b);
		double distancesq=ct1.distancesq(ct1, pt2);
		junit.framework.TestCase.assertTrue( distancesq == 11);
	}
	
	public void testEquCenDiffLength() throws Exception {
		//test_vR43fE
		double[] a = { 2,5};
		double[] b = { 3,6,4};
		Centroid ct1 = new Centroid(a);
		Centroid ct2 = new Centroid(b);
		Exception expectedError = null;
		try {
			ct1.myequals(ct1, ct2, 0.0001);
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
	
	public void testNotEqCen() throws Exception {
		//test_e3JH4f
		double[] a = { 3.1,6,3.9};
		double[] b = { 3,6,4};
		Centroid ct1 = new Centroid(a);
		Centroid ct2 = new Centroid(b);
		boolean ifequalcentroid=ct1.myequals(ct1, ct2, 0.001);
		junit.framework.TestCase.assertTrue( ifequalcentroid ==false);
	}
	
	public void testEqCen() throws Exception {
		//test_SFH3ru
		double[] a = { 3.0001,6,3.999};
		double[] b = { 3,6,4};
		Centroid ct1 = new Centroid(a);
		Centroid ct2 = new Centroid(b);
		boolean ifequalcentroid=ct1.myequals(ct1, ct2, 0.001);
		junit.framework.TestCase.assertTrue( ifequalcentroid ==true);
	}
	
	public void testEmptyPreC() throws Exception {
		//test_hu7sd8
		double[] a = { 2,5,9};
		Centroid ct1 = new Centroid(a);
		List<Centroid> preC = new ArrayList<Centroid>();
		List<Centroid> nowC = new ArrayList<Centroid>();
		nowC.add(ct1);
		Exception expectedError = null;
		try {
			ct1.CentroidChange(preC, nowC);
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
	
	public void testNullNowC() throws Exception {
		//test_v4vWEf
		double[] a = { 2,5,9};
		Centroid ct1 = new Centroid(a);
		List<Centroid> preC = new ArrayList<Centroid>();
		List<Centroid> nowC = new ArrayList<Centroid>();
		nowC.add(ct1);
		Exception expectedError = null;
		try {
			ct1.CentroidChange(preC, nowC);
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
		
	public void testCentroidChange() throws Exception {
		//test_s5Ec3d
		double[] a = { 3.00000001,6,3.99999999};
		double[] b = { 3,6,4};
		double[] c = { 2.0000000001,4.9999999998,3};
		double[] d = { 2,5,3};
		Centroid ct1 = new Centroid(a);
		Centroid ct2 = new Centroid(b);
		Centroid ct3 = new Centroid(c);
		Centroid ct4 = new Centroid(d);
		List<Centroid> preC = new ArrayList<Centroid>();
		List<Centroid> nowC = new ArrayList<Centroid>();
		preC.add(ct1);
		preC.add(ct4);
		nowC.add(ct2);
		nowC.add(ct3);
		boolean ifcenchange = ct1.CentroidChange(preC, nowC);
		junit.framework.TestCase.assertTrue( ifcenchange ==false);
	}
	
	public void testNotCentroidChange() throws Exception {
		//test_UXc3aR
		double[] a = { 3.0001,6,3.999};
		double[] b = { 3,6,4};
		double[] c = { 2.000001,4.99999,3};
		double[] d = { 2,5,3};
		Centroid ct1 = new Centroid(a);
		Centroid ct2 = new Centroid(b);
		Centroid ct3 = new Centroid(c);
		Centroid ct4 = new Centroid(d);
		List<Centroid> preC = new ArrayList<Centroid>();
		List<Centroid> nowC = new ArrayList<Centroid>();
		preC.add(ct1);
		preC.add(ct2);
		nowC.add(ct3);
		nowC.add(ct4);
		boolean ifcenchange = ct1.CentroidChange(preC, nowC);
		junit.framework.TestCase.assertTrue( ifcenchange ==true);
	}
	
	public void testOptimalCentroid() throws Exception{
		//test_ciC82F
		double[] a = { 2,5,9};
		Centroid ct1 = new Centroid(a);
		List<Centroid> cl=ct1.OptimalCentroid(4.3);
		List<Centroid> cl2=ct1.OptimalCentroid(4.4);
		System.out.println(cl.size());
		System.out.println(cl2.size());
	}

}
