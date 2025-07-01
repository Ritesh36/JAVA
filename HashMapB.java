import java.util.*;

public class HashMapB {
    static class HashMap<K, V> {

        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private java.util.LinkedList<Node>[] bucket;
        private int N;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.bucket = new java.util.LinkedList[N];
            for(int i=0; i<4; i++) {
                this.bucket[i] = new java.util.LinkedList<Node>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            java.util.LinkedList<Node> ll = bucket[bi];
            int di = 0;

            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key.equals(key)) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            java.util.LinkedList<Node>[] oldBucket = bucket;
            bucket = new java.util.LinkedList[2 * N];
            N = 2 * N;

            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new java.util.LinkedList<>();
            }

            //nodes -> add in bucket
            for(int i=0; i<oldBucket.length; i++) {
                java.util.LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = bucket[bi].get(di);
                node.value = value;
            } else {
                bucket[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n / N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = bucket[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public boolean containKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = bucket[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<bucket.length; i++) {
                java.util.LinkedList<Node> ll = bucket[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 140);
        hm.put("China", 139);
        hm.put("US", 50);
        hm.put("Uk", 40);

        System.out.println(hm.get("India"));
    }
}