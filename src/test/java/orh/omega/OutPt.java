package orh.omega;

public class OutPt {
	public void poke(int y) {
		int u =0 ;
		for (int i = 0; i <= y; i++) {
			for (int j = y; j > 0; j--) {
				u = i + j;
				if(u == y){
					System.out.println("Combinations "+i+" "+j);
					break;
				}
			}
			
		}

	}
	public static void main(String[] args){
		OutPt h = new OutPt();
		h.poke(37);
	}
}	
