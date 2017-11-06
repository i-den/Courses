<?php


namespace Http;



use Core\TemplateInterface;

abstract class HttpHandlerAbstract
{
    /**
     * @var TemplateInterface
     */
    protected $template;

    public function __construct(TemplateInterface $template)
    {
        $this->template = $template;
    }

    public function render(string $templateName, array $data = null)
    {
        $this->template->render($templateName, $data);
    }

    public function redirect(string $url)
    {
        header('Location: ' . $url);
        exit;
    }
}