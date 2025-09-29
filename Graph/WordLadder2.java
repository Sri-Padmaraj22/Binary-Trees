package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder2 {
      public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> s=new HashSet<>(wordList);
        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> a=new ArrayList<>();
        a.add(beginWord);
        q.add(a);
        List<List<String>> ans=new ArrayList<>();
        ArrayList<String> usedOnLevel=new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level=0;
        while(!q.isEmpty())
        {
            ArrayList<String> words=q.peek();
            q.poll();
            String word=words.get(words.size()-1);
            if(words.size()>level)
            {
                level++;
                for(String element:usedOnLevel)
                {
                    s.remove(element);
                }
            }
            if(word.equals(endWord))
            {
                if(ans.size()==0) ans.add(words);
                else if(ans.get(0).size()==words.size()) ans.add(words);
            }

            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] replaced=word.toCharArray();
                    replaced[i]=ch;
                    String replacedWord=new String(replaced);
                    if(s.contains(replacedWord))
                    {
                        words.add(replacedWord);
                        ArrayList<String> temp=new ArrayList<>(words);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        words.remove(words.size()-1);
                    }
                }
            }
        }    
        return ans;

    }
}

