
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
		// System.out.println(levenshtein("i", "love"));
		// System.out.println(levenshtein("lisense", "license"));
	}

	public static String tail(String str) 
	{
		if(str.length() == 1)
		{
			return "";
		}
		else 
		{
			return str.substring(1);
		}
	}

	public static int levenshtein(String word1, String word2)
	{
		word1 = lowerCase(word1);
		word2 = lowerCase(word2);
		int tempMin = 0;
		if (word1.length() == 0)
		{
			return word2.length();
		}
		else if(word2.length() == 0)
		{
			return word1.length();
		}
		else if(word1.charAt(0) == word2.charAt(0))
		{
			word1 = word1.substring(1);
			word2 = word2.substring(1);
			return levenshtein(word1, word2);
		}
		else
		{
			// levenshtein(tail(word1), tail(word2));
			tempMin = Math.min(levenshtein(tail(word1), word2), levenshtein(word1, tail(word2)));
			return 1 + Math.min(tempMin, levenshtein(tail(word1), tail(word2)));
		}
		
	}

	public static String[] readDictionary(String fileName) 
	{
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i = 0; i<dictionary.length; i++)
		{
			dictionary[i] = in.readLine();
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) 
	{
		for (int i = 1; i<dictionary.length; i++)
		{
			int min = levenshtein(word, dictionary[0]);
			if (levenshtein(word, dictionary[i])< min)
			{
				min = levenshtein(word, dictionary[i]);
			}
			if (min<threshold) 
			{
				word = dictionary[i];
				break;
			}
		}
		
		return word;
	}

	public static String lowerCase(String s) 
    {
        
        String res = "";
        for (int i = 0; i< s.length(); i++)
        {
            char ch = s.charAt(i);
            int ascii = ch ;
            if (ascii>=65 && ascii<=94)
            {
                int asciiLow = ascii + 32; 
                res = res + ((char)asciiLow);
            }
            else
            {
                res = res + ch;
            }
        }
        return res;
    }

}
