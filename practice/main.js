const list = [0, 1, '0', 'a', false];
let count = 0;
for (const item of list) {
if (item==0) {
count++;
}
}
console.log(count);
