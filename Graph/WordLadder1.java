package Graph;
import java.util.*;
public class WordLadder1 {
    
     class Pair{
        String word;
        int len;
        Pair(String w,int l)
        {
            word=w;
            len=l;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Queue<Pair> q=new LinkedList<>();
        HashSet<String> s=new HashSet<>(wordList);
        q.add(new Pair(beginWord,1));
        s.remove(beginWord);

        while(!q.isEmpty())
        {
            String word=q.peek().word;
            int len=q.peek().len;
            q.poll();
            if(word==endWord) return len;
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] replaced=word.toCharArray();
                    replaced[i]=ch;
                    String replacedWord=new String(replaced);
                    if(s.contains(replacedWord))
                    {
                        s.remove(replacedWord);
                        q.add(new Pair(replacedWord,len+1));
                    }
                }
            }

        }
        return 0;
    }
}
