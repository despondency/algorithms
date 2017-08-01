import org.junit.Test;

public class KosarajuSharirTest {
		@Test
		public void testKosarajuSharir(){
			KosarajuSharir kosarajuSharir = new KosarajuSharir(13); // 12 V, because we start from 0
			kosarajuSharir.connect(6,0);
			kosarajuSharir.connect(2,0);
			kosarajuSharir.connect(0,1);
			kosarajuSharir.connect(3,2);
			kosarajuSharir.connect(4,2);
			kosarajuSharir.connect(2,3);
			kosarajuSharir.connect(4,3);
			kosarajuSharir.connect(5,4);
			kosarajuSharir.connect(6,4);
			kosarajuSharir.connect(11,4);
			kosarajuSharir.connect(3,5);
			kosarajuSharir.connect(0,5);
			kosarajuSharir.connect(7,6);
			kosarajuSharir.connect(8,6);
			kosarajuSharir.connect(6,8);
			kosarajuSharir.connect(6,9);
			kosarajuSharir.connect(7,9);
			kosarajuSharir.connect(12,9);
			kosarajuSharir.connect(9,10);
			kosarajuSharir.connect(9,11);
			kosarajuSharir.connect(9,12);
			kosarajuSharir.connect(10,12);
			kosarajuSharir.connect(11,4);
			kosarajuSharir.connect(11,12);
			kosarajuSharir.connect(12,9);
			kosarajuSharir.SCC();
			int components[] = kosarajuSharir.getComponents();
			int szOfEachComponent[] = kosarajuSharir.getSizeOfEachComponentForId();
			System.out.println("here");
		}
}
