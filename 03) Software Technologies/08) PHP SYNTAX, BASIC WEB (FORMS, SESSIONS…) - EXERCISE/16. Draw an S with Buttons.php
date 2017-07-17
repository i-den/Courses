
<?php
for ($i = 0; $i < 4 ; $i++) {
    for ($j = 0; $j < 5; $j++) {
        if ($i == 0 || $j == 0) {
            echo "<button style='background-color:blue'>1</button>";
        } else {
            echo "<button>0</button>";
        }
    }
    echo "<br/>";
}

for ($i = 0; $i < 5; $i++) {
    echo "<button style='background-color:blue'>1</button>";
}

echo "<br/>";

for ($i = 1; $i <= 4; $i++) {
    for ($j = 0; $j < 5; $j++) {
        if ($j == 4 || $i == 4) {
            echo "<button style='background-color:blue'>1</button>";
        }
        else {
            echo "<button>0</button>";
        }
    }

    echo "<br/>";
}
?>