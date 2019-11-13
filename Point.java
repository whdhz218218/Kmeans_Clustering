package assignment1;
import static java.lang.Math.pow;
public class Point {
	private double[] _coordinates;
	private int _dimension;
	
	
	public Point(double[] coordinates) throws Exception  {
		//test_ad3jDE - Success
		_coordinates =  coordinates;	
		_dimension= coordinates.length;
		//test_g4G3Gd - Success  //test_p3FMGd - Success
		if(coordinates == null || this._dimension < 1 ) {
			throw new Exception( "Need at least one value for the coordinates of the point" );
			}
		}

	public double[] getcoordinates() {return _coordinates;}	
	public int getlength() {return _dimension;}
	
	
	/** Calculate the distance square of the two points
	 * @param pt1
	 * @param pt2
	 * @return
	 * @throws Exception
	 */
	public double distancesq(Point pt1, Point pt2)  throws Exception {
		//test_ef4ggt - Success
		if (pt1.getlength() != pt2.getlength()) {throw new Exception("The points are not in the same dimension");}
		double dissq=0;
		for (int i=0;i<pt1.getlength();i++) {
			dissq+=pow(pt1.getcoordinates()[i]-pt2.getcoordinates()[i],2);
		}
		//test_34jfGR - Success
		return dissq;
	}
	

}
