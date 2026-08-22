Collections in Java :

All collection classes (ArrayList, List, HashSet, HashMap) implement the Collection interface.
Collection interface provides basic methods like add(), remove(), size(), contains(), iterator() etc.

Hierarchy :
    Collection (interface)
        |-- List (interface)  -->  ArrayList
        |-- Set  (interface)  -->  HashSet
    Map (interface)           -->  HashMap   // Map does NOT extend Collection


--------------------------------------------------------------
ArrayList
--------------------------------------------------------------

- Ordered, index-based, allows duplicates.
- Dynamic in size (grows automatically).

import java.util.ArrayList;

ArrayList<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Apple");   // duplicates allowed

list.get(0);         // Apple
list.remove("Banana");
list.size();         // 2

for(String item : list){
    System.out.println(item);
}


--------------------------------------------------------------
List (interface)
--------------------------------------------------------------

- List is an interface, ArrayList is its implementation.
- You can declare using List interface for flexibility.

import java.util.List;
import java.util.ArrayList;

List<String> list = new ArrayList<>();
list.add("One");
list.add("Two");
list.add("Three");

System.out.println(list.get(1));  // Two


--------------------------------------------------------------
HashSet
--------------------------------------------------------------

- Unordered, does NOT allow duplicates.
- Uses hashing internally.

import java.util.HashSet;

HashSet<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple");   // duplicate, will be ignored

set.size();         // 2

for(String item : set){
    System.out.println(item);  // order not guaranteed
}


--------------------------------------------------------------
HashMap
--------------------------------------------------------------

- Stores data in key-value pairs.
- Keys are unique, values can be duplicate.
- Unordered.

import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>();
map.put("Apple", 10);
map.put("Banana", 20);
map.put("Apple", 30);   // key already exists, value will be updated

map.get("Banana");      // 20
map.containsKey("Apple");  // true
map.size();             // 2

for(String key : map.keySet()){
    System.out.println(key + " : " + map.get(key));
}


--------------------------------------------------------------
Quick Comparison
--------------------------------------------------------------

| Class      | Ordered | Duplicates | Key-Value | Null allowed  |
|------------|---------|------------|-----------|---------------|
| ArrayList  | YES     | YES        | NO        | YES           |
| HashSet    | NO      | NO         | NO        | ONE null      |
| HashMap    | NO      | Keys: NO   | YES       | ONE null key  |

