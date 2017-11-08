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

    public function __construct(TemplateInterface $template,
                                DataBinderInterface $dataBinder)
    {
        $this->template     = $template;
        $this->dataBinder   = $dataBinder;
    }

    protected function render(string $templateName, $data = null)
    {
        $this->template->render($templateName, $data);
    }

    protected function redirect(string $url)
    {
        header('Location: ' . $url);
        exit();
    }
}
