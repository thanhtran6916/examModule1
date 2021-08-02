function solveEquationFirst (a, b) {
    if (a === 0 && b ===0) {
        document.write("Phương trình có vô số nghiệm");
    } else  if (a === 0 && b !==0) {
        document.write("Phương trình vô nghiệm");
    } else {
        document.write("Phương trình có một nghiệm duy nhất x = " + (-b / a));
    }
}
solveEquationFirst(5, 8);