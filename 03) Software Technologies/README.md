<h1 align="center"><em>Software Technologies - July 2017</em></h1>
 
<br />

 ## *The introductory course to the most used Web Development Technologies*
>  ### *HTML and CSS*
 ```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello HTML</title>
</head>
<body>
    <h1>Hello HTML!</h1>
    <p>I am <strong>Ivan</strong>. I am from <a href="https://www.plovdiv24.bg/">Plovdiv</a>.</p>
    <p>I study <em>Software Technologies</em> at <a href="https://softuni.bg">SoftUni</a>.</p>
    <p>back to <a href="home.html">home</a></p>
</body>
</html>
 ```
>  ### *PHP*
 ```PHP
 <?php
$sortedLines = "";
if(isset($_GET['lines'])){
    $lines = explode("\n", $_GET['lines']);
    $lines = array_map('trim', $lines);
    sort($lines, SORT_STRING);
    $sortedLines = implode("\n", $lines);
}
?>
 ```
>  ### *JavaScript*
 ```JavaScript
 function solve(args) {
    let text = args.join(",");
    let words = text
        .split(/\W+/)
        .filter(w => w.length > 0);
    let result = [];

    for (let word of words) {
        if (word === word.toUpperCase()) {
            result.push(word);
        }
    }

    console.log(result.join(', '))
}
 ```
>  ### *Java*
```Java
import java.util.*;

public class IndexLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        char[] letters = scan.nextLine().toLowerCase().toCharArray();
        
        for (char letter : letters) {
            System.out.printf("%s -> %d\n", letter,
                    Character.valueOf(letter) - Character.valueOf('a'));
        }
    }
}
```

<p align="center">
<a href="https://softuni.bg/trainings/1621/software-technologies-july-2017">Course Page</a> <br />
<a href="https://judge.softuni.bg/Contests#!/List/ByCategory/41/Software-Technologies">Judge</a>
<p>
