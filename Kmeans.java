package assignment1;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Kmeans{
	  
		private List<Point> _dataArray;//original data
		private int _K;
		private int _maxClusterTimes;
		private int _times;
		private List<Cluster> _clusterList;
		private List<Centroid> _centroidList;
		
		//test_JH324c - Success
		public Kmeans(int K, int maxClusterTimes, List<Point> dataArray) throws Exception {
			//test_CAD44y - Success
			if (K < 1) {throw new IllegalArgumentException("K must greater than 0");}
			_K=K;
			//test_ec6Re3 - Success
			if (maxClusterTimes < 0) {throw new IllegalArgumentException("maxClusterTimes must greater than 0");}
			_maxClusterTimes=maxClusterTimes;
			//test_34eG42D - Success
			if (dataArray == null) {throw new IllegalArgumentException("There is no points in the original dataset");}
			//test_JJACE4 - Success
			if (_K> dataArray.size()) {throw new Exception("There is no enough points for being divided into K clusters");}
			_dataArray=dataArray;
			_times=0;
		}
		
		public void settimes(int times) {_times=times;}
		
		public int getK() {return _K;}
			
		public int getMaxClusterTimes() {return _maxClusterTimes;}
		
		public int gettimes() {return _times;}
		
		public List<Point> getdataArray() {return _dataArray;}
		
		/**create a clusterlist with k clusters whose centroids are precenter and whose list of points is empty
		 * @param preCenter
		 */
		//test_c95hGd - Success
		public void setclusterList (List<Centroid> preCenter) {
			_clusterList = new LinkedList<Cluster>();
			for(int i=0;i<preCenter.size();i++) {
				List<Point> pointslist = new LinkedList<Point>();
				_clusterList.add(new Cluster(preCenter.get(i),pointslist));
			}
		}
		
		/** And then add points to some cluster in the cluster list
		 * @param index
		 * @param point
		 */	
		public void setclusterList2 (int index, Point point) {
			_clusterList.get(index).addpoint(point);
		}
		
		public List<Cluster> getclusterList(){
			return _clusterList;
		}
			
		public void clearclusterList () {
			for (int i=0;i<_clusterList.size();i++) {
				_clusterList.remove(i);
			}
		}
			
		/** for the first time, we shuffle all the points and choose the first k elements to be 
		 * the centroids for the first clustering, and then add them to the centroid list.
		 * @throws Exception
		 */		
		//test_OPJ43c - Success
		public void setcentroidList() throws Exception{
			_centroidList = new LinkedList<Centroid>();
			List<Point> oridata=getdataArray();
			Collections.shuffle(oridata);
			for (int i = 0; i < _K; i++) {
				Centroid c=new Centroid(oridata.get(i).getcoordinates());
				_centroidList.add(c);
			}
		}	
		
		/** calculate the new centroid for each cluster in the cluster list and then get a centroid list
		 * @throws Exception
		 */	
		public void setcentroidList2() throws Exception {
			for(int i=0;i<_clusterList.size();i++) {
					Centroid newc=_clusterList.get(i).newCentroid();
					_centroidList.set(i,newc);
			}
		}
		
		public List<Centroid> getcentroidList() {
			return _centroidList;
		}
		
		/** for clustering processes, calculate the distance of these points
		 *  and each centroid, then put every point into the cluster the centroid locates.
		 * @param preCenter
		 * @throws Exception
		 */	
		//test_wfeaG3 - Success
		public void clustering (List<Centroid> preCenter) throws Exception{	
			//cluster list haven't been created for the first time
			setclusterList(preCenter);
			for (Point points: getdataArray()) {
				int cennum = 0;
				double minDis =preCenter.get(0).distancesq(preCenter.get(0), points);
				for (int j = 0; j < preCenter.size() ; j++) {
					if (minDis > preCenter.get(j).distancesq(preCenter.get(j), points)) {
						    minDis = preCenter.get(j).distancesq(preCenter.get(j), points);
						    cennum = j;						
					}
				}	
				/*cluster list already exists. There are k clusters, and we find the corresponding centroid 
				in the cluster, and then add point into it*/
				setclusterList2(cennum, points);
			}
			_times+=1;
		}
	
		/**Gragh the Original all points and all the centroids
		 * 
		 */
		public void draw() {
			JFrame jrame = new JFrame();
			JPanel jpanel= new JPanel() {
				private static final long serialVersionUID=1L;
				@Override
				public void paint(Graphics graphics) {
					super.paint(graphics);
					for (int i=0;i<_dataArray.size();i++) {
						graphics.fillRect((int)_dataArray.get(i).getcoordinates()[0]*10, 
								(int)_dataArray.get(i).getcoordinates()[1]*10,1,1);
					}
					graphics.setColor(Color.RED);
					for (int i=0; i<_centroidList.size();i++) {
						graphics.fillRect((int)_centroidList.get(i).getcoordinates()[0]*10-5,
								(int)_centroidList.get(i).getcoordinates()[1]*10-5, 5, 5);
					}
				}
			};
			jrame.add(jpanel);
			jrame.setSize(1000,1000);
			jrame.setVisible(true);
			jrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		/** To see the optimal distance sum of points and centroid within a range
		 * @throws Exception
		 */
		public void OptimalDistSum() throws Exception {
			double[] cor= {4.44/2,4.44/2};
			Centroid c=new Centroid(cor);
			List<Centroid> CenList=c.OptimalCentroid(4.3);
			clustering (CenList);
			Fitness f=new Fitness();
			System.out.println("Min: "+f.InnerDistSum(getclusterList()));
			
			List<Centroid> CenList2=c.OptimalCentroid(4.4);
			clustering (CenList2);
			Fitness f2=new Fitness();
			System.out.println("Max: "+f2.InnerDistSum(getclusterList()));
		}
		
	
	}	

