<?php


namespace Core;


interface DataBinderInterface
{
    public function bind(array $formData = [], string $className);
}