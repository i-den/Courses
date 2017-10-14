<?php



class Phone implements ICallable, IBrowsable
{


    public function browseInternet(string $url)
    {
        if (preg_match('/[0-9]/', $url)) {
            throw new \Exception('Invalid URL!' . PHP_EOL);
        }

        echo 'Browsing: ' . $url . '!' . PHP_EOL;
    }

    public function callPhone(string $phoneNumber)
    {
        if (!is_numeric($phoneNumber)) {
            throw new Exception('Invalid number!' . PHP_EOL);
        }
        echo 'Calling... ' . $phoneNumber . PHP_EOL;
    }
}