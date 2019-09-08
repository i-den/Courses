function attachEvents() {
    const baseURL = "https://baas.kinvey.com/appdata";
    const appId = "kid_SyiwyUEFG";

    const kinvUser = "4v9MEMTjXl9A1IarejIS0cJnT05o+sEV8PtOIV6FkuQ=";
    const kinvPasswd = "nZfVZEeeuUFteRZw3bGVniv4tGzU3KC0hgmkkQB4+PA=";
    const authHead = btoa(`${kinvUser}:${kinvPasswd}`);

    const asideDiv = $("#aside");
    const btnLoad = asideDiv.find(".load");
    const btnAdd = asideDiv.find(".add");

    const catchesDiv = $("#catches");

    btnLoad.click(loadCatches);
    btnAdd.click(addCatch);

    loadCatches();


    function loadCatches() {
        $.ajax({
            url: `${baseURL}/${appId}/biggestCatches`,
            method: "GET",
            headers: {
                authorization: `Basic ${authHead}`
            }
        })
            .then(fillCatchesInHTML)
            .catch(handleErr);


        function fillCatchesInHTML(ajaxData) {
            catchesDiv.empty();
            for (let currCatch of ajaxData) {

                let catchDiv = $(`<div class="catch" data-id="${currCatch._id}">`);

                let anglerLabel = $("<label>Angler</label>");
                let anglerInp = $(`<input type="text" class="angler" value="${currCatch.angler}"/>`);

                let weightLabel = $("<label>Weight</label>");
                let weightInp = $(`<input type="number" class="weight" value="${currCatch.weight}"/>`);

                let speciesLabel = $("<label>Species</label>");
                let speciesInp = $(`<input type="text" class="species" value="${currCatch.species}"/>`);

                let locationLabel = $("<label>Location</label>");
                let locationInp = $(`<input type="text" class="location" value="${currCatch.location}"/>`);

                let baitLabel = $("<label>Bait</label>");
                let baitInp = $(`<input type="text" class="bait" value="${currCatch.bait}"/>`);

                let captureTimeLabel = $("<label>Capture Time</label>");
                let captureTimeInp = $(`<input type="number" class="captureTime" value="${currCatch.captureTime}"/>`);

                let btnUpdate = $("<button class=\"update\">Update</button>");
                let btnDel = $("<button class=\"delete\">Delete</button>");

                btnUpdate.click(updateAjax);
                btnDel.click(delAjax);

                catchDiv.append(anglerLabel)
                    .append(anglerInp)
                    .append(weightLabel)
                    .append(weightInp)
                    .append(speciesLabel)
                    .append(speciesInp)
                    .append(locationLabel)
                    .append(locationInp)
                    .append(baitLabel)
                    .append(baitInp)
                    .append(captureTimeLabel)
                    .append(captureTimeInp)
                    .append(btnUpdate)
                    .append(btnDel);

                catchesDiv.append(catchDiv);


                function updateAjax() {
                    if  (!(anglerInp.val()
                        && weightInp.val()
                        && speciesInp.val()
                        && locationInp.val()
                        && baitInp.val()
                        && captureTimeInp.val())
                    )
                        return;
                    console.log("kef");

                    $.ajax({
                        url: `${baseURL}/${appId}/biggestCatches/${currCatch._id}`,
                        method: "PUT",
                        headers: {
                            authorization: `Basic ${authHead}`,
                            contentType: "application/json"
                        },
                        data: {
                            angler: anglerInp.val(),
                            weight: weightInp.val(),
                            species: speciesInp.val(),
                            location: locationInp.val(),
                            bait: baitInp.val(),
                            captureTime: captureTimeInp.val()
                        }
                    })
                        .then(loadCatches);
                }

                function delAjax() {
                    $.ajax({
                        url: `${baseURL}/${appId}/biggestCatches/${currCatch._id}`,
                        method: "DELETE",
                        headers: {
                            authorization: `Basic ${authHead}`,
                            contentType: "application/json"
                        }
                    })
                        .then(() => {
                            catchDiv.remove();
                        })
                }
            }
        }

        function handleErr(ajaxErr) {
            console.warn(ajaxErr);
        }
    }

    function addCatch() {
        let anglerInp = asideDiv.find(".angler");
        let weightInp = asideDiv.find(".weight");
        let speciesInp = asideDiv.find(".species");
        let locationInp = asideDiv.find(".location");
        let baitInp = asideDiv.find(".bait");
        let captureTimeInp = asideDiv.find(".captureTime");

        if (!(anglerInp.val()
                && weightInp.val()
                && speciesInp.val()
                && locationInp.val()
                && baitInp.val()
                && captureTimeInp.val())
        )
            return;

        $.ajax({
            url: `${baseURL}/${appId}/biggestCatches`,
            method: "POST",
            headers: {
                authorization: `Basic ${authHead}`,
                contentType: "application/json"
            },
            data: {
                angler: anglerInp.val(),
                weight: weightInp.val(),
                species: speciesInp.val(),
                location: locationInp.val(),
                bait: baitInp.val(),
                captureTime: captureTimeInp.val()
            }
        })
            .then(succAdd)
            .catch(e => console.warn(e));

        function succAdd(ajaxMsg) {
            anglerInp.val('');
            weightInp.val('');
            speciesInp.val('');
            locationInp.val('');
            baitInp.val('');
            captureTimeInp.val('');
            loadCatches();
        }
    }
}