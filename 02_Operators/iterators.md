Loops : while, do-while, for, for-each


// while — runs as long as condition is true
int i = 0;
while(i < 4){
    System.out.println(i);
    i++;
}


// do-while — runs at least once, checks condition after
i = 0;
do {
    System.out.println(i);
    i++;
} while(i < 4);


// for — when number of iterations is known
for(int j = 0; j < 4; j++){
    System.out.println(j);
}


// for-each — used to iterate over arrays and collections
int[] nums = {10, 20, 30, 40};
for(int n : nums){
    System.out.println(n);
}

String[] names = {"Alice", "Bob", "Charlie"};
for(String name : names){
    System.out.println(name);
}


// break — exits the loop immediately
for(int j = 0; j < 10; j++){
    if(j == 5) break;
    System.out.println(j);   // prints 0 to 4
}


// continue — skips current iteration, moves to next
for(int j = 0; j < 5; j++){
    if(j == 2) continue;
    System.out.println(j);   // prints 0, 1, 3, 4  (skips 2)
}


// nested loops
for(int row = 1; row <= 3; row++){
    for(int col = 1; col <= 3; col++){
        System.out.print(row * col + " ");
    }
    System.out.println();
}
