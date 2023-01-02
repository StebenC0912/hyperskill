// modifies count = no. even numbers in range [min, max] 
function countEvens (min, max) {
    count = 0;
    for (const i = min; i <= max; i++) { 
    if (i%2==0) { count++; }
    }
    }
    let count;
    countEvens (5, 10); 
    console.log(count);
    //comment
    // add more comment