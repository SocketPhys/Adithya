/*
 * SimpleBSTMap
 *
 * Version 1.0
 *
 * 2015-05-14
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Implement the Map interface using a binary search tree
 *
 */

import java.lang.NullPointerException;
import java.util.NoSuchElementException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedList;

public class SimpleBSTMap<K,V> 
    implements Iterable<Map.Entry<K,V>>, SimpleMap<K,V> {

        Node root;
    int used; 
    Comparator<K> ordering;
    static SimpleBSTMap<String,Integer> map;
    static LinkedList <Node>stack;
   
    

    public SimpleBSTMap(Comparator<K> o){
    stack = new LinkedList<Node>;
	root = null;
	used = 0;
	ordering = o;
    }

    public int size() {
	return used;
    }
    
    
    public static void main(String[]args){
    	map = new SimpleBSTMap<String, Integer>(null);
    	map.put("" + 0, 10);
    	map.put("" + 1, 11);
    	map.put("" + 2, 12);
    	
    	
    	map.printStack();
    }
    
    public void inOrderPrint(Node n, int depth) {
	    if (n != null) {
		inOrderPrint(n.left_child, depth+1);
		for (int i = 0; i < depth; i++)
		    System.out.print("  ");
		System.out.println(n.key_value.getKey() + "," + n.key_value.getValue());
		inOrderPrint(n.right_child, depth+1);
	    }
	}
    
    public void printStack(){
    	
    		stack.push((Node) map.root);
    		Node node =  (Node) map.root;
    		 
    		while(stack.size()!=0){
    			if(node.left_child!=null){
    				stack.push(node.left_child);
    				node = node.left_child;
    			}else{
    				if(node.right_child!=null){
    					System.out.println(node.key_value.getKey());
    					stack.push(node.right_child);
    					node = node.right_child;
    				}else{
    					System.out.println(node.key_value.getKey());
    					stack.pop();
    					
    				}
    				
    			}
    		}
    	
    
    }
    
    
    public boolean containsKey(Object key) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();

	TraverseResponse tr = traverse((K) key);
	return tr.self != null;
    }

    public V get(Object key){
    	Node temp = root;
    	return gethelper(key,temp);
    }
   
    public V gethelper(Object key,Node temp){
    	if (key == null) 
    	    return null;
    	
    	if(key.equals(temp.key_value.getKey())){
    		return temp.key_value.getValue();
    	}else if(isLessThan((K) key, temp.key_value.getKey())){
    		if(temp.left_child == null )
        		return null;
    		return gethelper(key,temp.left_child);
    	}else {
    		if(temp.right_child == null )
        		return null;
    		return gethelper(key,temp.right_child);
    	}
    }

    public V put(K key, V value) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();

	TraverseResponse tr = traverse((K) key);
	if (tr.self != null) {
	    return tr.self.key_value.setValue(value);
	}
	else {
	    used++;
	    Node new_node = new Node(key, value);
	    tr.setPointerInParentTo(new_node);

	    // no previous value 
	    return null;
	}
    }

    public V remove(Object key) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();

	TraverseResponse tr = traverse((K) key);
	if (tr.self == null) {
	    // nothing found.
	    return null;
	}

	if (tr.self.left_child == null && tr.self.right_child == null) {  
	    // no child case, just set pointer in parent to null.
	    tr.setPointerInParentTo(null);
	} else if (tr.self.left_child == null && tr.self.right_child != null) {  
	    // only right child
	    tr.setPointerInParentTo(tr.self.right_child);
	} else if (tr.self.left_child != null && tr.self.right_child == null) {  
	    // only left child
	    tr.setPointerInParentTo(tr.self.left_child);
	} else {
	    // go left once and then right until it is null. 
	    // This gives you a node with a key adacent to
	    // this node and that new node is guaranteed to 
	    // have at most one child.  
	    // We swap the new node in for this one.
	    Node replacement = tr.self.left_child;
	    Node replacement_parent = tr.self;
	    while (replacement.right_child != null) {
		replacement_parent = replacement;
		replacement = replacement.right_child;
	    }
	    if (replacement_parent == tr.self) {
		// only went left once (so replacement is left-child of self)
		replacement.right_child = tr.self.right_child;
		// replacement.left_child remains the same
		    tr.setPointerInParentTo(replacement);
	    } else {
		// went right at least once (so replacement is right-child of parent)
		replacement_parent.right_child = replacement.left_child;
		replacement.left_child  = tr.self.left_child;
		replacement.right_child = tr.self.right_child;
		tr.setPointerInParentTo(replacement);
	    }
	}

	used--;
	return tr.self.key_value.getValue();
    }

    public Iterator<Map.Entry<K,V>> iterator() {
	return new Itr();
    }

    class Itr
	implements java.util.Iterator<Map.Entry<K,V>> {

	MyLinkedList<Node> stack;

	public Itr() {
	    stack = new MyLinkedList<Node>();

	    //System.out.println("Printing tree:");
	    //inOrderPrint(root, 0);

	    // push root and left tree down to minimum element
	    Node n = root;
	    while (n != null) {
		stack.add(0, n);
		n = n.left_child;
	    }
	    //printStack();
	}

	public boolean hasNext() {
	    return stack.size() != 0;
	}

	public Map.Entry<K,V> next() {
	    //printStack();

	    Node ret_val = stack.remove(0);
	    Node n = ret_val.right_child;
	    while (n != null) {
		stack.add(0, n);
		n = n.left_child;
	    }
	    return ret_val.key_value;
	}

	public void printStack() {
	    System.out.print("Stack=");
	    for (Node n : stack) {
		System.out.print(n.key_value.getKey() + " ");
	    }
	    System.out.println();
	}
	
	public void inOrderPrint(Node n, int depth) {
	    if (n != null) {
		inOrderPrint(n.left_child, depth+1);
		for (int i = 0; i < depth; i++)
		    System.out.print("  ");
		System.out.println(n.key_value.getKey() + "," + n.key_value.getValue());
		inOrderPrint(n.right_child, depth+1);
	    }
	}
	//public void remove() {
	//    listItr.remove();
	//}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	
 }

    class Node {
	public Pair<K,V> key_value;
	public Node left_child;
	public Node right_child;
	
	public Node(K k, V v) {
	    key_value = new Pair(k,v);
	    left_child = null;
	    right_child = null;
	}
    }

    class TraverseResponse {
	// node that matches the key
	// null if none match
	public Node self;

	// parent of self
	// or, if self is null, node it should be added to
	// if it should be added to root, this is null.
	public Node parent;  

	// true node is (or should be) left child of the parent
	// false if right child.  
	// undefined if parent should be root.
	public boolean is_left_child;

	public TraverseResponse() {
	    self = null;
	    parent = null;
	    is_left_child = false;
	}

	void setPointerInParentTo(Node n) {
	    if (parent == null) {
		root = n;
	    } else if (is_left_child) {
		parent.left_child = n;
	    } else {
		parent.right_child = n;
	    }
	}	    
    }

    boolean isLessThan(K k1, K k2) {
	if (ordering != null) {
	    return ordering.compare(k1, k2) < 0;
	}
	else {
	    // assume they are Comparable
	    return ((Comparable<K>) k1).compareTo(k2) < 0;
	}
    }

    TraverseResponse traverse(K k) {
	TraverseResponse ret_val = new TraverseResponse();
	
	ret_val.parent = null;
	ret_val.self = root;
	while (ret_val.self != null) {
	    if (k.equals(ret_val.self.key_value.getKey())) {
		return ret_val;
	    } else if (isLessThan(k, ret_val.self.key_value.getKey())) {
	        ret_val.parent = ret_val.self;
		ret_val.is_left_child = true;
		ret_val.self = ret_val.self.left_child;
	    } else {
	        ret_val.parent = ret_val.self;
		ret_val.is_left_child = false;
		ret_val.self = ret_val.self.right_child;
	    }
	}

	// got to edge of tree and key is not present.
	return ret_val;
    }

	
}
