<?php

declare(strict_types=1);

require_once './Playlist.php';
require_once './Song.php';
require_once './InvalidSongExceptions.php';

use Van\Classes\Seventh\Playlist;
use Van\Classes\Seventh\Song;


$songsCount = intval(trim(fgets(STDIN)));
$playlist = new Playlist();

for ($i = 0; $i < $songsCount; $i++) {
    $songInfo = explode(';', trim(fgets(STDIN)));

    $artist = $songInfo[0];
    $name = $songInfo[1];
    $duration = $songInfo[2];

    try {
        $song = new Song($artist, $name, $duration);
        $playlist->addSong($song);
    } catch (Exception $e) {
        echo $e->getMessage() . PHP_EOL;
    }
}

echo $playlist;
