package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder2_Better {
    String b;
    Map<String,Integer> map;
    List<List<String>> ans;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans=new ArrayList<>();
        b=beginWord;
        HashSet<String> set=new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        map=new HashMap<>();
        map.put(beginWord,1);
        q.add(beginWord);
        set.remove(beginWord);
        int size=beginWord.length();
        while(!q.isEmpty())
        {
            String word=q.peek();
            q.poll();
            int steps=map.get(word);
            if(word.equals(endWord)) break;

            for(int i=0;i<size;i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] replaced=word.toCharArray();
                    replaced[i]=ch;
                    String replacedWord=new String(replaced);
                    if(set.contains(replacedWord))
                    {
                        q.add(replacedWord);
                        set.remove(replacedWord);
                        map.put(replacedWord,steps+1);
                    }
                }
            }

        }
        if(map.containsKey(endWord)){
            ArrayList<String> x=new ArrayList<>();
            x.add(endWord);
            dfs(endWord,x);
        }
        return ans;

    }
    public void dfs(String word,ArrayList<String> seq)
    {
        if(word.equals(b))
        {
            ArrayList<String> temp=new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        int steps=map.get(word);
        for(int i=0;i<word.length();i++)
        {
            for(char ch='a';ch<='z';ch++)
            {
                char[] replaced=word.toCharArray();
                replaced[i]=ch;
                String replacedWord=new String(replaced);
                if(map.containsKey(replacedWord) && map.get(replacedWord)+1==steps)
                {
                    seq.add(replacedWord);
                    dfs(replacedWord,seq);
                    seq.remove(seq.size()-1);
                }
                
            }

        }
    }
}
