<?php


namespace Core;


class Template implements TemplateInterface
{
    const TEMP_FOLDER = __DIR__ . DIRECTORY_SEPARATOR . '..' . DIRECTORY_SEPARATOR . 'Templates' . DIRECTORY_SEPARATOR;
    const TEMP_EXT = '.php';

    public function render(string $templateName, $data = null, $pageInfo = null)
    {
        require_once self::TEMP_FOLDER . 'partials' . DIRECTORY_SEPARATOR . 'header' . self::TEMP_EXT;
        require_once self::TEMP_FOLDER . $templateName . self::TEMP_EXT;
        require_once self::TEMP_FOLDER . 'partials' . DIRECTORY_SEPARATOR . 'footer' . self::TEMP_EXT;
        exit();
    }
}