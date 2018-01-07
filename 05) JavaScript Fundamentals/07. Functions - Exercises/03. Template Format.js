function quiz(inputArray) {
    let xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    xml += "<quiz>\n";

    for (let i = 0; i < inputArray.length; i += 2) {
        xml += "    <question>\n";
        xml += "        " + inputArray[i] + "\n";
        xml += "    </question>\n";

        xml += "    <answer>\n";
        xml += "        " + inputArray[i + 1] + "\n";
        xml += "    </answer>\n";
    }

    xml += "</quiz>\n";

    console.log(xml);
}