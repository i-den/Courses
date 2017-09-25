<?php

$input = DateTime::createFromFormat('l', trim(fgets(STDIN)));

echo $input->format('N');
