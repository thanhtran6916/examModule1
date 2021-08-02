function countVowelCharacter(array) {
    let vowelCharacter = ["a", "o", "e", "u", "i"];
    let count = 0;
    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < vowelCharacter.length; j++) {
            if (array[i] === vowelCharacter[j]) {
                count++;
            }
        }
    }
    if (count === 0) {
        return false;
    } else {
        return count;
    }
}

let myString = "hom nay toi lam bai tap kiem tra";
let myArray = myString.split("");
let result = countVowelCharacter(myArray);
document.write(result);