package assignment1;

import java.util.*;

public class Fitness {
	public Fitness() {
		
	}
	
	/**Calculate the sum of distance of all the points of each centroid, and then get the sum of all these sums
	 * @param clusterList
	 * @return
	 * @throws Exception
	 */
	//test_eWE7c3 - Success
	public double InnerDistSum(List<Cluster> clusterList) throws Exception {
		double sum=0;
		for(int i=0;i<clusterList.size();i++) {
			Centroid c=clusterList.get(i).getcentroid();
			int length=clusterList.get(i).getpointlist().size();
			for (int j=0;j<length;j++) {
				sum+=Math.sqrt(c.distancesq(c,clusterList.get(i).getpointlist().get(j)));
			}
		}
		return sum;
	}
	
	/**Since the distance of all centroids that are within sqrt(2)*4.5 of each centroid, which is the therotical
	 * diagonal distance between two centroids. I calculate the average distance of all adjacent centroids
	 * @param centroidList
	 * @return
	 * @throws Exception
	 */
	//test_olk23C - Success
	public double OuterCenDist(List<Centroid> centroidList) throws Exception {
		double sum=0;
		int num=0;
		double dis=0;
		for(Centroid c:centroidList) {
			for(Centroid c2:centroidList) {
				dis=Math.sqrt(c.distancesq(c, c2));
				if(dis<=Math.sqrt(2)*4.5) {
					sum+=dis;
					num++;
				}
			}
		}
		return sum/(double)num;	
	}
	
	
}

