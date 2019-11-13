package assignment1;

import static java.lang.Math.pow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Centroid extends Point {
	
	public Centroid(double[] coordinates) throws Exception {
		//test_RG5sg3 - Success
		//test_4veFE8 - Success
		//test_cjsD35 - Success
		super(coordinates);	
	}
	
	/**Calculate the distance square of the a point and a centroid
	 * @param ct1
	 * @param pt2
	 * @return
	 * @throws Exception
	 */
	public double distancesq(Centroid ct1, Point pt2)  throws Exception {
		//test_ai3CK2 - Success
		if (ct1.getlength() != pt2.getlength()) {throw new Exception("The points are not in the same dimension");}
		double dissq=0;
		for (int i=0;i<ct1.getlength();i++) {
			dissq+=pow(ct1.getcoordinates()[i]-pt2.getcoordinates()[i],2);
		}
		//test_h39FED - Success
		return dissq;
	}
	
	/**To see if the two centroids have the same coordinates within a tolerence
	 * @param c1
	 * @param c2
	 * @param tolerence
	 * @return
	 * @throws Exception
	 */
	public boolean myequals(Centroid c1, Centroid c2, double tolerence) throws Exception {
		//test_vR43fE - Success
		 if(c1.getlength() != c2.getlength()) {throw new Exception("The points are not in the same dimension");}
		 boolean bol=true;
		 for(int i = 0; i < c1.getlength(); i++){
			 if(Math.abs(c1.getcoordinates()[i] - c2.getcoordinates()[i]) > tolerence){
				//test_e3JH4f - Success
				 bol=false;
				 break;
			}
		 }
		//test_SFH3ru - Success
		 return bol;
	}
	/**To see if all the corresponding two centroids have the same coordinates in two centriods lists
	 * @param preC
	 * @param nowC
	 * @return
	 * @throws Exception
	 */
	public boolean CentroidChange(List<Centroid> preC, List<Centroid> nowC) throws Exception {
		//test_hu7sd8 - Success  //test_v4vWEf - Success
		if (preC == null || nowC == null ||preC.size()<1||nowC.size()<1) {throw new Exception("There are no elements in the centroid list");}
		boolean bol=false;
		List<Centroid> preC2=List.copyOf(preC);
		for(int i=0;i<preC2.size();i++) {
			if(!myequals(preC2.get(i),nowC.get(i),0.00001)){
				//test_s5Ec3d - Success 
				bol=true;
			}
		}
		//test_UXc3aR - Success 
		return bol;
	}
	
	/** Calculate the sum of distances of all the points and the optimal centroids, and compare with the Kmeans result
	 * @return
	 * @throws Exception
	 */
	public List<Centroid> OptimalCentroid(double opdis) throws Exception {
		//test_ciC82F - Success 
		double[] cor= {opdis/2,opdis/2};
		Centroid cc=new Centroid(cor);
		List<Centroid> cenL=new LinkedList<Centroid>();
		for(int j=0;;j++) {
			cor[1]=opdis/2+j*opdis;
			if(cor[1]>=99) {
				break;
			}
			for(int i=0;;i++) {
				cor[0]=opdis/2+i*opdis;
				cc=new Centroid(Arrays.copyOf(cor,cor.length));
				if(cor[0]>=99) {
					cor[0]=opdis/2;
					break;
					}
				cenL.add(cc);
			}
		}
		return cenL;		
	}

	
}
