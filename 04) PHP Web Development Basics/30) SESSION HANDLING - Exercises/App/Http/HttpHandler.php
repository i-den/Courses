<?php


namespace Http;


use Core\DataBinderInterface;
use Core\TemplateInterface;

abstract class HttpHandler
{
    /**
     * @var TemplateInterface
     */
    protected $template;

    /**
     * @var DataBinderInterface
     */
    protected $dataBinder;

    public function __construct(TemplateInterface $template, DataBinderInterface $dataBinder)
    {
        $this->template = $template;
        $this->dataBinder = $dataBinder;
    }

    public function render(string $templateName, $data = null)
    {
        $this->template->render($templateName, $data);
    }

    public function redirect(string $url)
    {
        header('Location: ' . $url);
        exit;
    }
}
