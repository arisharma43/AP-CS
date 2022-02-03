public class PlayListRunnerPlus
{
	public static void main(String[] args)
	{
		// create object using default constructor
		PlayList test = new PlayList(3);
		test.addSong(0, new Song("s1", "al1", "ar1", 250));
		test.addSong(3, new Song("s4", "al4", "ar4", 350));
      test.addSong(1, new Song("s3", "al3", "ar1", 550));
      test.addSong(1, new Song("s2", "al2", "ar2", 450));
      System.out.println("In Order  " + test);
      test.shuffle();
      System.out.println("Total Length = " + test.totalLength());
      System.out.println("Shuffled  " + test); 
      test.removeArtist("ar1");
      System.out.println("-ar1  " + test); 
      
		PlayList test2 = new PlayList();
		test2.addSong(3, new Song("s4", "al4", "ar4", 350));
		test2.addSong(1, new Song("s3", "al3", "ar1", 550));
      test2.addSong(1, new Song("s2", "al2", "ar2", 450));
      test2.addSong(0, new Song("s1", "al1", "ar1", 250));

      System.out.println("In Order  " + test2);     
      test2.shuffle();
      System.out.println("Shuffled  " + test2); 
      test2.removeLength(400);
      System.out.println("<= 400    " + test2);
	}
}
