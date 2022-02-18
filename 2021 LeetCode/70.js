/*
 * only the dynamic runs as the run time is constrained
 */



//recursive way
var climbStairs = function(n) {
    if(n <= 1) return 1;

    return climbStairs(n-1) + climbStairs(n-2);
};

//recursion with memoization
//keep storing the values as you go down the recursive tree
var climbStairs = function(n, memo={}) {
    if(memo[n] === n) return n;     //return the value if you find the value is stored in the object
    if(n <= 1) return 1;

    memo[n] = climbStairs(n-1, memo) + climbStairs(n-2, memo);
    
    return memo[n];   //will hold the final count for the number of steps you can climb the stairs
};

//dynamic 
var climbStairs = function(n) {
    
    //return if the n is too small, as there are only possible two way to climb stairs
    if(n <= 2) return n;
    
    let arr = new Array(n+1);    //always one size greater than n ...mandatory. 
    arr[1] = 1;
    arr[2] = 2;
    
    for(let i = 3; i <= n; i++){
        arr[i] = arr[i-1] + arr[i-2];
    }
    return arr[n];
};


