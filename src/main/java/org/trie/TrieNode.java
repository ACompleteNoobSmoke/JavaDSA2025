package org.trie;

import java.util.List;
import java.util.Map;

public class TrieNode {
    Character currentCharacter;
    Map<TrieNode, List<Character>> children;
}
