import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTable<>();

        hashTable.put(3, "banana");
        hashTable.put(8, "apple");
        hashTable.put(214, "cucumber");
        hashTable.put(856, "strawberry");
        hashTable.put(100, "coconut");
        hashTable.put(19, "Red Apple");
        hashTable.put(14, "Old banana");

        System.out.println("Значение по ключу: " + hashTable.get(856));
        System.out.println("Размер таблицы: " + hashTable.size());

        hashTable.remove(14);

        System.out.println("Таблица пуста? " + hashTable.isEmpty());
    }

    public static class HashTable<K, V> {
        private static class Entry<K, V> {
            private K key;
            private V value;

            public Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }

            public void setValue(V value) {
                this.value = value;
            }
        }

        private LinkedList<Entry<K, V>>[] table;
        private int size;
        private static final int DEFAULT_CAPACITY = 11;

        public HashTable() {
            table = new LinkedList[DEFAULT_CAPACITY];
            size = 0;
        }

        private int hash(K key) {
            return Math.abs(key.hashCode()) % table.length;
        }

        public void put(K key, V value) {
            int index = hash(key);
            if (table[index] == null) {
                table[index] = new LinkedList<>();
            }

            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
            }
            table[index].add(new Entry<>(key, value));
            size++;
        }

        public V get(K key) {
            int index = hash(key);
            if (table[index] != null) {
                for (Entry<K, V> entry : table[index]) {
                    if (entry.getKey().equals(key)) {
                        return entry.getValue();
                    }
                }
            }
            return null;
        }

        public void remove(K key) {
            int index = hash(key);
            if (table[index] != null) {
                for (Entry<K, V> entry : table[index]) {
                    if (entry.getKey().equals(key)) {
                        table[index].remove(entry);
                        size--;
                        return;
                    }
                }
            }
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }
}