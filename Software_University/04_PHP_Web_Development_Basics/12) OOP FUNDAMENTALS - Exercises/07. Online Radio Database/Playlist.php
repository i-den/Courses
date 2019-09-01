<?php


namespace Van\Classes\Seventh;


class Playlist
{
    /** @var Song[] */
    private $songs = array();

    private $totalDurationInSeconds = 0;

    public function __toString()
    {
        $playlistOutput = 'Songs added: ' . $this->getTotalSongs() . PHP_EOL;
        $playlistOutput .= 'Playlist Length: ' . $this->getPlaylistLenght();

        return $playlistOutput;
    }

    public function addSong(Song $song)
    {
        $this->songs[] = $song;
        $this->totalDurationInSeconds += $song->getTotalSeconds();
    }

    private function getTotalSongs(): int
    {
        return count($this->songs);
    }

    private function getPlaylistLenght(): string
    {
        $seconds = $this->totalDurationInSeconds % 60;
        $minutes = intval($this->totalDurationInSeconds / 60) % 60;
        $hours = intval(($this->totalDurationInSeconds / 60) / 60) % 24;

        $seconds = str_pad($seconds, 2, '0', STR_PAD_LEFT) . 's';
        $minutes = str_pad($minutes, 2, '0', STR_PAD_LEFT) . 'm';

        return $hours . ' ' . $minutes . ' ' . $seconds;
    }
}
