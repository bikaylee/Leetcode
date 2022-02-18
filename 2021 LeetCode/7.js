
//very js way to solve this problem
var reverse = function (x) {
    if (x < 0) {
        return -1 * reverse(-x);
    }

    //convert the x to string first --> (x+"") --> converts to string.
    let reverseInt = (x + "").split('').reverse().join('');

    if (reverseInt > (Math.pow(2, 31) - 1)) return 0; //if the number is bigger than +ve 2,147,483,648
    return reverseInt;
};


//not so js way to solve this problem
var reverse = function (x) {
    let negative = false;
    if (x < 0) {
        negative = true;
        x *= -1;   //to make it positive;
    }
    let rev = 0;  //this will be the new container
    while (x >= 1) {
        let remainder = x % 10;
        x = Math.floor(x / 10);
        rev = rev * 10 + remainder;
    }
    if (negative) {
        rev *= -1;
    }
    return (rev < - Math.pow(2, 31) || rev > Math.pow(2, 31) - 1) ? 0 : rev;
};