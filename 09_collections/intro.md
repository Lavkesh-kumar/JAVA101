# Java Collections

The Collections Framework provides ready-made data structures and algorithms to store and manipulate groups of objects.

## Collection Hierarchy

```
java.util
│
├── Collection (interface)
│     ├── List (interface)
│     │     ├── ArrayList
│     │     └── LinkedList
│     │
│     └── Set (interface)
│           ├── HashSet
│           └── TreeSet
│
└── Map (interface)          ← does NOT extend Collection
      ├── HashMap
      └── LinkedHashMap
```

- `Collection` provides core methods: `add()`, `remove()`, `size()`, `contains()`, `iterator()`
- `Map` is separate — it stores key-value pairs, not individual elements

---

## List

`List` is an ordered, index-based interface that allows duplicates.

### ArrayList

Backed by a dynamic array. Fast random access (`get()`), slow insert/delete in the middle.

```java
import java.util.ArrayList;
import java.util.List;

List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Apple");       // duplicates allowed

list.get(0);             // "Apple"
list.set(1, "Mango");    // replace at index
list.remove("Apple");    // removes first occurrence
list.size();             // 2

for (String item : list) {
    System.out.println(item);
}
```

### LinkedList

Backed by a doubly linked list. Fast insert/delete, slow random access. Also implements `Deque`, so it can be used as a queue or stack.

```java
import java.util.LinkedList;

LinkedList<String> linked = new LinkedList<>();
linked.add("One");
linked.addFirst("Zero");   // insert at front
linked.addLast("Two");     // insert at end
linked.removeFirst();
System.out.println(linked); // [One, Two]
```

---

## Set

`Set` stores unique elements — duplicates are silently ignored.

### HashSet

Unordered. Uses hashing internally for O(1) average lookup.

```java
import java.util.HashSet;

HashSet<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple");   // ignored — duplicate

set.size();         // 2
set.contains("Banana"); // true

for (String item : set) {
    System.out.println(item); // order not guaranteed
}
```

### TreeSet

Sorted in natural (ascending) order. Uses a Red-Black tree internally — O(log n) operations.

```java
import java.util.TreeSet;

TreeSet<Integer> sorted = new TreeSet<>();
sorted.add(5);
sorted.add(1);
sorted.add(3);

System.out.println(sorted);        // [1, 3, 5]
System.out.println(sorted.first()); // 1
System.out.println(sorted.last());  // 5
```

---

## Map

`Map` stores data as **key-value pairs**. Keys are unique; values can repeat.

### HashMap

Unordered. O(1) average for `put()` and `get()`.

```java
import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>();
map.put("Apple", 10);
map.put("Banana", 20);
map.put("Apple", 30);       // key exists — value updated

map.get("Banana");          // 20
map.containsKey("Apple");   // true
map.getOrDefault("Mango", 0); // 0 — safe fallback

// Iterate entries
for (var entry : map.entrySet()) {
    System.out.println(entry.getKey() + " : " + entry.getValue());
}
```

### LinkedHashMap

Maintains **insertion order** — otherwise behaves like `HashMap`.

```java
import java.util.LinkedHashMap;

LinkedHashMap<String, Integer> linked = new LinkedHashMap<>();
linked.put("Banana", 2);
linked.put("Apple", 1);
linked.put("Mango", 3);

System.out.println(linked); // {Banana=2, Apple=1, Mango=3} — insertion order preserved
```

---

## Iterator

`Iterator` provides a standard way to traverse any collection and safely remove elements during iteration.

```java
import java.util.Iterator;

List<String> list = new ArrayList<>(List.of("Apple", "Banana", "Mango"));
Iterator<String> it = list.iterator();

while (it.hasNext()) {
    String item = it.next();
    if (item.equals("Banana")) {
        it.remove(); // safe removal during iteration
    }
}
```

> Avoid modifying a collection directly inside a `for-each` loop — it throws `ConcurrentModificationException`.

---

## Collections Utility Class

`java.util.Collections` provides static helper methods for collection operations.

```java
import java.util.Collections;

List<Integer> nums = new ArrayList<>(List.of(3, 1, 4, 1, 5));

Collections.sort(nums);              // [1, 1, 3, 4, 5]
Collections.reverse(nums);           // [5, 4, 3, 1, 1]
Collections.shuffle(nums);           // random order
Collections.min(nums);               // smallest element
Collections.max(nums);               // largest element
Collections.frequency(nums, 1);      // count of element: 2
```

---

## Generics

Collections use **generics** (`<T>`) to enforce type safety at compile time, avoiding `ClassCastException` at runtime.

```java
List<String> list = new ArrayList<>();
list.add("Hello");
// list.add(42); // compile error — type-safe
```

Without generics, everything is stored as `Object` and requires explicit casting.

---

## Comparison Table

| Class | Ordered | Sorted | Duplicates | Key-Value | Null |
|---|---|---|---|---|---|
| `ArrayList` | ✅ insertion | ❌ | ✅ | ❌ | ✅ |
| `LinkedList` | ✅ insertion | ❌ | ✅ | ❌ | ✅ |
| `HashSet` | ❌ | ❌ | ❌ | ❌ | One `null` |
| `TreeSet` | ✅ sorted | ✅ | ❌ | ❌ | ❌ |
| `HashMap` | ❌ | ❌ | Keys: ❌ | ✅ | One `null` key |
| `LinkedHashMap` | ✅ insertion | ❌ | Keys: ❌ | ✅ | One `null` key |

---

## When to Use Which

| Use Case | Recommended |
|---|---|
| Ordered list with duplicates | `ArrayList` |
| Frequent insert/delete at ends | `LinkedList` |
| Unique elements, fast lookup | `HashSet` |
| Unique elements in sorted order | `TreeSet` |
| Key-value, fast lookup | `HashMap` |
| Key-value, preserve insertion order | `LinkedHashMap` |
