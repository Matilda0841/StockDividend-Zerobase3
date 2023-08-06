package ZeroBase.StockDividend.controller;

import org.apache.commons.collections4.Trie;

public class AutoComplete {
  private Trie trie;
  public AutoComplete(Trie trie){
    this.trie = trie;
  }
  public void add(String s){
    this.trie.put(s,"world");
  }

  public Object get(String s){
    return this.trie.get(s);
  }
}

