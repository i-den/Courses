<?php

namespace Van\Classes\Seventh;


class InvalidSongException extends \Exception
{

}

class InvalidArtistNameException extends InvalidSongException
{

}

class InvalidSongNameException extends InvalidSongException
{

}

class InvalidSongLengthException extends InvalidSongException
{

}

class InvalidSongMinutesException extends InvalidSongLengthException
{

}

class InvalidSongSecondsException extends InvalidSongLengthException
{

}
