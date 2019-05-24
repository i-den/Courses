<?php declare(strict_types=1);
if(isset($_GET['text'])) {
    $text = $_GET['text'];
    preg_match_all('/\w+/', $text, $words);
    $words = $words[0];

    $upperwords = array_filter($words, function($word){
                return strtoupper($word) == $word;
    });
    echo implode(', ', $upperwords);
};
?>
<form>
    <textarea name="text" rows="10"></textarea><br/>
    <input type="submit">
</form>