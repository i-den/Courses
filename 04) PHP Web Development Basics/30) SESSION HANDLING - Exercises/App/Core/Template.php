<?php


namespace Core;


class Template implements TemplateInterface
{
    const TEMPLATE_FOLDER = __DIR__ . '/../Templates/';
    const TEMPLATE_EXTENSION = '.php';

    public function render(string $templateName, $data = null)
    {
        require_once self::TEMPLATE_FOLDER . 'partials/header' . self::TEMPLATE_EXTENSION;
        require_once self::TEMPLATE_FOLDER . $templateName . self::TEMPLATE_EXTENSION;
        require_once self::TEMPLATE_FOLDER . 'partials/footer' . self::TEMPLATE_EXTENSION;
    }
}