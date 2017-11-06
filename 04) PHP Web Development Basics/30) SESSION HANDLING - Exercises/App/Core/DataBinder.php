<?php


namespace Core;


class DataBinder implements DataBinderInterface
{

    public function bind(array $form, string $className)
    {
        $classInfo = new \ReflectionClass($className);

        $object = new $className();

        foreach ($form as $key => $value) {
            if ($classInfo->hasProperty($key)) {
                $propertyInfo = $classInfo->getProperty($key);
                $propertyInfo->setAccessible(true);
                $propertyInfo->setValue($object, $value);
            }
        }

        return $object;
    }
}
