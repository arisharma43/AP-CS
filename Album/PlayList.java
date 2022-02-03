import java.util.Arrays;

public class PlayList
{
	/** Song[] array list instance variable*/
	private Song[] list;
	
	/** default constructor used to set the instance variables to default values*/
	public PlayList()
	{
		// I would recommend setting the length to 1
		list = new Song[1];
		// Then make sure you add 1 song to the list in index 0
		list[0] = new Song();
	}
	
	/** initialization constructor used to set the instance variables
		* @param x the length of the playlist */
	public PlayList(int x)
	{
		// this should set the length of the playlist
		list = new Song[x];
	}
	
	/** modifier method to set the instance variable list
		* @param x the length of the playlist*/
	public void setList(int x)
	{
		// this should set the length of the playlist
		list = new Song[x];
	}
	
	/** accessor method to get the entire playlist
		* @return return the entire playslist as a Song[] array*/
	public Song[] getList()
	{
		return list;
	}
	
	/** method to add a song to the playlist
		* @param x the position in the playlist to add the song
		* @param s the song to add to the playlist*/
	public void addSong(int x, Song s)
	{
		/* you need to check to make sure the array is big enough to add the song
		   if it is not big enough you will need to create a large enough array
			   and then transfer the songs to the new array before assigning the new
			   array back to the list array*/
		
    
    if (x>list.length-1){
      Song[] f = new Song[x+1];
      for(int i=0; i<list.length; i++){
        f[i] = list[i];
      }
      f[f.length-1] = s;
      list = f;
    }else if(list[x]==null){
      list[x] = s;
    }else if(list[list.length-1]==null){
      for(int i=list.length-1;i>=x;i--){
        list[i] = list[i-1];
      }
      list[x]=s;
    }
    else{
      Song[] f = new Song[list.length+1];
      for(int i=0; i<f.length-1;i++){
        if(i < x){
        	f[i] = list[i];
        } else if(i == x) {
        	f[i+1] = list[i];
        	f[i] = s;
		} else {
			f[i+1] = list[i];
        }
      }
      list = f;
    }
	}
	
	/** method to get a song from the playlist
		* @param x the position in the playlist to get the song from
		* @return return the song in the position specified*/
	public Song getSong(int x)
	{
		return list[x];
	}
	
	/** method to get the number of songs in the playlist
		* @return return the number of songs in the playlist*/
	public int numSongs()
	{
		return list.length;
	}
	
	/** method to get the total length of the playlist specified in seconds
		* @return return the length of the playlist in seconds*/
	public int totalLength()
	{
		/* before accessing the length of an individual song you should ensure that the 
				song reference is not null*/
		int length = 0;
		for(int i = 0; i < list.length; i++){
			if(list[i] != null){
			length += list[i].getLength();
			}
		}
		return(length);
	}
	
	/** method to remove any songs from the specified artist
		* @param ar the artist of the songs to remove from the playlist*/
	public void removeArtist(String ar)
	{
		/* to remove the songs with the specified artist you will first need to count the
				occurances of that artist. 
				Then you will need to create a new smaller array
				Then you can copy the songs to the new array excluding the ones from the artist*/
		int keepSongs = 0;
		int shifting = 0;
    //System.out.println(Arrays.toString(list));
		for(Song x : list){
			if(x!=null && (x.getArtist().equals(ar))){
        keepSongs++;
      }
    }
		Song[] f = new Song[keepSongs];
		for(int i = 0; i < list.length; i++){
			if(list[i]!=null && !list[i].getArtist().equals(ar))f[i - shifting] = list[i];
			else shifting++;
		}
		list = f;
	}
	
	/** method to remove any songs longer than the length specified
		* @param length length of songs to removed given in seconds*/
	public void removeLength(int length)
	{
		// same as method above with creating a smaller array
    int keepSongs = 0;
		for(Song x : getList()){
			if(x != null && x.getLength() < length){
        		keepSongs++;
      		}
		}
		Song[] f = new Song[keepSongs];
		int j=0;
		for(int i=0; i < list.length; i++){
			if(list[i] != null && list[i].getLength() < length){
        		f[j] = list[i];
        		j++;
      		}
		}
		list = f;
	}
	
	/** method to shuffle the order of the playlist - use the card shuffling example from the arrays presentation to help*/
	public void shuffle()
	{
		// use the card shuffling example from the arrays presentation to help you with this
		for(int i = 0; i < list.length; i++){
			int swap = i+(int)Math.random()*list.length;
			Song temp = list[i];
			list[i] = list[swap];
			list[swap] = temp;
		}
	}
	
	/** equals method to determine if two playlists are equal
	 * The base class for all classes instantiated into objects in Java is "Object"
		* @param obj the object to be compared
		* @return return true or false if the playlists are equal*/
	public boolean equals(Object obj)
	{
		PlayList pl = (PlayList)obj;
		if(!Arrays.equals(list, pl.getList()))
			return false;
		return true;
	}
	
	/** toString() method to get the instance variables
		* @return return a String containing the instance variablees*/
	public String toString()
	{
		return Arrays.toString(list);
	}
}
