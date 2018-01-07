function coneVolumeAndArea(coneRadius, coneHeight) {
    let volume = (Math.PI * Math.pow(coneRadius, 2) * coneHeight) / 3;
    let area = Math.PI * coneRadius * (coneRadius + Math.sqrt(Math.pow(coneRadius, 2) + Math.pow(coneHeight, 2)));

    console.log(`volume = ${volume.toFixed(4)}`);
    console.log(`area = ${area.toFixed(4)}`);
}