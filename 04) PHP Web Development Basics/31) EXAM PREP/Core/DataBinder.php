<?php


namespace Core;


class DataBinder implements DataBinderInterface
{

    public function bind(array $formData = [], string $className)
    {
        $object = new $className;

        foreach ($formData as $key => $value) {
            if (strpos($key, '_')) {
                $key = $this->snakeToCamel($key);
            }

            $methodName = 'set' . ucfirst($key);

            if (method_exists($object, $methodName)) {
                $object->$methodName($value);
            }
        }

        return $object;
    }

    private function snakeToCamel(string $snake_case_string): string
    {
        $allWords = explode('_', $snake_case_string);
        $camelCaseWords = array($allWords[0]);

        for ($i = 1; $i < count($allWords); $i++) {
            $camelCaseWords[] = ucfirst($allWords[$i]);
        }

        return implode($camelCaseWords);
    }
}