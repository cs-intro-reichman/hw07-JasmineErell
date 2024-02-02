

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		// System.out.println(existInDictionary(hashTag, dictionary));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0; i<dictionary.length; i++)
		{
			dictionary[i] = in.readLine();
		}

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) 
	{
		boolean flag = false;
		for(int i = 0; i<dictionary.length; i++)
		{
			if (dictionary[i].equals(word))
			{
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty())
		{
            System.out.println("no words to hashtag");
        }
		int beginIndex = 0;
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) 
		{
			String prefix = hashtag.substring(beginIndex, i);
			if (existInDictionary(prefix, dictionary)) 
			{
				System.out.println(prefix);
				beginIndex = i;

			}
			
        }
		
    }

}
