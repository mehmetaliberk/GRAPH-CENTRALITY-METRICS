import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws FileNotFoundException {
//      Facebook graphýnda graphtan baðýmsýz vertexlerden dolayý kod heap space hatasý verdi ne kadar uðraþtýysam da çözemedim
//		bundan dolayý facebookla ilgili iþlemleri yorum satýrýna aldým fakat karate club graphý sýkýntýsýz çalýþmakta
		
		
		
		
		
		
		
		Graph karate = new Graph(35);
//      Graph facebook = new Graph(1519);
		for (int i = 0; i < karate.size; i++) {
			Node node = new Node(String.valueOf(i));
			karate.addNode(node) ;
		}
//		for (int i = 0; i < facebook.size; i++) {
//			Node node = new Node(String.valueOf(i));
//			karate.addNode(node) ;
//		}

		File file = new File("karate_club_network.txt");
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String data = sc.nextLine();
			String[] tempData = data.split(" ");
			karate.getNodes().get(Integer.parseInt(tempData[0])).add_neighbor(karate.getNodes().get(Integer.parseInt(tempData[1])));
		}
		sc.close();
//		File file2 = new File("facebook_social_network.txt");
//		Scanner sc2 = new Scanner(file2);
//		while (sc2.hasNextLine()) {
//			String data = sc2.nextLine();
//			String[] tempData = data.split(" ");
//			facebook.getNodes().get(Integer.parseInt(tempData[0])).add_neighbor(facebook.getNodes().get(Integer.parseInt(tempData[1])));
//		}
//		sc2.close();
		List<String> ShortestPathsKarate = new ArrayList<>();
		for (int i = 1; i < 35; i++) {
			for (int j = i + 1; j < 35; j++) {
				String sp=new ShortestPath(karate.getNodes().get(i), karate.getNodes().get(j)).FindPath();
				sp=sp.replace("[", "");
				sp=sp.replace(" ", "");
				sp=sp.replace("]", "");
				ShortestPathsKarate.add(sp);
			}

		}
//		List<String> ShortestPathsFacebook = new ArrayList<>();
//		for (int i = 1; i < 1519; i++) {
//			for (int j = i + 1; j < 1519; j++) {
//				String sp=new ShortestPath(karate.getNodes().get(i), karate.getNodes().get(j)).FindPath();
//				sp=sp.replace("[", "");
//				sp=sp.replace(" ", "");
//				sp=sp.replace("]", "");
//				ShortestPathsFacebook.add(sp);
//			}
//
//		}

		System.out.println("2019510022 Mehmet Ali Berk:");
		System.out.print("Zachary Karate Club Network – The Highest Node for Betweennes and the value: ");
		findBetweenness(ShortestPathsKarate,karate.size);
		System.out.println();
		System.out.print("Zachary Karate Club Network – The Highest Node for Closeness and the value: ");
		findCloseness(ShortestPathsKarate,karate.size);
//		System.out.print("Facebook Social Network - The Highest Node for Betweennes and the value : ");
//		findBetweenness(ShortestPathsFacebook,facebook.size);
//		System.out.println();
//		System.out.print("Facebook Social Network - The Highest Node for Closeness and the value : ");
//		findCloseness(ShortestPathsFacebook,facebook.size);
//		
	}
	
	
	
	
	public static void findBetweenness(List<String> ShortestPaths,int NumOfNodes) {
		int[]nodes=new int[NumOfNodes];
		for (int i = 1; i < nodes.length; i++) {
			nodes[i]=0;
		}
		for (int i = 0; i < ShortestPaths.size(); i++) {
			String path=ShortestPaths.get(i);
			String[] tempPath = path.split(",");
			for (int j = 0; j < tempPath.length; j++) {
				if(tempPath[j]!="") {
				nodes[Integer.parseInt(tempPath[j])]++;
				}
			}
		}
		int betweenness=indexOfMax(nodes);
		System.out.print(betweenness+" - ");
		System.out.print(nodes[betweenness]);
	}
	
	public static void findCloseness(List<String> ShortestPaths,int NumOfNodes) {
		int[]nodes=new int[NumOfNodes];
		for (int i = 1; i < nodes.length; i++) {
			nodes[i]=0;
		}
		nodes[0]=999;
		for (int i = 0; i < ShortestPaths.size(); i++) {
			String path=ShortestPaths.get(i);
			String[] tempPath = path.split(",");
			for (int j = 0; j < tempPath.length; j++) {
				if(tempPath[j]!="") {
				nodes[Integer.parseInt(tempPath[j])]+=tempPath.length;
				}
			}
		}
		int closeness=indexOfSmallest(nodes);
		System.out.print(closeness+" - ");
		System.out.print((double)1/nodes[closeness]);
	
	}
	
	
	
	public static int indexOfMax(int array[]) {
	    if (array.length == 0) {
	        return -1; 
	    }
	    int max = array[0];
	    int pos = 0;

	    for(int i=1; i<array.length; i++) {
	        if (max < array[i]) {
	            pos = i;
	            max = array[i];
	        }
	    }
	    return pos;
	}
	
	public static int indexOfSmallest(int[] array) {
	    int imin = 0;
	    for (int i = 1; i < array.length; i++) {
	        if (array[i] < array[imin]) {
	            imin = i;
	        }
	    }
	    return imin;
	}
	
}