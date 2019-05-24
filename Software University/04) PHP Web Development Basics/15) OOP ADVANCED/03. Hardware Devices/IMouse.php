<?php


namespace Van\Classes\Third;


interface IMouse
{
    public function click($leftClick, $x, $y);

    public function move();
}