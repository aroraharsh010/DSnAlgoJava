package hashMaps;

import java.util.ArrayList;

public class MyHashMap<K, V> {

	private class HMNode {
		K key;
		V value;

	}

	private int size;
	private GenericLinkedList<HMNode>[] buckets;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public MyHashMap() {
		this.buckets = new GenericLinkedList[4];
		this.size = 0;

		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new GenericLinkedList<>();
		}
	}

	public void put(K key, V val) {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);

		if (foundAt == -1) {
			HMNode n2p = new HMNode();
			n2p.key = key;
			n2p.value = val;
			buckets[bi].addLast(n2p);
			size++;
		} else {
			HMNode n2u = buckets[bi].getAt(foundAt);
			n2u.value = val;
		}
		
		double loadingFactor=(this.size*1.0)/buckets.length;
		if(loadingFactor>1.5){
			rehash();
		}

	}

	private void rehash() {
		GenericLinkedList<HMNode>[] oba=buckets;
		buckets=new GenericLinkedList[2*oba.length];
		size=0;
		for(int i=0;i<buckets.length;i++){
			buckets[i]=new GenericLinkedList<>();
		}
		for(int i=0;i<oba.length;i++){
			for(int j=0;j<oba[i].size();j++){
				HMNode node=oba[i].getAt(j);
				put(node.key, node.value);
			}
		}
		
	}

	public boolean containsKey(K key) {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);
		if (foundAt == -1) {
			return false;
		} else
			return true;
	}

	public V get(K key) {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);
		if (foundAt == -1) {
			return null;
		} else {

			HMNode node=buckets[bi].getAt(foundAt);
			return  node.value;
		} 
	}
	public V remove(K key){
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);
		if (foundAt == -1) {
			return null;
		} else {
			HMNode node=buckets[bi].removeAt(foundAt);
			this.size--; 
			return  node.value; 
		}
	}

	private int hashFunction(K key) {
		int bucketIdx = key.hashCode();
		return Math.abs(bucketIdx) % buckets.length;
	}

	private int findInBucket(GenericLinkedList<HMNode> bucket, K key) {
		for (int i = 0; i < bucket.size(); i++) {
			HMNode node = bucket.getAt(i);
			if (node.key.equals(key)) {
				return i;  
			}
		} 

		return -1; 
	}
	
	public ArrayList<K> keyset(){
		
		ArrayList<K> keys=new ArrayList<>();
		for(int i=0;i<buckets.length;i++){
			for(int j=0;j<buckets[i].size();j++){
				keys.add(buckets[i].getAt(j).key);
			}
		}
		return keys;
		
	}
	public void display(){
		for(int i=0;i<buckets.length;i++){
			for(int j=0;j<buckets[i].size();j++){
				System.out.println(buckets[i].getAt(j).key+":"+buckets[i].getAt(j).value+" B:"+i);
			}
		}
	}

}
