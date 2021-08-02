function searchIndexOfArray(element, array) {
    let index = -1;
    for (let i = 0; i < array.length; i++) {
        if (element == myArray[i]) {
            index = i;
            return index;
        }
    }
    return index;
}

let myArray = [1, 2, 3, 4, 5, 6];
let result = searchIndexOfArray(2, myArray);

if (result === -1) {
    document.write("Không tìm thấy giá trị ở trong mảng");
} else {
    document.write("Giá trị có nằm trong mảng và ở vị trí có index là: " + result);
}