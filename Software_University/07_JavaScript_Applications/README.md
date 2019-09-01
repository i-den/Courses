<h1 align="center"><em>JS Applications - юли 2017</em></h1>

 ## *JS in the Web*
 
 >  ### *AJAX / jQuery*
 ```JavaScript
$.ajax({
            url: baseURL + "/.json",
            method: "POST",
            data: JSON.stringify(chatMsg),
            success: function () {
                input.author.val('');
                input.content.val('');
            }
        });
 ```
 
 > ### *Basic async*
 ```JavaScript
 $.ajax({
            url: `${baseURL}/${appId}/biggestCatches`,
            method: "GET",
            headers: {
                authorization: `Basic ${authHead}`
            }
        })
            .then(fillCatchesInHTML)
            .catch(handleErr);
 ```

 <p align="center">
	<a href="https://softuni.bg/trainings/1651/js-applications-july-2017">Course Page</a> <br />
</p>
