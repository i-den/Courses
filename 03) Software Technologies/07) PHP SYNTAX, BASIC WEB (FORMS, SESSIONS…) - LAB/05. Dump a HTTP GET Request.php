<form>
    <div>Name:</div>
    <input type="text" name="personName"/>
    <div>Age:</div>
    <input type="text" name="personAge"/>
    <div>Town:</div>
    <select name="townId">
        <option value="10">Sofia</option>
        <option value="20">Plovdiv</option>
        <option value="30">Varna</option>
    </select>
    <div><input type="submit"/></div>
</form>
<?php var_dump($_GET);