<?php

namespace Van\Classes\Seventh;


class Song
{
    /** @var  string */
    private $name;

    /** @var  string */
    private $artist;

    /** @var  string */
    private $duration;

    public function __construct(string $artist, string $name, string $duration)
    {
        $this->setArtist($artist)
            ->setName($name)
            ->setDuration($duration);
    }

    private function setName(string $name): Song
    {
        if (strlen($name) < 3 || strlen($name) > 30) {
            throw new InvalidSongNameException(
                "Song name should be between 3 and 30 symbols."
            );
        }

        $this->name = $name;

        return $this;
    }

    private function setArtist(string $artist): Song
    {
        if (strlen($artist) < 3 || strlen($artist) > 20) {
            throw new InvalidArtistNameException(
                '"Artist name should be between 3 and 20 symbols."'
            );
        }

        $this->artist = $artist;

        return $this;
    }

    private function setDuration(string $duration): Song
    {
        $timeInfo = explode(':', $duration);
        $minutes = intval($timeInfo[0]);
        $seconds = intval($timeInfo[1]);

        if ($minutes < 0 || $minutes > 15) {
            throw new InvalidSongMinutesException(
                '"Song minutes should be between 0 and 14."'
            );
        } else if ($seconds < 0 || $seconds > 59) {
            throw new InvalidSongSecondsException(
                '"Song seconds should be between 0 and 59."'
            );
        }

        $this->duration = $duration;

        return $this;
    }

    public function getTotalSeconds(): int
    {
        $durationInfo = explode(':', $this->duration);
        $minutes = intval($durationInfo[0]);
        $seconds = intval($durationInfo[1]);

        return ($minutes * 60) + $seconds;
    }
}
